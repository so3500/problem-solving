/*
* 문제: 2665 나이트의 이동 / 144 ms
* link: https://www.acmicpc.net/problem/2665
* 알고리즘: BFS
* 풀이방법:
* 	BFS를 수행할 때 흰방으로 가는 경우에는 그대로 간다.
* 	검은 방으로 가는 경우에는 흰 방으로 교체한 뒤, 교체횟수를 세면서 간다.
* 	예를 들어 (2,3)에 3회의 방 교체로 온 경우가 있다.
* 	그런데 새로 온 경우는 2회의 방 교체로 (2,3)을 수 있다.
* 	이때 (2,3)으로 오기위한 최소의 교체 횟수를 2번으로 갱신한다.
* 	그리고 다음 경우가 (2,3)으로 올때 교체 횟수가 2회 미만인 것만 갱신하고 큐에 추가한다.
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
*
* */

package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2665 {

	static class Point {
		int r, c, changeCnt;

		public Point(int r, int c, int changeCnt) {
			this.r = r;
			this.c = c;
			this.changeCnt = changeCnt;
		}
	}

	static int n, minChangeCnt;
	static boolean[][] map; // 벽, 방 여부 저장
	static int[][] visited; // 최소 변경 횟수 저장
	static int[] rows = { -1, 0, 1, 0 }, cols = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		init();
		bfs();
		System.out.println(minChangeCnt);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		int r, c;
		String input;
		n = sc.nextInt();
		map = new boolean[n][n];
		visited = new int[n][n];
		for (r = 0; r < n; r++) {
			input = sc.next();
			Arrays.fill(visited[r], Integer.MAX_VALUE);
			for (c = 0; c < n; c++) {
				if (input.charAt(c) == '1') {
					map[r][c] = true;
				} else {
					map[r][c] = false;
				}
			}
		}
		sc.close();
	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		Point p;
		int toR, toC;
		q.add(new Point(0, 0, 0));
		visited[0][0] = 0;
		while (!q.isEmpty()) {
			p = q.remove();

			for (int i = 0; i <= 3; i++) {
				toR = p.r + rows[i];
				toC = p.c + cols[i];
				// 범위를 벗어나거나, 방 변경 횟수가 더 많을 경우(필요이상의 검은방을 지나쳐온 경우) 제외
				if (toR < 0 || toC < 0 || n <= toR || n <= toC || p.changeCnt >= visited[toR][toC])
					continue;

				if (map[toR][toC]) { // 흰방
					visited[toR][toC] = p.changeCnt;
					q.add(new Point(toR, toC, p.changeCnt));
				} else { // 검은방을 흰방으로 변경
					visited[toR][toC] = p.changeCnt + 1;
					q.add(new Point(toR, toC, p.changeCnt + 1));
				}
			}
		}
		minChangeCnt = visited[n - 1][n - 1];
	}

}
