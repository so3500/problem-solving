/*
* 문제: 14500 테트로미노 / 1156 ms
* link: https://www.acmicpc.net/problem/14500
* 알고리즘: DFS
* 풀이방법:
* 	각 (row, col) 에서 상하좌우로 이동하는 dfs를 수행
* 		길이 = 4 일 때 
* 			테트로미노가 놓인 값에 쓰인 수들의 최대값 구함
* 		길이 < 4 일 때
* 			dfs 수행
* 
* 	위 함수는 T 자형 테트로미노를 제외한 모든 테트로미노의 경우를 다룰 수 있다.
* 	T 자형의 테트로미노는 dfs2, dfs3 함수를 통해 처리한다
* 
* 	최적화: l, T, o 자형 테트로미노는 dp를 이용하여 최적화 가능
* 
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

public class Boj_14500 {

	static int N, M, maxSum;
	static int[] rows = { -1, 0, 1, 0, -1, 1, -1, -1 };
	static int[] cols = { 0, 1, 0, -1, -1, -1, 1, -1 };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row, col;
		init(sc);
		for (row = 0; row < N; row++) {
			for (col = 0; col < M; col++) {
				visited[row][col]=true;
				dfs(row, col, 1, map[row][col]);
				if (col <= M - 3) dfs2(row, col, 1, map[row][col]);
				if (row <= N - 3) dfs3(row, col, 1, map[row][col]);
				visited[row][col]=false;
			}
		}
		System.out.println(maxSum);
		sc.close();
	}

	static void init(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int row=0; row<N; row++) {
			for(int col=0; col<M; col++) {
				map[row][col]=sc.nextInt();
			}
		}
		maxSum = 0;
	}

	static void dfs(int row, int col, int len, int sum) {
		if (len == 4) {
			maxSum = Integer.max(maxSum, sum);
		} else {
			int toRow, toCol;
			for (int i = 0; i < 4; i++) {
				toRow = row + rows[i];
				toCol = col + cols[i];
				if (!isValid(toRow, toCol)) continue;
				visited[toRow][toCol] = true;
				dfs(toRow, toCol, len + 1, sum + map[toRow][toCol]);
				visited[toRow][toCol] = false;
			}
		}
	}

	// 가로 3 + (row - 1, col - 1) or (row + 1, col - 1) 블록
	static void dfs2(int row, int col, int len, int sum) {
		int toRow, toCol;
		if (len == 3) {
			for (int i = 4; i <= 5; i++) {
				toRow = row + rows[i];
				toCol = col + cols[i];
				if (!isValid(toRow, toCol)) continue;
				maxSum = Integer.max(maxSum, sum + map[toRow][toCol]);
			}
		} else {
			dfs2(row, col + 1, len + 1, sum + map[row][col + 1]);
		}
	}

	// 세로 3 + (row - 1, col - 1) or (row - 1, col + 1) 블록 
	static void dfs3(int row, int col, int len, int sum) {
		int toRow, toCol;
		if (len == 3) {
			for (int i = 6; i <= 7; i++) {
				toRow = row + rows[i];
				toCol = col + cols[i];
				if (!isValid(toRow, toCol)) continue;
				maxSum = Integer.max(maxSum, sum + map[toRow][toCol]);
			}
		} else {
			dfs3(row + 1, col, len + 1, sum + map[row + 1][col]);
		}
	}

	static boolean isValid(int row, int col) {
		if (row < 0 || col < 0 || N <= row || M <= col || visited[row][col]) return false;
		else return true;
	}
}
