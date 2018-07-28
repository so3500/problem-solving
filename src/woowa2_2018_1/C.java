package woowa2_2018_1;

import java.util.Scanner;

public class C {

	static int[][] map;

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			int x3 = s.nextInt();
			int y3 = s.nextInt();
			int x4 = s.nextInt();
			int y4 = s.nextInt();
			int x5 = s.nextInt();
			int y5 = s.nextInt();
			int x6 = s.nextInt();
			int y6 = s.nextInt();

			map = new int[10001][10001];
			color(x1, x2, y1, y2, 1);
			color(x3, x4, y3, y4, 2);
			color(x5, x6, y5, y6, 3);
			int ans = getArea(x1, x2, y1, y2);
			System.out.println(ans);
		}
	}

	public static void color(int rFrom, int rTo, int cFrom, int cTo, int val) {
		int r, c;
		for (r = rFrom; r < rTo; r++) {
			for (c = cFrom; c < cTo; c++) {
				map[r][c] = val;
			}
		}
	}

	public static int getArea(int rFrom, int rTo, int cFrom, int cTo) {
		int area, r, c;
		area = 0;
		for (r = rFrom; r < rTo; r++) {
			for (c = cFrom; c < cTo; c++) {
				if (map[r][c] == 1) {
					area++;
				}
			}
		}
		return area;
	}

}
