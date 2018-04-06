/*
* 문제: 14499 주사위 굴리기 / 184 ms
* link: https://www.acmicpc.net/problem/14499
* 알고리즘: 구현
* 풀이방법:
* 
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
*
* */


package boj;

import java.util.Scanner;

public class Boj_14499 {

	static int N, M, K, row, col;
	static int[][] map;
	static int[] dice;
	static int[] rows = { 999, 0, 0, -1, 1 };
	static int[] cols = { 999, 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int direction;
		StringBuilder sb = new StringBuilder();
		init(sc);
		for (int i = 0; i < K; i++) {
			direction = sc.nextInt();
			move(direction, sb);
		}
		System.out.println(sb);
	}

	static void init(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
		row = sc.nextInt();
		col = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		dice = new int[6]; // 0: 상단, 5: 하단, 3: 서쪽, 2: 동쪽, 4: 앞면, 1: 뒷면
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
	}

	static void move(int direction, StringBuilder sb) {
		int temp, toRow, toCol;
		temp = dice[0];
		toRow = row + rows[direction];
		toCol = col + cols[direction];
		if (toRow < 0 || toCol < 0 || N <= toRow || M <= toCol) return;
		row = toRow;
		col = toCol;
		switch (direction) {
		case 1: // 동쪽
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
			break;
		case 2: // 서쪽
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
			break;
		case 3: // 북쪽
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
			break;
		case 4: // 남쪽
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
			break;
		}

		// 이동 시 지도에 적힌 값에 따라 분기
		if (map[row][col] == 0) {
			map[row][col] = dice[5];
		} else {
			dice[5] = map[row][col];
			map[row][col] = 0;
		}

		// 이동할 때마다 주사위의 맨 윗면에 써 있는 수 출력
		sb.append(dice[0]).append("\n");
	}
}
