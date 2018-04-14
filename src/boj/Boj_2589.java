/*
 * 문제: 2589 보물섬 / 312 ms
 * link: https://www.acmicpc.net/problem/2589
 * 알고리즘: BFS
 * 풀이방법:
 *  (0,0) to (L-1, W-1) 에서 'L'인 점에 한해서 DFS 시작.
 *      각 dfs가 끝날 때 moveCnt 갱신(moveCnt: 각 dfs 에서 이동한 가장 긴 거리)
 *  모든 dfs가 끝날 때 maxMoveCnt 갱신
 *  
 *  가장 멀리 떨어진 두 점을 찾는 방법은 모든 점에서 bfs를 수행하여 가장 마지막에 방문하는 점을 찾는다.
 *  그 점에서 최단거리로 이동가능한 최장거리 지점을 찾는다.
 *  위 단계를 모든 지점에서 수행하므로 정답 도출 가능
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj_2589 {

	static int L, W, maxMoveCnt;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Point> q; // 최단거리를 구하는 bfs를 수행할 때 사용할 큐
	static List<Point> startList; // bfs를 수행하는 모든 시작지점 'L'의 위치정보를 저장한 리스트
	static int[] rows = { -1, 0, 1, 0 }, cols = { 0, 1, 0, -1 };

	static class Point {
		int r, c, moveCnt;

		Point(int r, int c, int moveCnt) {
			this.r = r;
			this.c = c;
			this.moveCnt = moveCnt;
		}
	}

	public static void main(String args[]) throws IOException {
		init();
		// 보물섬의 모든 'L' 지점에서 bfs를 수행함
		for (Point startPoint : startList) {
			bfs(startPoint.r, startPoint.c);
		}
		System.out.println(maxMoveCnt);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		input = br.readLine().split(" ");
		q = new LinkedList<>();
		startList = new ArrayList<>();
		L = Integer.parseInt(input[0]);
		W = Integer.parseInt(input[1]);
		map = new char[L][W];
		for (int r = 0; r < L; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < W; c++) {
				map[r][c] = input[0].charAt(c);
				if (map[r][c] == 'L') {
					startList.add(new Point(r, c, 0));
				}
			}
		}
		maxMoveCnt = 0;
		br.close();
	}

	static void bfs(int r, int c) {
		int moveCnt, toR, toC;
		q.add(new Point(r, c, 0));
		moveCnt = 0;
		visited = new boolean[L][W];
		visited[r][c] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			moveCnt = p.moveCnt;
			
			for (int i = 0; i < 4; i++) {
				toR = p.r + rows[i];
				toC = p.c + cols[i];
				if (toR < 0 || toC < 0 || L <= toR || W <= toC || map[toR][toC] == 'W'
						|| visited[toR][toC])
					continue;
				visited[toR][toC] = true;
				q.add(new Point(toR, toC, p.moveCnt + 1));
			}
		}
		// 시작지점 (r, c)에서 가장 먼 곳 까지의 거리를 구함
		// 그 거리 중 최대값을 구함
		maxMoveCnt = Integer.max(maxMoveCnt, moveCnt);
	}
}
