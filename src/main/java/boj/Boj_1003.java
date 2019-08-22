/*
 * 문제: 1003 피보나치 함수 / 132 ms
 * link: https://www.acmicpc.net/problem/1003
 * 알고리즘: DP
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package boj;

import java.util.Scanner;

public class Boj_1003 {

    static int[][] DP = new int[41][2];


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T, t, i, N;
        init(sc);
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            System.out.println(DP[N][0] + " " + DP[N][1]);
        }

    }

    static void init(Scanner sc) {
        DP[0][0] = 1;
        DP[0][1] = 0;
        DP[1][0] = 0;
        DP[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            DP[i][0] = DP[i - 1][0] + DP[i - 2][0];
            DP[i][1] = DP[i - 1][1] + DP[i - 2][1];
        }
    }

}
