/*
* 문제: 5644. [모의 SW 역량테스트] 무선 충전
* problem-link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo
* solution-link: 
*/

package swexpert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SE_5644 {

	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static class BC extends Node {
		int c; // 충전범위
		int p; // 처리량

		public BC(int row, int col, int c, int p) {
			super(row, col);
			this.c = c;
			this.p = p;
		}
	}

	static class Person extends Node {

		public Person(int row, int col) {
			super(row, col);
		}
	}

	static class BFSNode extends Node {
		int cnt;

		public BFSNode(int row, int col, int cnt) {
			super(row, col);
			this.cnt = cnt;
		}
	}

	static int moveTime;
	static int bcCnt;
	static int maxCharge;
	static final int MAP_SIZE = 10;
	static int[] aMoveDir;
	static int[] bMoveDir;
	static int[] rows = { 0, -1, 0, 1, 0 };
	static int[] cols = { 0, 0, 1, 0, -1 };
	static List<Integer>[][] map;
	static boolean[][] isConn;
	static BC[] BCs;
	static Person p1;
	static Person p2;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			init(sc);
			initMap();
			p1 = new Person(0, 0);
			p2 = new Person(9, 9);
			maxCharge = 0;
			for (int time = 0; time <= moveTime; time++) {
				move(time);
				findBC();
				charge();
			}
			System.out.println("#" + test_case + " " + maxCharge);
		}

		sc.close();
	}

	static void init(Scanner sc) {
		moveTime = sc.nextInt();
		bcCnt = sc.nextInt();
		sc.nextLine();
		String[] moveDir = sc.nextLine().split(" ");

		// 사용자 이동 방향 목록 초기화
		aMoveDir = new int[moveDir.length + 1];
		aMoveDir[0] = 0;
		for (int idx = 1; idx <= moveDir.length; idx++) {
			aMoveDir[idx] = Integer.parseInt(moveDir[idx - 1]);
		}
		moveDir = sc.nextLine().split(" ");
		bMoveDir = new int[moveDir.length + 1];
		bMoveDir[0] = 0;
		for (int idx = 1; idx <= moveDir.length; idx++) {
			bMoveDir[idx] = Integer.parseInt(moveDir[idx - 1]);
		}

		// 충전기 목록 초기화
		BCs = new BC[bcCnt];
		for (int id = 0; id < bcCnt; id++) {
			int col = sc.nextInt() - 1;
			int row = sc.nextInt() - 1;
			int c = sc.nextInt();
			int p = sc.nextInt();
			BCs[id] = new BC(row, col, c, p);
		}

	}

	static void initMap() {
		map = new ArrayList[MAP_SIZE][MAP_SIZE];
		for (int row = 0; row < MAP_SIZE; row++) {
			for (int col = 0; col < MAP_SIZE; col++) {
				map[row][col] = new ArrayList<>();
			}
		}

		for (int bcId = 0; bcId < bcCnt; bcId++) {
			int row = BCs[bcId].row;
			int col = BCs[bcId].col;
			int c = BCs[bcId].c;
			bfs(c, bcId, row, col);
		}

	}

	static void bfs(int cnt, int bcId, int row, int col) {
		boolean[][] visited = new boolean[MAP_SIZE][MAP_SIZE];
		Queue<BFSNode> q = new LinkedList<>();
		q.add(new BFSNode(row, col, cnt));
		visited[row][col] = true;
		map[row][col].add(bcId);
		while (!q.isEmpty()) {
			BFSNode node = q.remove();

			for (int dir = 1; dir <= 4; dir++) {
				int toRow = node.row + rows[dir];
				int toCol = node.col + cols[dir];
				if (toRow >= 0 && toRow < MAP_SIZE && toCol >= 0 && toCol < MAP_SIZE && !visited[toRow][toCol]
						&& node.cnt > 0) {
					visited[toRow][toCol] = true;
					map[toRow][toCol].add(bcId);
					q.add(new BFSNode(toRow, toCol, node.cnt - 1));
				}
			}
		}
	}

	// 사람 A, B의 위치에 따라 연결 가능한 충전기 위치 탐색
	static void findBC() {
		isConn = new boolean[2][bcCnt];
		for (int bcId : map[p1.row][p1.col]) {
			isConn[0][bcId] = true;
		}
		for (int bcId : map[p2.row][p2.col]) {
			isConn[1][bcId] = true;
		}
	}

	// 모든 연결된 충전기에 대해 완전탐색 
	static void charge() {
		int maxChrg = Integer.MIN_VALUE;
		for (int bc1 = 0; bc1 < bcCnt; bc1++) {
			for (int bc2 = 0; bc2 < bcCnt; bc2++) {
				int chrg = 0;
				if (isConn[0][bc1]) {
					chrg += BCs[bc1].p;
				}
				if (isConn[1][bc2]) {
					chrg += BCs[bc2].p;
				}

				// 두 사용자가 하나의 충전기를 사용하고 있다면 총 충전량을 반으로 나눈
				if (isConn[0][bc1] && isConn[1][bc2] && bc1 == bc2) {
					chrg /= 2;
				}
				maxChrg = Integer.max(maxChrg, chrg);
			}
		}
		maxCharge += maxChrg;
	}

	static void move(int time) {
		int aDir = aMoveDir[time];
		int bDir = bMoveDir[time];
		p1.row += rows[aDir];
		p1.col += cols[aDir];
		p2.row += rows[bDir];
		p2.col += cols[bDir];
	}

}
