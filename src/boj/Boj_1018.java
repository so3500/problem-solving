/*
* 문제: 1018 체스판 다시 칠하기 / 136 ms
* link: https://www.acmicpc.net/problem/1018
* 알고리즘: 구현, 완전탐색
* 풀이방법:
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*	O(N^2)	
*
* 공간복잡도(Space Complexity)
*	O(N^2)
* */

package boj;

import java.util.Scanner;

public class Boj_1018 {

	static int N, M, minCnt;
	static char[][] map;

	public static void main(String[] args) {
		init();
		int cnt;
		for (int r = 0; r <= N - 8 && (minCnt != 0); r++) {
			for (int c = 0; c <= M - 8 && (minCnt != 0); c++) {
				cnt = solve(r, c);
				minCnt = Integer.min(minCnt, cnt);
			}
		}
		System.out.println(minCnt);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		int r, c;
		String input;
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		for (r = 0; r < N; r++) {
			input = sc.next();
			for (c = 0; c < M; c++) {
				map[r][c] = input.charAt(c);
			}
		}
		minCnt = Integer.MAX_VALUE;
	}

	static int solve(int r, int c) {
		int rowCnt, colCnt, row, col, cnt1, cnt2;
		// (r, c)에서 시작하는 8*8 체스판일 때 
		// 기준이 되는 색을 W, B 두 가지로 놓고 각각의 경우에 대하여 탐색
		char ch1 = 'W';
		char ch2 = 'B';
		rowCnt = 0;
		cnt1 = 0;
		cnt2 = 0;
		for (row = r; row <= r + 7; row++) {
			colCnt = 0;
			for (col = c; col <= c + 7; col++) {
				if ((rowCnt % 2 == 0 && colCnt % 2 == 0) || (rowCnt % 2 == 1 && colCnt % 2 == 1)) {
					// 기준색과 같아야 함, 다를경우 카운트
					if (ch1 != map[row][col]) cnt1++;
					if (ch2 != map[row][col]) cnt2++;
				} else if ((rowCnt % 2 == 0 && colCnt % 2 == 1) || (rowCnt % 2 == 1 && colCnt % 2 == 0)) {
					// 기준색과 달라야 함, 같은경우 카운트
					if (ch1 == map[row][col]) cnt1++;
					if (ch2 == map[row][col]) cnt2++;
				}
				colCnt++;
			}
			rowCnt++;
		}
		return Integer.min(cnt1, cnt2);
	}
}
