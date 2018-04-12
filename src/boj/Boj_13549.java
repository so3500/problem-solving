/*
* 문제: 13549 숨바꼭질 3 / 148 ms
* link: https://www.acmicpc.net/problem/13549
* 알고리즘: BFS?
* 풀이방법:
*  위치 X에서 bfs 탐색 시작
*  	 먼저 2*X 에 해당하는 위치를 모두 저장
*    X-1, X+1 에 해당하는 위치를 저장	
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*  최악의 경우 N에서 0으로 갈때 -1씩만 이동 가능하므로
*  O(N)
*
* 공간복잡도(Space Complexity)
*  크기 N 입력에 대해 큐, 스택 사용 시 최대 N만큼 저장함
*  O(N)
* */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_13549 {

	static int N, K, minTime, SIZE;
	static boolean[] visited;
	static Queue<Point> q;

	static class Point {
		int x, time;

		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		init();
		if (minTime == Integer.MAX_VALUE) {
			solve();
		}
		System.out.println(minTime);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();
//		SIZE = Integer.max(N, K) + 1; // 1 9999 의 경우 5가 나옴, 답은 4임.
		SIZE = 100000 + 1;
		visited = new boolean[SIZE];
		minTime = Integer.MAX_VALUE;
		q = new LinkedList<>();
		if (K <= N) {
			minTime = N - K;
		}
	}

	static void solve() {
		Point p;
		int toX;
		visited[N] = true;
		q.add(new Point(N, 0));
		while (!q.isEmpty()) {
			p = q.poll();

			// K에 도착할 때 탐색 끝
			if (p.x == K) {
				minTime = p.time;
				break;
			}

			// 0초 후에 갈 수 있는 2*X 위치 모두 추가
			toX = 2 * p.x;
			while (toX < SIZE && !visited[toX]) {
				visited[toX] = true;
				q.add(new Point(toX, p.time));
				toX *= 2;
			}
			if (0 <= p.x - 1 && !visited[p.x - 1]) {
				q.add(new Point(p.x - 1, p.time + 1));
				visited[p.x - 1] = true;
			}
			if (p.x + 1 < SIZE && !visited[p.x + 1]) {
				q.add(new Point(p.x + 1, p.time + 1));
				visited[p.x + 1] = true;
			}

		}
	}

}
