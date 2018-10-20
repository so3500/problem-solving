package sw_test.codemonster_test_2018_1st;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Graph {
	class Node {
		int no;
		Node parent;
		List<Node> childs;

		public Node(int no) {
			this.no = no;
			this.parent = null;
			this.childs = null;
		}

	}

	class BFSNode {
		int dist;
		Node node;

		public BFSNode(Node node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	PriorityQueue<BFSNode> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
	HashMap<Integer, Node> map = new HashMap<>();
	int[][] query;
	int[] answer;
	int size;
	boolean[] visited;

	public void init(int N, int[][] directory, int[][] query) {
		this.query = query;
		size = N + 1;
		answer = new int[query.length];
		visited = new boolean[size];
		Arrays.sort(directory, (arr1, arr2) -> arr1[0] - arr2[0]); // parentNo 오름차순 정렬
		for (int dirIdx = 0; dirIdx < directory.length; dirIdx++) {
			int parentNo = directory[dirIdx][0];
			int childNo = directory[dirIdx][1];

			// 저장된 node가져오기 or 생성
			Node parent;
			Node child;
			if (map.containsKey(parentNo)) {
				parent = map.get(parentNo);
			} else {
				parent = new Node(parentNo);
				map.put(parentNo, parent);
			}

			if (map.containsKey(childNo)) {
				child = map.get(childNo);
			} else {
				child = new Node(childNo);
				map.put(childNo, child);
			}

			// 관계 설정
			child.parent = parent;
			if (parent.childs == null) {
				parent.childs = new ArrayList<Node>();
			}
			parent.childs.add(child);
		}
	}

	public int[] solve() {
		int ansIdx = 0;
		for (int queryIdx = 0; queryIdx < query.length; queryIdx++) {
			Arrays.fill(visited, false);
			int startNo = query[queryIdx][0];
			int endNo = query[queryIdx][1];
			int ret = bfs(startNo, endNo);
			answer[ansIdx] = ret;
			ansIdx++;
		}
		return answer;
	}

	public int bfs(int startNo, int endNo) {
		int ret = 0;
		Node startNode = map.get(startNo);
		visited[startNo] = true;
		pq.add(new BFSNode(startNode, 1));
		while (!pq.isEmpty()) {
			BFSNode bfsNode = pq.poll();
			if (bfsNode.node.no == endNo) {
				ret = bfsNode.dist;
				pq.clear();
				break;
			}

			// 부모
			Node parent = bfsNode.node.parent;
			if (parent != null && !visited[parent.no]) {
				visited[parent.no] = true;
				pq.add(new BFSNode(parent, bfsNode.dist + 1));
			}

			// 자식들
			List<Node> childs = bfsNode.node.childs;
			if (childs != null) {
				for (Node child : childs) {
					if (!visited[child.no]) {
						visited[child.no] = true;
						pq.add(new BFSNode(child, bfsNode.dist + 1));
					}
				}
			}
		}

		return ret;
	}

}

class SolutionD {
	public int[] solution(int N, int[][] directory, int[][] query) {
		Graph g = new Graph();
		g.init(N, directory, query);
		int[] answer = g.solve();
		return answer;
	}
}

public class D {

	public static void main(String[] args) {
		SolutionD solution = new SolutionD();
		int N = 5;
		int[][] directory = { {3, 6}, {6, 7}, {4, 2}, {1, 3}, {2, 5}, {1, 2} };
		int[][] query = { {1, 7}, {7, 5}, {4, 2} };
		solution.solution(N, directory, query);
	}

}
