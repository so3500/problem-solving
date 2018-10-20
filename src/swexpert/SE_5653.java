/*
* 문제: 5653. [모의 SW 역량테스트] 줄기세포배양
* problem-link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo
* solution-link: https://bibibim.tistory.com/7
*/

package swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SE_5653 {

	static class Node {
		int row;
		int col;
		int life;
		int createdTime;
		int activeTime;

		public Node(int row, int col, int life) {
			this.row = row;
			this.col = col;
			this.life = life;
		}

		public Node(int row, int col, int life, int createdTime) {
			this.row = row;
			this.col = col;
			this.life = life;
			this.createdTime = createdTime;
		}
	}

	static final int SIZE = 850;
	static final int compenSize = 400;
	static final int DIR_SIZE = 4;
	static int N;
	static int M;
	static int K;
	static int curTime;
	static int[] rows = { -1, 0, 1, 0 };
	static int[] cols = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visited;
	static Queue<Node> deactQueue;
	static Queue<Node> candiQueue;
	static Queue<Node> actQueue;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			init(sc);
			int aliveCellCnt = getAliveCell();
			System.out.println(String.format("#%d %d", test_case, aliveCellCnt));
		}
		sc.close();
	}

	static void init(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[SIZE][SIZE];
		visited = new boolean[SIZE][SIZE];
		deactQueue = new LinkedList<>();
		candiQueue = new LinkedList<>();
		actQueue = new LinkedList<>();
		for (int r = compenSize; r < compenSize + N; r++) {
			for (int c = compenSize; c < compenSize + M; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] > 0) {
					deactQueue.add(new Node(r, c, map[r][c], 0));
					visited[r][c] = true;
				}
			}
		}
	}

	static int getAliveCell() {
		curTime = 0;
		while (curTime <= K) {
			actQueueToCandiQueue();
			candiQueueToDeactQueue();
			deactQueueToActQueue();
//			printMap();
			curTime++;
		}

		int aliveCell = deactQueue.size() + actQueue.size();
		return aliveCell;
	}

	// 비활성 상태의 세포 중 활성 상태가 되는 세포를 활성큐에 추가
	static void deactQueueToActQueue() {
		int cnt = deactQueue.size();
		while (cnt > 0) {
			Node cell = deactQueue.remove();
			if (curTime - cell.createdTime == cell.life) {
				actQueue.add(new Node(cell.row, cell.col, cell.life, cell.createdTime));
				deactQueue.remove(cell);
			} else {
				deactQueue.add(cell);
			}
			cnt--;
		}
	}

	// 활성 큐에 있는 세포의 주변 활성예상 지점을 후보큐에 추가(단, 최대 생명력이 높아질 더 높아질 경우에만 추가)
	static void actQueueToCandiQueue() {
		int cnt = actQueue.size();
		while (cnt > 0) {
			Node cell = actQueue.remove();
			for (int dir = 0; dir < DIR_SIZE; dir++) {
				int toRow = cell.row + rows[dir];
				int toCol = cell.col + cols[dir];
				if (!visited[toRow][toCol] && cell.life > map[toRow][toCol]) {
					map[toRow][toCol] = cell.life;
					candiQueue.add(new Node(toRow, toCol, cell.life));
				}
			}
			// 생명력이 다한 세포는 활성 큐에서 제거
			int activeTime = cell.createdTime + cell.life * 2;
			if (activeTime == curTime) {
				actQueue.remove(cell);
			} else {
				actQueue.add(cell);
			}
			cnt--;
		}
	}

	// 후보큐에 있는 세포를 비활성 큐에 추가(map의 생명력과 후보큐의 생명력이 같을때만)
	static void candiQueueToDeactQueue() {
		while (!candiQueue.isEmpty()) {
			Node cell = candiQueue.remove();
			if (map[cell.row][cell.col] != cell.life) {
				continue;
			}
			visited[cell.row][cell.col] = true;
			deactQueue.add(new Node(cell.row, cell.col, cell.life, curTime));
		}
	}

	static void printMap() {
		System.out.println("curTime: " + curTime);
		for (int r = compenSize - N * 3; r < compenSize + N * 3; r++) {
			for (int c = compenSize - M * 3; c < compenSize + M * 3; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
