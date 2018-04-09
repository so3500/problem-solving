/*
* 문제: 12100 2048(Easy) / 280 ms
* link: https://www.acmicpc.net/problem/12100
* 알고리즘: 완전 탐색, dfs
* 풀이방법:
* 	방향 설정(상:0, 우:1, 하:2, 좌:3)
* 	길이 5를 만족하는 각 방향의 조합 생성  e.g. 1->1->1->1->1, 1->3->1->2->3 ...
* 	각 조합이 진행될 때마다 move 연산을 수행한다. move연산이 수행되는 순서는 각 방향에 따라 다르다.
* 	5번의 이동이 끝난 뒤 블럭에 존재하는 최대 값을 구한다.
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

public class Boj_12100 {

	static int N, maxValue;
	static int[][] map;
	static boolean[][] checked;
	static int[] rows = { -1, 0, 1, 0 };
	static int[] cols = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		init();
		for (int direction = 0; direction <= 3; direction++) {
			solve(0, direction, map);
		}
		System.out.println(maxValue);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		sc.close();
	}

	static void solve(int moveCnt, int direction, int[][] m) {
		if (moveCnt == 5) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					maxValue = Integer.max(maxValue, m[r][c]);
				}
			}
		} else {
			// move
			checked = new boolean[N][N];
			// e.g. direction: 1->3 에서 1->3->2 로 넘어가기 전에 상태값 저장
			// 		저장한 상태값(M)은 1->3->2 가 끝나고 1->3->3으로 넘어갈 때 사용함
			int[][] M = new int[N][N];
			int r, c;
			copy(m, M);
			switch (direction) {
			case 0: // 상
				for (r = 1; r < N; r++) {
					for (c = 0; c < N; c++) {
						if (M[r][c] != 0)
							move(r, c, direction, M);
					}
				}
				break;
			case 1: // 우
				for (r = 0; r < N; r++) {
					for (c = N - 1; c >= 0; c--) {
						if (M[r][c] != 0)
							move(r, c, direction, M);
					}
				}
				break;
			case 2: // 하
				for (r = N - 1; r >= 0; r--) {
					for (c = 0; c < N; c++) {
						if (M[r][c] != 0)
							move(r, c, direction, M);
					}
				}
				break;
			case 3: // 좌
				for (r = 0; r < N; r++) {
					for (c = 1; c < N; c++) {
						if (M[r][c] != 0)
							move(r, c, direction, M);
					}
				}
				break;
			}

			// 상, 하, 좌, 우의 모든 경우를 탐색
			for (int dir = 0; dir <= 3; dir++) {
				solve(moveCnt + 1, dir, M);
			}
		}
	}

	static void move(int r, int c, int direction, int[][] m) {
		int toR, toC;
		toR = r + rows[direction];
		toC = c + cols[direction];
		if (toR < 0 || toC < 0 || N <= toR || N <= toC)
			return;
		if (m[toR][toC] == 0) { // 빈칸일 경우 숫자 이동
			m[toR][toC] = m[r][c];
			m[r][c] = 0;
			move(toR, toC, direction, m);
		} else if (m[toR][toC] == m[r][c] && !checked[toR][toC]) { // 같은 숫자이면서 아직 합치지 않는 상태이면 합치기
			checked[toR][toC] = true;
			m[toR][toC] *= 2;
			m[r][c] = 0;
		}
	}

	static void copy(int[][] from, int[][] to) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				to[r][c] = from[r][c];
			}
		}
	}
}
