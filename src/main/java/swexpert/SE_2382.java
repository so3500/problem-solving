/*
 * 문제: 2382. [모의 SW 역량테스트] 미생물 격리 / 640 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl
 * 알고리즘: 구현
 * 풀이방법:
 *      미생물 정보를 담은 객체를 리스트로 관리
 *      미생물 수 정보를 담은 정보를 2차원 배열에서 관리
 *
 *      미생물 이동 시 리스트안의 객체에 대해 연산
 *          이때, 외벽에 도착한 미생물에 대해 처리
 *      이동이 끝난 뒤 2차원배열에서 미생물의 수가 2 이상인 곳을 탐색
 *          만약 있으면, 해당 row, col 인 미생물을 list 에서 찾아서 제거
 *                       미생물 수 합하기
 *                       수가 많은 군집의 방향 따르기
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SE_2382 {

    static class Creature {
        int num, direction, row, col;

        Creature(int row, int col, int num, int direction) {
            this.row = row;
            this.col = col;
            this.num = num;
            this.direction = direction;
        }

    }

    static int N, K, M, sum;
    static List<Creature> cList = new LinkedList<>();
    static int[][] map = new int[100][100];
    static int[] rows = {0, -1, 1, 0, 0};
    static int[] cols = {0, 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t;
        T = sc.nextInt();
        List<Creature> rmList = new LinkedList<>();

        for (t = 1; t <= T; t++) {
            init(sc);
            while (M-- > 0) {
                move(); // 미생물 이동
                process(rmList); // 미생물 처리
            }
            // 총 미생물 수 구하기 & 정리
            sum = 0;
            for (Creature c : cList) {
                sum += c.num;
            }
            // 출력
            System.out.println("#" + t + " " + sum);
        }
    }

    static void init(Scanner sc) {
        int k, row, col, num, direction;
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        for (row = 0; row < N; row++) {
            Arrays.fill(map[row], 0);
        }
        cList.clear();
        for (k = 0; k < K; k++) {
            row = sc.nextInt();
            col = sc.nextInt();
            num = sc.nextInt();
            direction = sc.nextInt();
            cList.add(new Creature(row, col, num, direction));
            map[row][col]++;
        }
    }

    static void move() {
        for (Creature c : cList) {
            map[c.row][c.col]--;
            c.row += rows[c.direction];
            c.col += cols[c.direction];
            map[c.row][c.col]++;
            // 외벽에 올 경우
            if (c.row == 0 || c.row == N - 1 || c.col == 0 || c.col == N - 1) {
                if (c.direction == 1) c.direction = 2;
                else if (c.direction == 2) c.direction = 1;
                else if (c.direction == 3) c.direction = 4;
                else if (c.direction == 4) c.direction = 3;
                c.num /= 2;
            }
        }
    }

    static void process(List<Creature> rmList) {
        int row, col, dir, num, maxNum;
        for (row = 0; row < N; row++) {
            for (col = 0; col < N; col++) {
                // 미생물이 한 자리에 모이는 경우
                if (map[row][col] > 1) {
                    dir = 0;
                    num = 0;
                    maxNum = 0;
                    for (Creature c : cList) {
                        if (c.row == row && c.col == col) {
                            num += c.num;
                            if (maxNum < c.num) {
                                maxNum = c.num;
                                dir = c.direction;
                            }
                            rmList.add(c);
                        }
                    }
                    cList.removeAll(rmList);
                    cList.add(new Creature(row, col, num, dir));
                    rmList.clear();
                }
            }
        }
    }
}
