/*
* 문제: 1010 다리놓기
* link: https://bibibim.tistory.com/5
*/

package boj;

import java.util.Scanner;

public class BOJ_1010 {

	static class Solution {
		// bridge[N][M]: 강 서쪽에 N개, 강 동쪽에 M개의 다리가 있을 때 다리를 지을 수 있는 경우의 수
		int[][] bridge; 

		public void solve() {
			initBridge();
			Scanner sc = new Scanner(System.in);
			int testCase = sc.nextInt();
			for (int t = 0; t < testCase; t++) {
				int N = sc.nextInt();
				int M = sc.nextInt();
				System.out.println(bridge[N][M]);
			}
			sc.close();
		}

		private void initBridge() {
			final int SIZE = 30;
			bridge = new int[SIZE][SIZE];
			for (int m = 1; m < SIZE; m++) {
				bridge[1][m] = m;
			}
			for (int n = 2; n < SIZE; n++) {
				for (int m = n; m < SIZE; m++) {
					bridge[n][m] = bridge[n - 1][m - 1] + bridge[n][m - 1];
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

}
