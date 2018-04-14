/*
* 문제: 7562 나이트의 이동 / 80 ms
* link: https://www.acmicpc.net/problem/11933
* 알고리즘: DFS
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

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_2667 {

	static int N;
	static PriorityQueue<Integer> pq;
	static boolean[][] map;
	static int[] rows = { -1, 0, 1, 0 }, cols = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		init();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 집이 있는 곳에서 dfs 수행
				if (map[r][c]) {
					map[r][c] = false;
					pq.add(dfs(r, c)); // 결과값을 우선순위 큐에 저장
				}
			}
		}
		// 우선순위 큐의 크기와 오름차순으로 저장된 요소 출력
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.remove()).append("\n");
		}
		System.out.println(sb);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		String input;
		int r, c;
		N = sc.nextInt();
		map = new boolean[N][N];
		for (r = 0; r < N; r++) {
			input = sc.next();
			for (c = 0; c < N; c++) {
				if (input.charAt(c) == '1') {
					map[r][c] = true;
				}
			}
		}
		pq = new PriorityQueue<>();
		sc.close();
	}

	// dfs를 재귀로 수행하여 해당 r,c 에서 갈 수 있는 집의 개수를 리턴
	static int dfs(int r, int c) {
		int toR, toC, cnt;
		cnt = 1;

		for (int i = 0; i <= 3; i++) {
			toR = r + rows[i];
			toC = c + cols[i];
			if (toR < 0 || toC < 0 || N <= toR || N <= toC || !map[toR][toC])
				continue;
			map[toR][toC] = false;
			cnt += dfs(toR, toC);
		}
		return cnt;
	}

}
