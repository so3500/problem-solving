/*
* 문제: 1012 유기농 배추 / 280 ms
* link: https://www.acmicpc.net/problem/1012
* 알고리즘: DFS, BFS
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

public class Boj_1012 {

	static boolean[][] map, visited;
	static int[] rows = { -1, 0, 1, 0 }, cols = { 0, 1, 0, -1 };
	static int M, N, K, minCnt;

	public static void main(String[] args) {
		int T, t;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (t = 0; t < T; t++) {
			init(sc);
			solve();
			System.out.println(minCnt);
		}
		sc.close();
	}

	public static void init(Scanner sc) {
		N = sc.nextInt(); // 세로
		M = sc.nextInt(); // 가로
		K = sc.nextInt();
		map = new boolean[M][N];
		visited = new boolean[M][N];
		int r, c, i;
		for (i = 0; i < K; i++) {
			c = sc.nextInt();
			r = sc.nextInt();
			map[r][c] = true;
		}
		minCnt = 0;
	}

	public static void solve() {
		int r, c;
		for (r = 0; r < M; r++) {
			for (c = 0; c < N; c++) {
				if (map[r][c] && !visited[r][c]) {
					visited[r][c] = true;
					dfs(r, c);
					minCnt++;
				}
			}
		}
	}

	public static void dfs(int r, int c) {
		int toR, toC;

		for (int i = 0; i <= 3; i++) {
			toR = r + rows[i];
			toC = c + cols[i];
			if (toR < 0 || toC < 0 || M <= toR || N <= toC || visited[toR][toC] || !map[toR][toC])
				continue;
			visited[toR][toC] = true;
			dfs(toR, toC);
		}
	}
}
