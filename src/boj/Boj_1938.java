/*
* 문제: 1938 통나무 옮기기 / 80 ms
* link: https://www.acmicpc.net/problem/11933
* 알고리즘: BFS
* 풀이방법:
* 	각 지점에서 통나무가 | 일 때와 ㅡ 일때에 맞춰 상, 하, 좌, 우, 회전이 가능한지 확인하고
* 	가능하면 큐에 추가한다
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
*
* */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1938 {

	static int N, minMoveCnt, centerRow, centerCol, startDir, direction;
	static boolean[][][] visited; // e.g. visited[2][3][0]: true == (2, 3)에서 ㅡ 가 방문함
	static char[][] map;
	static Queue<Point> q;

	static class Point {
		int row, col, moveCnt, dir;

		public Point(int row, int col, int moveCnt, int dir) {
			this.row = row;
			this.col = col;
			this.moveCnt = moveCnt;
			this.dir = dir;
		}
	}

	public static void main(String[] args) {
		init();
		q.add(new Point(centerRow, centerCol, 0, direction)); // 시작 중심점 row, 시작 중심점 col, 거리, 시작 방향
		visited[centerRow][centerCol][direction] = true;
		solve();
		if (minMoveCnt == Integer.MAX_VALUE) {
			minMoveCnt = 0;
		}
		System.out.println(minMoveCnt);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		int bCnt, cnt;
		String input;
		N = sc.nextInt();
		map = new char[N][N];
		visited = new boolean[N][N][2];
		q = new LinkedList<>();
		bCnt = 0; // 통나무 카운트, 중심점을 알아내기 위한 변수
		cnt = 0; // 통나무를 한 행에서 카운트, 통나무의 방향을 알아내기 위한 변수
		direction = 1; // 기본 방향 1
		for (int r = 0; r < N; r++) {
			input = sc.next();
			cnt = 0;
			for (int c = 0; c < N; c++) {
				map[r][c] = input.charAt(c);
				if (map[r][c] == 'B') {
					bCnt++;
					cnt++;
				}
				if (bCnt == 2) {
					centerRow = r;
					centerCol = c;
					bCnt++; // c 가 계속 증가하는것을 방지
				}
				if (cnt == 2) {
					direction = 0; // 통나무가 한 행에서 연속적으로 카운트 되는 경우, 가로 0
				}
			}
		}
		minMoveCnt = Integer.MAX_VALUE;
		sc.close();
	}

	// dir:1 = |, dir:0 = ㅡ
	static void solve() {
		int r, c, dir, moveCnt;
		while (!q.isEmpty()) {
			Point point = q.poll();
			r = point.row;
			c = point.col;
			moveCnt = point.moveCnt;
			dir = point.dir;

			if (eCheck(r, c, dir)) {
				minMoveCnt = Integer.min(minMoveCnt, moveCnt);
			} else {
				if (upCheck(r, c, dir) && !visited[r - 1][c][dir]) {
					visited[r - 1][c][dir] = true;
					q.add(new Point(r - 1, c, moveCnt + 1, dir));
				}
				if (rightCheck(r, c, dir) && !visited[r][c + 1][dir]) {
					visited[r][c + 1][dir] = true;
					q.add(new Point(r, c + 1, moveCnt + 1, dir));
				}
				if (downCheck(r, c, dir) && !visited[r + 1][c][dir]) {
					visited[r + 1][c][dir] = true;
					q.add(new Point(r + 1, c, moveCnt + 1, dir));
				}
				if (leftCheck(r, c, dir) && !visited[r][c - 1][dir]) {
					visited[r][c - 1][dir] = true;
					q.add(new Point(r, c - 1, moveCnt + 1, dir));
				}
				if (turnCheck(r, c, dir) && !visited[r][c][(dir + 1) % 2]) {
					visited[r][c][(dir + 1) % 2] = true;
					q.add(new Point(r, c, moveCnt + 1, (dir + 1) % 2));
				}
			}
		}
	}

	static boolean upCheck(int r, int c, int dir) {
		boolean valid = true;
		if (dir == 0) {
			for (int col = -1; col <= 1; col++) {
				if (!isValid(r - 1, c + col)) {
					valid = false;
					break;
				}
			}
		} else {
			if (!isValid(r - 2, c))
				valid = false;
		}
		return valid;
	}

	static boolean downCheck(int r, int c, int dir) {
		boolean valid = true;
		if (dir == 0) {
			for (int col = -1; col <= 1; col++) {
				if (!isValid(r + 1, c + col)) {
					valid = false;
					break;
				}
			}
		} else {
			if (!isValid(r + 2, c))
				valid = false;
		}
		return valid;
	}

	static boolean leftCheck(int r, int c, int dir) {
		boolean valid = true;
		if (dir == 0) {
			if (!isValid(r, c - 2))
				valid = false;
		} else {
			for (int row = -1; row <= 1; row++) {
				if (!isValid(r + row, c - 1)) {
					valid = false;
					break;
				}
			}
		}
		return valid;
	}

	static boolean rightCheck(int r, int c, int dir) {
		boolean valid = true;
		if (dir == 0) {
			if (!isValid(r, c + 2))
				valid = false;
		} else {
			for (int row = -1; row <= 1; row++) {
				if (!isValid(r + row, c + 1)) {
					valid = false;
					break;
				}
			}
		}
		return valid;
	}

	static boolean turnCheck(int r, int c, int dir) {
		boolean valid = true;
		if (dir == 0) {
			if (!upCheck(r, c, dir) || !downCheck(r, c, dir))
				valid = false;
		} else {
			if (!leftCheck(r, c, dir) || !rightCheck(r, c, dir))
				valid = false;
		}
		return valid;
	}

	static boolean eCheck(int r, int c, int dir) {
		boolean valid = true;
		if (dir == 0) {
			if (map[r][c + 1] != 'E' || map[r][c - 1] != 'E')
				valid = false;
		} else {
			if (map[r + 1][c] != 'E' || map[r - 1][c] != 'E')
				valid = false;
		}
		return valid;
	}

	// 올바른 범위인지, 해당 (row, col)에 나무 존재 여부 검사
	static boolean isValid(int r, int c) {
		boolean valid = true;
		if (r < 0 || c < 0 || N <= r || N <= c || map[r][c] == '1')
			valid = false;
		return valid;
	}
}
