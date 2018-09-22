package sw_test.codemonster_test_2018_1st;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class SolutionB {

	class Node {
		int row;
		int col;
		int dist;

		public Node(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	boolean[][] visited;
	int[][] newHouse;
	int[] rows = { -1, 0, 1, 0 };
	int[] cols = { 0, 1, 0, -1 };
	final int SIZE = 201;
	int answer;
	int N;
	PriorityQueue<Node> factoryPQ;
	PriorityQueue<Node> homePQ;
	Queue<Node> homeQ;

	public int solution(int N, int[][] house) {
		init(N, house);
		bfs();
		solve();
		return answer;
	}

	public void init(int N, int[][] house) {
		this.N = N;
		answer = Integer.MAX_VALUE;
		factoryPQ = new PriorityQueue<>((a, b) -> b.dist - a.dist);
		homePQ = new PriorityQueue<>((a, b) -> a.dist - b.dist);
		homeQ = new LinkedList<>();
		visited = new boolean[SIZE][SIZE];
		newHouse = new int[SIZE][SIZE];
		for (int hIdx = 0; hIdx < house.length; hIdx++) {
			int col = house[hIdx][0] + 100;
			int row = house[hIdx][1] + 100;
			homePQ.add(new Node(row, col, 0));
			homeQ.add(new Node(row, col, 0));
			visited[row][col] = true;
		}
	}

	public void bfs() {
		while (!homePQ.isEmpty()) {
			Node node = homePQ.remove();

			for (int idx = 0; idx < 4; idx++) {
				int toRow = node.row + rows[idx];
				int toCol = node.col + cols[idx];
				if (isValid(toRow, toCol)) {
					visited[toRow][toCol] = true;
					homePQ.add(new Node(toRow, toCol, node.dist + 1));
					factoryPQ.add(new Node(toRow, toCol, node.dist + 1));
				}
			}
		}
	}

	public boolean isValid(int row, int col) {
		if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && !visited[row][col]) {
			return true;
		} else {
			return false;
		}
	}

	public void solve() {
		int cnt = N;
		Node factory = null;
		while (cnt > 0) {
			factory = factoryPQ.remove();
			cnt--;
		}
		while (!homeQ.isEmpty()) {
			Node home = homeQ.remove();
			int dist = (int) Math.pow(factory.row - home.row, 2) + (int) Math.pow(factory.col - home.col, 2);
			answer = Integer.min(answer, dist);
		}
	}

}

public class B {

	public static void main(String[] args) {
		SolutionB solution = new SolutionB();
		int N = 1;
		int[][] house = {{0, 0}};
		System.out.println(solution.solution(N, house));
	}

}
