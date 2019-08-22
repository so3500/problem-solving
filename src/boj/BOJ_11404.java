/*
* 문제: 11404 플로이드
* link: https://www.acmicpc.net/problem/11404
* 알고리즘: 프로이드-워셜 알고리즘
* 풀이방법:
*
*/

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11404 {

	static class Solution {
		int N;
		final int MAX_VALUE = 100001;
		int[][] graph;

		public void solve() {
			initGraph();
			floyd();
			printGraph();
		}

		private void initGraph() {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			int M = sc.nextInt();
			graph = new int[N][N];
			for (int r = 0; r < N; r++) {
				Arrays.fill(graph[r], MAX_VALUE);
				graph[r][r] = 0;
			}
			for (int m = 0; m < M; m++) {
				int from = sc.nextInt() - 1;
				int to = sc.nextInt() - 1;
				int cost = sc.nextInt();
				graph[from][to] = Integer.min(graph[from][to], cost);
			}
			sc.close();
		}

		private void floyd() {
			for (int mid = 0; mid < N; mid++) {
				for (int start = 0; start < N; start++) {
					for (int end = 0; end < N; end++) {
						graph[start][end] = Integer.min(graph[start][end], graph[start][mid] + graph[mid][end]);
					}
				}
			}
		}

		private void printGraph() {
			StringBuilder sb = new StringBuilder();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (graph[r][c] == MAX_VALUE) {
						graph[r][c] = 0;
					}
					sb.append(graph[r][c]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

}
