/*
* 문제: 14502 연구소 / 348 ms
* link: https://www.acmicpc.net/problem/14502
* 알고리즘: 완전탐색, dfs
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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_14502 {

	static class Virus {
		int r, c;

		public Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, safeCnt, allArea, virusArea;
	static int[][] map;
	static int[] rows = { -1, 0, 1, 0 };
	static int[] cols = { 0, 1, 0, -1 };
	static boolean[][] visited, copy;
	static List<Virus> virusList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		init(sc);
		solve(0, 0, 3);
		System.out.println(safeCnt);
	}

	static void init(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		copy = new boolean[N][M];
		visited = new boolean[N][M];
		virusList = new ArrayList<>();
		allArea = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 0) allArea++;
				else if (map[r][c] == 1) visited[r][c] = true;
				else if (map[r][c] == 2) {
					visited[r][c] = true;
					virusList.add(new Virus(r, c));
				}
			}
		}
		safeCnt = Integer.MIN_VALUE;
		allArea -= 3; // 3�� ������ ��ġ�� ������ 0�� ������ ����
	}

	static void solve(int r, int c, int wallCnt) {
		if (wallCnt == 0) {
			safeCnt = Integer.max(safeCnt, getSafeArea());
			return;
		}

		// �� 3���� 0�� ������ ��� ���� �� �ֵ��� ����Ž��
		for (int row = r; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (!visited[row][col] && map[row][col] == 0) {
					visited[row][col] = true;
					map[row][col] = 3;
					solve(row, col, wallCnt - 1);
					visited[row][col] = false;
					map[row][col] = 0;
				}
			}
		}
	}

	static int getSafeArea() {
		int area= allArea;
		virusArea = 0;
		save(); // ���� ����� ���̷����� ������ �� visited ���� ����
		// ���̷��� ���� �ùķ��̼�
		for (Virus v : virusList) {
			dfs(v.r, v.c);
		}
		area -= virusArea;
		load(); // ���̷����� ���� �ó����� ���� �� ������ visited ���� �ε�
		return area;
	}

	static void dfs(int r, int c) {
		int toR, toC;
		for (int i = 0; i < 4; i++) {
			toR = r + rows[i];
			toC = c + cols[i];
			if (toR < 0 || toC < 0 || N <= toR || M <= toC)	continue;
			if (!visited[toR][toC]) {
				visited[toR][toC] = true;
				virusArea++;
				dfs(toR, toC);
			}
		}
	}

	static void save() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				copy[r][c] = visited[r][c];
			}
		}
	}

	static void load() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = copy[r][c];
			}
		}
	}
}
