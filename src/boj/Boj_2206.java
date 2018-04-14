/*
* 문제: 2206 벽 부수고 이동하기 / 512 ms
* link: https://www.acmicpc.net/problem/2206
* 알고리즘: BFS
* 풀이방법:
* 	"벽을 한번 부수고 이동"할 수 있기 때문에
* 	bfs 를 수행할 때 벽을 한번 부수고 이동한 경우와, 그렇지 않고 이동한 경우 방문처리를 할 수 있도록
* 	visited 3차원 배열을 이용한다. 
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

public class Boj_2206 {

	static class Point {
		int r, c, dist, removeCnt;

		public Point(int r, int c, int dist, int removeCnt) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.removeCnt = removeCnt;
		}
	}

	static int N, M, minDist;
	static boolean[][] map;
	static boolean[][][] visited;
	static int[] rows = { -1, 0, 1, 0 }, cols = { 0, 1, 0, -1 };
	static Queue<Point> q;

	public static void main(String[] args) {
		init();
		bfs();
		if (minDist == Integer.MAX_VALUE) {
			minDist = -1;
		}
		System.out.println(minDist);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		int r, c;
		String input;
		N = sc.nextInt();
		M = sc.nextInt();
		map = new boolean[N][M];
		visited = new boolean[N][M][2];
		q = new LinkedList<>();
		for (r = 0; r < N; r++) {
			input = sc.next();
			for (c = 0; c < M; c++) {
				if (input.charAt(c) == '1') {
					map[r][c] = true;
				}
			}
		}
		minDist = Integer.MAX_VALUE;
		sc.close();
	}

	static void bfs() {
		Point p;
		int toR, toC;
		q.add(new Point(0, 0, 1, 0));
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		while (!q.isEmpty()) {
			p = q.poll();

			if (p.r == N - 1 && p.c == M - 1) {
				minDist = p.dist;
				break;
			}

			for (int i = 0; i <= 3; i++) {
				toR = p.r + rows[i];
				toC = p.c + cols[i];
				// 범위를 벗어나거나, 이미 방문한 지역, 벽인 지역은 제외
				// 이미 (벽을 한 번 부쉈거나 or 부수지 않고) 방문한 지역은 재방문 하지 않음
				if (toR < 0 || toC < 0 || N <= toR || M <= toC || visited[toR][toC][p.removeCnt])
					continue;

				// 벽이 존재하며, 벽을 부술 수 있는 경우 벽을 부순 경우를 큐에 추가
				if (map[toR][toC] && p.removeCnt == 0) {
					// 벽을 부순 뒤 갈 수 있는 영역에 방문 처리
					visited[toR][toC][p.removeCnt + 1] = true; 
					q.add(new Point(toR, toC, p.dist + 1, p.removeCnt + 1));
				}
				// 벽이 없는 길로 가는 경우
				if (!map[toR][toC]) {
					visited[toR][toC][p.removeCnt]= true; 
					q.add(new Point(toR, toC, p.dist + 1, p.removeCnt));
				}
			}
		}
	}
}
