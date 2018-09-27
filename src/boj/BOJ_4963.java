/*
* 문제: 4963 섬의개수
* link: https://www.acmicpc.net/problem/4963
* 알고리즘: DFS, BFS
* 풀이방법:
*	각 섬(map[r][c] = true)에서 bfs 탐색
*	탐색하면서 방문처리
*	bfs 탐색을 한 횟수 = 섬의 개수
*/

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4963 {

	static class Solution {
		int rowLen, colLen;
		int[] rowDir = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] colDir = { -1, 0, 1, 1, 1, 0, -1, -1 };
		boolean[][] visited;
		boolean[][] map;

		class Node {
			int row;
			int col;

			public Node(int row, int col) {
				this.row = row;
				this.col = col;
			}
		}

		public void solve() {
			Scanner sc = new Scanner(System.in);
			while (true) {
				colLen = sc.nextInt();
				rowLen = sc.nextInt();
				if (rowLen == 0 && colLen == 0) {
					break;
				}
				initMap(sc);
				System.out.println(getIslandNum());
			}
			sc.close();
		}

		private void initMap(Scanner sc) {
			visited = new boolean[rowLen][colLen];
			map = new boolean[rowLen][colLen];
			for (int row = 0; row < rowLen; row++) {
				for (int col = 0; col < colLen; col++) {
					int mapInfo = sc.nextInt();
					if (mapInfo == 0) {
						map[row][col] = false;
					} else if (mapInfo == 1) {
						map[row][col] = true;
					}
				}
			}
		}

		private int getIslandNum() {
			int islandNum = 0;
			for (int row = 0; row < rowLen; row++) {
				for (int col = 0; col < colLen; col++) {
					if (!visited[row][col] && map[row][col]) {
						bfs(row, col);
						islandNum++;
					}
				}
			}
			return islandNum;
		}

		private void bfs(int row, int col) {
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(row, col));
			visited[row][col] = true;
			while (!q.isEmpty()) {
				Node node = q.remove();
				for (int idx = 0; idx < rowDir.length; idx++) {
					int toRow = node.row + rowDir[idx];
					int toCol = node.col + colDir[idx];
					if (isValid(toRow, toCol)) {
						visited[toRow][toCol] = true;
						q.add(new Node(toRow, toCol));
					}
				}
			}
		}

		private boolean isValid(int row, int col) {
			if (row >= 0 && row < rowLen && col >= 0 && col < colLen && !visited[row][col] && map[row][col]) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

}
