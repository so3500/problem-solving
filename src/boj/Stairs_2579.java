package boj;

import java.util.Scanner;

public class Stairs_2579 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int N, i;
        int[][] DP;
        int[] S;

        N = sc.nextInt() + 2;
        S = new int[N];
        DP = new int[N][2];

        for (i = 2; i < N; i++) {
            S[i] = sc.nextInt();
        }
        /*
            DP[i][0]: 0번째 계단에서 시작하여 i번째 계단으로 왔을 때 최대값(1계단 전에서 점프한 경우)
            DP[i][1]: 0번째 계단에서 시작하여 i번째 계단으로 왔을 때 최대값(2계단 전에서 점프한 경우)
        */
        for (i = 2; i < N; i++) {
            DP[i][0] = S[i] + DP[i - 1][1]; // S + beforeOneStair
            DP[i][1] = S[i] + Integer.max(DP[i - 2][0], DP[i - 2][1]); // S + beforeTwoStairs
        }

        System.out.println(Integer.max(DP[N - 1][0], DP[N - 1][1]));
    }
}
