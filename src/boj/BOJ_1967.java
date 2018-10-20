package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class BOJ_1967 {

	private static class Point {
		public int nodeNo, dist;

		public Point(int nodeNo, int dist) {
			this.nodeNo = nodeNo;
			this.dist = dist;
		}
	}

	private static class Node {
		public int parentNo, leftChildNo, rightChildNo;
		public int distToParent, distToLeftChild, distToRightChild;

		public Node() {
			parentNo = 0;
			leftChildNo = 0;
			rightChildNo = 0;
			distToParent = 0;
			distToLeftChild = 0;
			distToRightChild = 0;
		}
	}

	private static int n, treeDiameter;
	private static List<Integer> leafList;
	private static Node[] tree;
	private static boolean[] visited;

	public static void main(String[] args) {
		init();

		treeDiameter = 0;
		for (int leafNodeNo : leafList) {
			treeDiameter = Integer.max(treeDiameter, bfs(leafNodeNo));
		}

		System.out.println(treeDiameter);
	}

	private static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			tree = new Node[n + 1];

			for (int i = 0; i <= n; i++) {
				tree[i] = new Node();
			}

			while (true) {
				st = new StringTokenizer(br.readLine());

				int parent, child, dist;
				parent = Integer.parseInt(st.nextToken());
				child = Integer.parseInt(st.nextToken());
				dist = Integer.parseInt(st.nextToken());

				// 자식 -> 부모 연결
				tree[child].parentNo = parent;
				tree[child].distToParent = dist;

				// 부모 -> 자식 연결
				if (tree[parent].leftChildNo == 0) {
					tree[parent].leftChildNo = child;
					tree[parent].distToLeftChild = dist;
				} else {
					tree[parent].rightChildNo = child;
					tree[parent].distToRightChild = dist;
				}

				if (child == n) {
					break;
				}
			}

			leafList = new LinkedList<>();
			for (int nodeNo = 1; nodeNo <= n; nodeNo++) {
				if (tree[nodeNo].parentNo != 0 && tree[nodeNo].leftChildNo == 0 && tree[nodeNo].rightChildNo == 0) {
					leafList.add(nodeNo);
				}
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int bfs(int startNodeNo) {
		int maxDist = 0;
		visited = new boolean[n + 1];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startNodeNo, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();
			visited[p.nodeNo] = true;
			maxDist = Integer.max(maxDist, p.dist);

			int parentNo, leftChildNo, rightChildNo;
			parentNo = tree[p.nodeNo].parentNo;
			leftChildNo = tree[p.nodeNo].leftChildNo;
			rightChildNo = tree[p.nodeNo].rightChildNo;

			if (parentNo != 0 && !visited[parentNo]) {
				q.add(new Point(parentNo, p.dist + tree[p.nodeNo].distToParent));
			}
			if (leftChildNo != 0 && !visited[leftChildNo]) {
				q.add(new Point(leftChildNo, p.dist + tree[p.nodeNo].distToLeftChild));
			}
			if (rightChildNo != 0 && !visited[rightChildNo]) {
				q.add(new Point(rightChildNo, p.dist + tree[p.nodeNo].distToRightChild));
			}
		}

		return maxDist;
	}

}
