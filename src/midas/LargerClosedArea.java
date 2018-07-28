package midas;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LargerClosedArea {

	static class Rect {
		int fromR, fromC, toR, toC;

		public Rect(int fromR, int fromC, int toR, int toC) {
			this.fromR = fromR;
			this.fromC = fromC;
			this.toR = toR;
			this.toC = toC;
		}
	}

	static int N, maxArea, area;
	static int[] rows = { -1, 0, 1, 0 }, cols = { 0, 1, 0, -1 };
	static boolean[][] map;
	static List<Rect> rectList;

	public static void main(String[] args) {
		init();
		solve();

	}

	public static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new boolean[101][101];
		int fromR, fromC, toR, toC;
		String[] input;
		rectList = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			input = sc.next().split(",");
			fromC = Integer.parseInt(input[0]);
			fromR = Integer.parseInt(input[1]);
			toC = Integer.parseInt(input[2]);
			toR = Integer.parseInt(input[3]);
			rectList.add(new Rect(fromR, fromC, toR, toC));
			for (int c = fromC; c <= toC; c++) {
				map[fromR][c] = true;
				map[toR][c] = true;
			}
			for (int r = fromR; r <= toR; r++) {
				map[r][fromC] = true;
				map[r][toC] = true;
			}
		}
		maxArea = Integer.MIN_VALUE;
		sc.close();
	}

	public static void solve() {
		// 직사각형 내부의 점에 한해서 dfs 수행
		for (Rect rect : rectList) {
			for (int r = rect.fromR + 1; r <= 100 && r < rect.toR; r++) {
				for (int c = rect.fromC + 1; c <= 100 && c < rect.toC; c++) {
					if (!map[r][c]) { // dfs 수행할 때마다 최대 폐구간의 크기 구하기
						map[r][c] = true;
						area = 0;
						dfs(r, c);
						maxArea = Integer.max(maxArea, area);
					}
				}
			}
		}
		System.out.println(maxArea);
	}

	public static void dfs(int r, int c) {
		int toR, toC;

		area++;

		for (int i = 0; i < 4; i++) {
			toR = r + rows[i];
			toC = c + cols[i];
			// 범위를 벗어나거나 이미 방문한 곳인 경우 pass
			if (toR < 0 || toC < 0 || 100 < toR || 100 < toC || map[toR][toC])
				continue;
			map[toR][toC] = true;
			dfs(toR, toC);
		}
	}
}
