package swexpert;

import java.util.Scanner;

public class SE_13460 {

	static int N, M, minMoveCnt;
	static boolean rExit, bExit, disable;
	static boolean[][] rVisited, bVisited;
	static char[][] map;
	static int[] rows = { -1, 0, 1, 0 };
	static int[] cols = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			init(sc);
			for (int dir = 0; dir < 4; dir++) {
				solve(dir, 1, map, rVisited, bVisited);
			}
			// 최소 이동수를 찾지 못할 경우 답은 -1
			if (minMoveCnt == Integer.MAX_VALUE)
				minMoveCnt = -1;
			// System.out.println(minMoveCnt);
			System.out.println("#" + t + " " + minMoveCnt);
		}
		sc.close();
	}

	static void init(Scanner sc) {
		// Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		rVisited = new boolean[N][M];
		bVisited = new boolean[N][M];
		String input;
		for (int r = 0; r < N; r++) {
			input = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = input.charAt(c);
			}
		}
		rExit = false;
		bExit = false;
		disable = true;
		minMoveCnt = Integer.MAX_VALUE;
		// sc.close();
	}

	static void solve(int dir, int moveCnt, char[][] m, boolean[][] rV, boolean[][] bV) {
		int r, c;
		boolean rMoveEnable, bMoveEnable;
		rMoveEnable = false;

		char[][] copyMap = new char[N][M];
		boolean[][] rCopyVisited = new boolean[N][M];
		boolean[][] bCopyVisited = new boolean[N][M];
		copyMap(m, copyMap);
		copyVisited(rV, rCopyVisited);
		copyVisited(bV, bCopyVisited);

		switch (dir) {
		case 0:
			for (r = 1; r < N - 1; r++) { // 위로 기울이기
				for (c = 1; c < M - 1; c++) {
					if (copyMap[r][c] == 'B') {
						bMoveEnable = move(r, c, dir, 'B', copyMap, rCopyVisited, bCopyVisited);
					} else if (copyMap[r][c] == 'R') {
						rMoveEnable = move(r, c, dir, 'R', copyMap, rCopyVisited, bCopyVisited);
					}
				}
			}
			break;
		case 1:
			for (r = 1; r < N - 1; r++) { // 오른쪽으로 기울이기
				for (c = M - 2; c >= 1; c--) {
					if (copyMap[r][c] == 'B') {
						bMoveEnable = move(r, c, dir, 'B', copyMap, rCopyVisited, bCopyVisited);
					} else if (copyMap[r][c] == 'R') {
						rMoveEnable = move(r, c, dir, 'R', copyMap, rCopyVisited, bCopyVisited);
					}
				}
			}
			break;
		case 2:
			for (r = N - 2; r >= 1; r--) { // 아래로 기울이기
				for (c = 1; c < M - 1; c++) {
					if (copyMap[r][c] == 'B') {
						bMoveEnable = move(r, c, dir, 'B', copyMap, rCopyVisited, bCopyVisited);
					} else if (copyMap[r][c] == 'R') {
						rMoveEnable = move(r, c, dir, 'R', copyMap, rCopyVisited, bCopyVisited);
					}
				}
			}
			break;
		case 3:
			for (r = 1; r < N - 1; r++) { // 왼쪽으로 기울이기
				for (c = 1; c < M - 1; c++) {
					if (copyMap[r][c] == 'B') {
						bMoveEnable = move(r, c, dir, 'B', copyMap, rCopyVisited, bCopyVisited);
					} else if (copyMap[r][c] == 'R') {
						rMoveEnable = move(r, c, dir, 'R', copyMap, rCopyVisited, bCopyVisited);
					}
				}
			}
			break;
		}

		if (bExit) {
			// 1. 한번의 움직임으로 파란 구슬이 구멍을 통해 나온 경우, 해당 경우의 수는 무효
			bExit = false;
			rExit = false; // 같이 빠져나온 빨간 구슬 탈출 여부도 초기화
		} else if (rExit && moveCnt <= 10) {
			// 2. 한번의 움직임으로 R공이 나온경우 빨간구슬 탈출 여부 초기화(다음 경우의 수에서 최소 이동수를 찾기위함)
			minMoveCnt = Integer.min(minMoveCnt, moveCnt);
			rExit = false;
		} else if (rMoveEnable) {
			// 3. 빨간 구슬이 움직일 수 있을 때에만 다음 경우의수로 넘어감
			// 파란 구슬의 움직임 여부에 상관 없이 빨간 구슬이 움직일 수 없다면 더 이상 진행할 수 없음
			for (int i = 0; i < 4; i++) { // 이동 후 해당 지점에서 상, 하, 좌, 우로 움직임
				solve(i, moveCnt + 1, copyMap, rCopyVisited, bCopyVisited);
			}
		}

	}

	static boolean move(int r, int c, int dir, char color, char[][] m, boolean[][] rV, boolean[][] bV) {
		boolean moveEnable = false;
		int toR, toC;
		toR = r + rows[dir];
		toC = c + cols[dir];

		// rVisited, bVisited 정보를 통해 무한루프 방지
		if (m[toR][toC] == '.') {
			if (color == 'R' && !rV[toR][toC]) {
				// if (color == 'R') {
				rV[r][c] = true;
				moveEnable = true;
				m[toR][toC] = m[r][c];
				m[r][c] = '.';
				move(toR, toC, dir, color, m, rV, bV);
			} else if (color == 'B' && !bV[toR][toC]) {
				// } else if (color == 'B') {
				bV[r][c] = true;
				moveEnable = true;
				m[toR][toC] = m[r][c];
				m[r][c] = '.';
				move(toR, toC, dir, color, m, rV, bV);
			}
		} else if (m[toR][toC] == 'O') { // 구멍에 도달한 경우
			if (color == 'R') {
				m[r][c] = '.';
				rExit = true;
			} else {
				m[r][c] = '.';
				bExit = true;
			}
		}
		return moveEnable;
	}

	static void copyMap(char[][] from, char[][] to) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				to[r][c] = from[r][c];
			}
		}
	}

	static void copyVisited(boolean[][] from, boolean[][] to) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				to[r][c] = from[r][c];
			}
		}
	}
}
