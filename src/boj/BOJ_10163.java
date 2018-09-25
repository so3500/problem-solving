/*
* 문제: 10163 색종이
* link: https://www.acmicpc.net/problem/10163
* 알고리즘: 구현
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

public class BOJ_10163 {

	private static int N;
	private static int[] paperArea;
	private static int[][] map;

	public static void main(String[] args) {
		init();
		solve();
		StringBuilder sb = new StringBuilder();
		for (int paperNo = 1; paperNo <= N; paperNo++) {
			sb.append(paperArea[paperNo]).append("\n");
		}
		System.out.println(sb);
	}

	private static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		paperArea = new int[N + 1];
		map = new int[101][101];
		for (int paperNo = 1; paperNo <= N; paperNo++) {
			int col = sc.nextInt();
			int row = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			for (int r = row; r < row + height; r++) {
				for (int c = col; c < col + width; c++) {
					map[r][c] = paperNo;
				}
			}
		}
		sc.close();
	}

	private static void solve() {
		for (int row = 0; row < 101; row++) {
			for (int col = 0; col < 101; col++) {
				int paperNo = map[row][col];
				paperArea[paperNo]++;
			}
		}
	}
}
