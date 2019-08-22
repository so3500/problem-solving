/*
* 문제: 5656. [모의 SW 역량테스트] 벽돌 깨기
* problem-link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo
* solution-link: https://bibibim.tistory.com/6
*/

package swexpert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SE_5656 {

	static class Node {
		int r;
		int c;
		int num;

		public Node(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	static int N;
	static int W;
	static int H;
	static int ans;
	static int candidateCnt;
	static int blockCnt;
	static int[][] map;
	static int[][] copyMap;
	static boolean findMinAns;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			init(sc);
			ans = Integer.MAX_VALUE;
			findMinAns = false;
			findAns(0, 0, new int[N]);
			if (blockCnt >= N) {
				ans = Integer.min(ans, blockCnt - N);
			}
			System.out.println(String.format("#%d %d", test_case, ans));
		}
		sc.close();
	}

	private static void init(Scanner sc) {
		N = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		copyMap = new int[H][W];
		blockCnt = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] > 0) {
					blockCnt++;
				}
			}
		}
	}

	private static void findAns(int idx, int cnt, int[] candi) {
		if (cnt == N) {
			copyMap();
			selectCandiAndBreakBlock(candi);
			// printMap(copyMap);
			ans = Integer.min(ans, getRemainBlock());
			if (ans == 0) {
				findMinAns = true;
			}
		} else if (cnt < N && !findMinAns) {
			for (int i = 0; i < W; i++) {
				candi[cnt] = i;
				findAns(i, cnt + 1, candi);
			}
		}
	}

	private static void copyMap() {
		for (int r = 0; r < H; r++) {
			copyMap[r] = Arrays.copyOf(map[r], W);
		}
	}

	private static void selectCandiAndBreakBlock(int[] candi) {
		for (int idx = 0; idx < candi.length; idx++) {
			breakBlock(candi[idx]);
			clearCopyMap();
		}
	}

	private static void breakBlock(int c) {
		Queue<Node> q = new LinkedList<>();
		int r = 0;
		while (r < H) {
			if (copyMap[r][c] > 0) {
				q.add(new Node(r, c, copyMap[r][c]));
				copyMap[r][c] = 0;
				break;
			}
			r++;
		}

		while (!q.isEmpty()) {
			Node node = q.remove();
			
			// left
			int cnt = node.num - 1;
			int row = node.r;
			int col = node.c - 1;
			while (cnt > 0 && col >= 0) {
				if (copyMap[row][col] > 0) {
					q.add(new Node(row, col, copyMap[row][col]));
					copyMap[row][col] = 0;
				}
				cnt--;
				col--;
			}
			// down
			cnt = node.num - 1;
			row = node.r + 1;
			col = node.c;
			while (cnt > 0 && row < H) {
				if (copyMap[row][col] > 0) {
					q.add(new Node(row, col, copyMap[row][col]));
					copyMap[row][col] = 0;
				}
				cnt--;
				row++;
			}

			// right
			cnt = node.num - 1;
			row = node.r;
			col = node.c + 1;
			while (cnt > 0 && col < W) {
				if (copyMap[row][col] > 0) {
					q.add(new Node(row, col, copyMap[row][col]));
					copyMap[row][col] = 0;
				}
				cnt--;
				col++;
			}

			// up
			cnt = node.num - 1;
			row = node.r - 1;
			col = node.c;
			while (cnt > 0 && row >= 0) {
				if (copyMap[row][col] > 0) {
					q.add(new Node(row, col, copyMap[row][col]));
					copyMap[row][col] = 0;
				}
				cnt--;
				row--;
			}
		}
	}

	private static void clearCopyMap() {
		for (int col = 0; col < W; col++) {
			// 각 col에서 남은 벽돌을 구한다.
			int[] num = new int[H];
			int numCnt = 0;
			for (int row = H - 1; row >= 0; row--) {
				if (copyMap[row][col] > 0) {
					num[numCnt] = copyMap[row][col];
					copyMap[row][col] = 0;
					numCnt++;
				}
			}

			// 남은 벽돌을 아래부터 쌓는다.
			int idx = 0;
			int row = H - 1;
			while (row >= H - 1 - numCnt && idx < numCnt) {
				copyMap[row][col] = num[idx];
				idx++;
				row--;
			}
		}

	}

	private static int getRemainBlock() {
		int remainBlock = 0;
		for (int c = 0; c < W; c++) {
			int r = H - 1;
			while (r >= 0) {
				if (copyMap[r][c] == 0) {
					break;
				}
				r--;
				remainBlock++;
			}
		}
		return remainBlock;
	}

	private static void printMap(int[][] map) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

}
