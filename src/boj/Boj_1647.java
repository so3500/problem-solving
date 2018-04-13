/*
* 문제: 1647 도시 분할 계획 / 1468 ms
* link: https://www.acmicpc.net/problem/1647
* 알고리즘: Minimum Spanning Tree(MST), Kruskal
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1647 {

	static class Point implements Comparable<Point> {
		int a, b, cost;

		public Point(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point p) {
			return this.cost - p.cost; // 오름차순 정렬
		}

	}

	static int N, M, minCost, cnt;
	static int[] parent, height;
	static PriorityQueue<Point> pq;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(minCost);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, cost, i;
		String[] input;
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		pq = new PriorityQueue<>(M);
		for (i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			cost = Integer.parseInt(input[2]);
			pq.add(new Point(a, b, cost));
		}
		// 각 정점 초기화
		parent = new int[N + 1];
		height = new int[N + 1];
		for (i = 1; i <= N; i++) {
			parent[i] = i;
			height[i] = 1;
		}
		minCost = 0;
		cnt = N - 2; // 최소 신장 트리를 구할 때 union 수행 횟수(두 그룹이 이미 하나일 경우에는 제외)
		br.close();
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}

	static boolean union(int a, int b) {
		int rootA, rootB, temp;
		rootA = find(a);
		rootB = find(b);

		// 같은 그룹
		if (rootA == rootB)
			return false;

		// 항상 A의 높이가 더 작도록
		if (height[rootA] > height[rootB]) {
			temp = rootA;
			rootA = rootB;
			rootA = temp;
		}
		// 항상 B가 루트가 되도록
		parent[rootA] = rootB;

		// A, B의 높이가 같으면 B의 길이를 늘린다.
		if (height[rootA] == height[rootB])
			height[rootB]++;
		
		return true;
	}

	static void solve() {
		Point p;
		// 최소 신장 트리는 N-1개의 간선으로 이루어져 있다.
		// 이때, 마지막으로 추가한 간선을 제거하면 두 개의 최소 신장 트리를 구할 수 있다.
		// 즉 N-2번만 union 연산을 수행하면 된다. 단 이미 같은 그룹은 연산에서 제외한다.
		while (!pq.isEmpty() && (cnt > 0)) {
			p = pq.poll();
			if(union(p.a, p.b)) {
				minCost += p.cost;
				cnt--;
			}
		}
	}
}
