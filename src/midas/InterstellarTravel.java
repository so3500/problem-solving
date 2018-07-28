package midas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InterstellarTravel {

	static class Point {
		int no, dist;

		public Point(int no, int dist) {
			this.no = no;
			this.dist = dist;
		}
	}

	static boolean[][] map;
	static boolean[] visited;
	static int N, start, by, dest;

	public static void main(String[] args) {
		init();
		solve();
	}

	public static void init() {
		Scanner sc = new Scanner(System.in);
		map = new boolean[26][26];
		N = sc.nextInt();
		int i, from, to;
		String[] input;
		for (i = 0; i < N; i++) {
			input = sc.next().split(",");
			from = input[0].charAt(0) - 65;
			to = input[1].charAt(0) - 65;
			map[from][to] = true;
		}
		start = 0;
		by = sc.next().charAt(0) - 65;
		sc.close();
	}

	public static void solve() {
		int dist, ret;
		dist = 0;
		// 출발지 A 부터 정착 후보 행성까지 BFS
		ret = bfs(0, by);
		if (ret != -1) { // 정착 후보 행성 부터 최종 종착지 Z 까지 BFS
			dist += ret;
			ret = bfs(by, 25);
			if (ret != -1) {
				dist += ret;
			} else {
				dist = -1;
			}
		} else {
			dist = -1;
		}
		System.out.println(dist);
	}

	public static int bfs(int from, int to) {
		int dist = -1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(from, 0));
		visited = new boolean[26];
		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.no == to) {
				dist = p.dist;
				break;
			}

			for (int i = 0; i < 26; i++) {
				if (map[p.no][i] && !visited[i]) {
					visited[i] = true;
					q.add(new Point(i, p.dist + 1));
				}
			}
		}
		return dist;
	}

}
