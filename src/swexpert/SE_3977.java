/*
 * 문제: 3977 페르마의 크리스마스 정리 / 1146 ms
 * link: https://www.swexpertacademy.com/main/talk/codeBattle/problemDetail.do?contestProbId=AWIYJna6khUDFAVH&categoryId=AWH9yInKEWcDFAUG&categoryType=BATTLE
 * 알고리즘: 에라토스테네스의 체
 * 풀이방법:
 *      에라토스테네스의 체 알고리즘을 활용하여 범위 내의 소수정보를 미리 구함
 *      L, R 입력 후 L 부터 R 까지 조건을 만족하면 카운트
 *      예외상황) 2도 1+1로 표현가능함.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력에 상관없이 10^6 길이의 숫자범위에 대해서 에라토스테네스의 체를 구해야 함.
 *   참고로, 에라토스테네스의 체 시간복잡도는 입력 N에 대하여 O(loglogN)
 *   입력 L 부터 R 까지 선형 탐색
 *
 * 공간복잡도(Space Complexity)
 *   입력에 상관없이 일정한 길이의 1차원 배열 사용
 *   O
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_3977 {

    static int SIZE_OF_CHECK = 1000001;
    static boolean[] prime = new boolean[SIZE_OF_CHECK];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, L, R, cnt;
        T = sc.nextInt();
        Arrays.fill(prime, true);
        getPrime();
        for (t = 1; t <= T; t++) {
            L = sc.nextInt();
            R = sc.nextInt();
            cnt = 0;
            for (i = L; i <= R; i++) {
                if (i % 4 == 1 && prime[i]) cnt++;
                else if (i==2 && prime[i]) cnt++;
            }
            System.out.println("#" + t + " " + cnt);
        }
    }

    static void getPrime() {
        int temp;
        prime[1] = false;
        for (int i = 2; i < SIZE_OF_CHECK; i++) {
            if (!prime[i]) continue;
            temp = i;
            while (true) {
                temp += i;
                if (temp >= SIZE_OF_CHECK) break;
                prime[temp] = false;
            }
        }
    }
}
