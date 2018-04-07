/*
* 문제: 1949. [모의 SW 역량테스트] 등산로 조성 / 142 ms
* link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq
* 알고리즘: DFS
* 풀이방법:
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
*
* */


package swexpert;

import java.util.Scanner;

public class SE_1949 {

	static int N, K, maxH, maxLen;
	static int[][] map;
	static boolean[][] visited;
	static int[] rows = { -1, 0, 1, 0 };
	static int[] cols = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, t, row, col;
		T = sc.nextInt();
		for (t = 1; t <= T; t++) {
			init(sc);
			for (row = 0; row < N; row++) {
				for (col = 0; col < N; col++) {
					if (map[row][col] == maxH) {
						visited[row][col]=true;
						dfs(row, col, 1, false);
						visited[row][col]=false;
					}
				}
			}
			System.out.println("#" + t + " " + maxLen);
		}

	}

	static void init(Scanner sc) {
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		maxH = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				map[row][col] = sc.nextInt();
				maxH = Integer.max(maxH, map[row][col]);
			}
		}
		maxLen = Integer.MIN_VALUE;
	}

	static void dfs(int row, int col, int len, boolean oper) {
		maxLen = Integer.max(maxLen, len);
		int toRow, toCol;

		for (int i = 0; i < 4; i++) {
			toRow = row + rows[i];
			toCol = col + cols[i];
			if (toRow < 0 || toCol < 0 || N <= toRow || N <= toCol || visited[toRow][toCol])
				continue;
			visited[toRow][toCol] = true;
			// 지형을 k(1 to K) 만큼 깎아서 등산로를 조성하는 경우
			// 9 11 인 경우 K:3 이면 3만큼 깎아서 9 8 로 등산로를 조성할 수 있다
			// 반례: map[row][col]-1 값을 넣을 경우 9 3 -> 9 8
			// 반례: map[toRow][toCol]-1 값을 넣을 경우 9 11 -> 9 10
			for(int k=1; k<=K; k++) {
				if (!oper && map[toRow][toCol] - k < map[row][col]) {
					map[toRow][toCol] -= k;
					dfs(toRow, toCol, len + 1, true);
					map[toRow][toCol] += k;
				}
			}
			// 지형을 깎지 않고 등산로를 조성하는 경우
			if (map[row][col] > map[toRow][toCol]) {
				dfs(toRow, toCol, len + 1, oper);
			}
			visited[toRow][toCol] = false;				
		}
	}
}
