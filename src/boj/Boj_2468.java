/*
* 문제: 2468 안전 영역 / 424 ms
* link: https://www.acmicpc.net/problem/2468
* 알고리즘: DFS
* 풀이방법:
* 	물의 최저 깊이부터 최대 깊이 까지 각 물의 깊이에 대해 dfs를 수행한다.
*  	dfs 함수가 최초로 호출되는 수가 안전영역의 개수이다.
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*   입력 N, H 일 때 
*   각 지역의 높이의 최대 ~ 최고 높이 차가 가장 크고, 이 때 각 h(1 to H)마다O(H) N^2 의 크기인 2차원 배열에서O(N^2) DFS를 수행하는 경우O(N^2)
*   O(N^4*H)
*
* 공간복잡도(Space Complexity)
*   입력 N일 때 N*N 크기의 2차월 배열을 사용하므로
*   O(N^2)
*
* */

package boj;

import java.util.Scanner;

public class Boj_2468 {

	static int N, maxSafeArea, maxHeight, minHeight;
	static int[][] map;
	static boolean[][] visited, copy;
	static int[] rows = { -1, 0, 1, 0 };
	static int[] cols = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int safeArea;
		init(sc);
		for (int h = minHeight; h < maxHeight; h++) {
			safeArea = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c] && h < map[r][c]) {
						dfs(r, c, h);
						safeArea++;
					}
				}
			}
			load(); // visited 복구
			maxSafeArea = Integer.max(maxSafeArea, safeArea);
		}
		System.out.println(maxSafeArea);
	}

	static void init(Scanner sc) {
		N = sc.nextInt();
		map = new int[N][N];
		copy = new boolean[N][N];
		visited = new boolean[N][N];
		maxHeight = Integer.MIN_VALUE;
		minHeight = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				maxHeight = Integer.max(maxHeight, map[r][c]);
				minHeight = Integer.min(minHeight, map[r][c]);
			}
		}
		maxSafeArea = 1;
	}

	static void dfs(int r, int c, int height) {
		int toR, toC;
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			toR = r + rows[i];
			toC = c + cols[i];
			// 범위를 넘어가는 경우, 이미 방문한 곳인 경우, 물에 잠긴 영역인 경우 pass
			if (toR < 0 || toC < 0 || N <= toR || N <= toC || visited[toR][toC] || map[toR][toC] <= height)
				continue;
			dfs(toR, toC, height);
		}
	}

	static void load() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				visited[r][c] = copy[r][c];
			}
		}
	}
}
