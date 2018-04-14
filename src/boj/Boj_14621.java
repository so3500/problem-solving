/*
* 문제: 14621 나만 안되는 연애 / 472 ms
* link: https://www.acmicpc.net/problem/1647
* 알고리즘: Minimum Spanning Tree(MST), Kruskal 응용
* 풀이방법:
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
* 	O(ElogE), O(ElogV)
*
* 공간복잡도(Space Complexity)
*
* */

package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_14621 {

	static class Edge implements Comparable<Edge> {
		int u, v, dist;

		public Edge(int u, int v, int dist) {
			this.u = u;
			this.v = v;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist; // 오름차순 정렬
		}
	}

	static int N, M, minDist;
	static int[] parent, height;
	static char[] gender;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) {
		init();
		solve();
		System.out.println(minDist);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		int i, u, v, dist;
		N = sc.nextInt();
		M = sc.nextInt();
		parent = new int[N + 1];
		height = new int[N + 1];
		gender = new char[N + 1];
		for (i = 1; i <= N; i++) {
			parent[i] = i;
			gender[i] = sc.next().charAt(0);
		}
		pq = new PriorityQueue<>(M);
		for (i = 0; i < M; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			dist = sc.nextInt();
			pq.add(new Edge(u, v, dist));
		}
		minDist = 0;
		sc.close();
	}

	static int find(int u) {
		if (parent[u] == u)
			return u;
		parent[u] = find(parent[u]);
		return parent[u];
	}

	static boolean union(int u, int v) {
		int uRoot, vRoot, temp;
		uRoot = find(u);
		vRoot = find(v);

		if (uRoot == vRoot)
			return false;

		if (height[uRoot] > height[vRoot]) {
			temp = uRoot;
			uRoot = vRoot;
			vRoot = temp;
		}
		// u 집합이 v 집합보다 높이값이 작으므로 v 집합에 u 집합을 추가
		parent[uRoot] = parent[vRoot];

		// 두 집합의 높이값이 같다면 v 집합의 높이값에 1 추가
		if (height[uRoot] == height[vRoot])
			height[vRoot]++;

		return true;
	}

	static void solve() {
		Edge e;
		int i, root;
		while (!pq.isEmpty()) {
			e = pq.poll();

			// 두 대학교가 다른 종류일때에만 union 연산 수행
			if (gender[e.u] == gender[e.v]) continue;
			
			// 두 대학교가 이미 다른 그룹일 경우에만 도로를 추가
			if(union(e.u, e.v)) minDist += e.dist;
		}
		
		// 위 알고리즘으로 인해 하나의 MST가 생성되지 않았을 경우  = parent가 다른 경우 = 모든 학교를 연결하는 경로가 없음
		root = find(1);
		for(i=2; i<=N; i++) {
			if(root != find(i)) {
				minDist = -1;
				break;
			}
		}
	}

}
