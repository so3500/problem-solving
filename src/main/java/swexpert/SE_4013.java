/*
 * 문제: 4013. [모의 SW 역량테스트] 특이한 자석 / 133 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH
 * 알고리즘: 구현
 * 풀이방법:
 *      자석을 리스트로 표현
 *      빨간색 화살표 위치: index 0
 *      자석의 오른쪽 붙어있는 위치: index 2
 *      자석의 왼쪽 붙어있는 위치: index 6
 *      자석을 시계방향으로 회전: HEAD에 위치한 elm을 TAIL에 추가
 *      자석을 반시계방향으로 회전: TAIL에 위치한 elm을 HEAD에 추가
 *
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *   입력에 상관없이 일정한 크기의 메모리를 사용하므로
 *   O(1)
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SE_4013 {

    static int N, K, LEFT, RIGHT, HEAD, TAIL;
    static int[] direction = new int[4];
    static List<Integer>[] magnet = new List[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, start, dir, score;
        T = sc.nextInt();
        RIGHT = 2;
        LEFT = 6;
        HEAD = 0;
        TAIL = 7;
        for (t = 1; t <= T; t++) {
            init(sc);
            for (i = 0; i < K; i++) {
                start = sc.nextInt() - 1;
                dir = sc.nextInt();
                rotation(start, dir);
            }
            score = getScore();
            System.out.println("#" + t + " " + score);
        }
    }

    static void init(Scanner sc) {
        K = sc.nextInt();
        for (int i = 0; i < 4; i++) {
            magnet[i] = new LinkedList<>();
            for (int j = 0; j < 8; j++) {
                magnet[i].add(sc.nextInt());
            }
        }
    }

    static void rotation(int start, int dir) {
        int elm, i;
        Arrays.fill(direction, 0);
        direction[start] = dir;
        // 시작 자석에서 왼쪽으로 탐색
        for (i = start - 1; i >= 0; i--) {
            if (magnet[i].get(RIGHT) != magnet[i + 1].get(LEFT))
                direction[i] = -1 * direction[i + 1];
            else break;
        }
        // 시작 자석에서 오른쪽으로 탐색
        for (i = start + 1; i <= 3; i++) {
            if (magnet[i - 1].get(RIGHT) != magnet[i].get(LEFT))
                direction[i] = -1 * direction[i - 1];
            else break;
        }
        // 회전할 자석에 대해서 회전
        for (i = 0; i < 4; i++) {
            if (direction[i] == -1) {           // 시계 방향
                elm = magnet[i].remove(HEAD);
                magnet[i].add(TAIL, elm);
            } else if (direction[i] == 1) {     // 반시계 방향
                elm = magnet[i].remove(TAIL);
                magnet[i].add(HEAD, elm);
            }
        }
    }

    static int getScore() {
        int score, scoreSum;
        score = 1;
        scoreSum = 0;
        for (int i = 0; i < 4; i++) {
            if (magnet[i].get(HEAD) == 1) scoreSum += score;
            score *= 2; // score = (score << 1)
        }
        return scoreSum;
    }

}
