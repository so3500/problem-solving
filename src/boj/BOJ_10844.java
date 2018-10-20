/*
* 문제: 10844 쉬운 계단 수
* link: https://www.acmicpc.net/problem/10844
* 알고리즘: DP
* 풀이방법:
*	점화식 활용
*	
*	길이가 N 일 때, 마지막 수가 L일 경우의 계단 수
*	dp[N][L] = dp[N - 1][L - 1] + dp[N - 1][L + 1] 
*
*	L =    0    => dp[N][L] = dp[N - 1][L + 1]
*	L = (1 ~ 8) => dp[N][L] = dp[N - 1][L - 1] + dp[N - 1][L + 1]
*	L =    9    => dp[N][L] = dp[N - 1][L - 1]
*
*	link http://mygumi.tistory.com/260
*/

package boj;

import java.util.Scanner;

public class BOJ_10844 {

	static class Solution {
		final int DIV_NUM = 1000000000;
		int N = 0;
		int[][] DP;

		private void init() {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			DP = new int[N + 1][10];
			for (int num = 1; num <= 9; num++) {
				DP[1][num] = 1;
			}
			sc.close();
		}

		private void solve() {
			computeDP();
			int stepNum = getStepNum();
			System.out.println(stepNum);
		}

		private void computeDP() {
			for (int digitNum = 2; digitNum <= N; digitNum++) {
				for (int num = 0; num <= 9; num++) {
					if (num >= 1 && num <= 8) {
						DP[digitNum][num] = (DP[digitNum - 1][num - 1] + DP[digitNum - 1][num + 1]) % DIV_NUM;
					} else if (num == 0) {
						DP[digitNum][num] = DP[digitNum - 1][num + 1];
					} else if (num == 9) {
						DP[digitNum][num] = DP[digitNum - 1][num - 1];
					}
				}
			}
		}

		private int getStepNum() {
			int sum = 0;
			for (int num = 0; num <= 9; num++) {
				sum += DP[N][num];
				sum %= DIV_NUM;
			}
			return sum;
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.init();
		solution.solve();
	}

}
