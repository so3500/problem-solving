/*
* 문제: 1074 Z / 124 ms
* link: https://www.acmicpc.net/problem/1074
* 알고리즘: 수학, 분할정복, 재귀호출
* 풀이방법:
*  참고: http://mygumi.tistory.com/284
*  
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

public class Boj_1074 {

	static int cnt, N, r, c;
	static boolean find;

	public static void main(String[] args) {
		init();
		solve(0, 0, (int)Math.pow(2, N));
	}

	public static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		cnt = 0;
		find = false;
		sc.close();
	}

	public static void solve(int row, int col, int len) {
		if (find) {
			return;
		} else if (len == 1) {
			if (row == r && col == c) {
				find = true;
				System.out.println(cnt);
			}
			cnt++;
			return;
		}

		if (Math.abs(r - row) >= len / 2 || Math.abs(c - col) >= len / 2) {
			cnt += (len * len) / 4;
		} else {
			solve(row, col, len / 2);
		}
		if (Math.abs(r - row) >= len / 2 || Math.abs(c - len / 2 - col) >= len / 2) {
			cnt += (len * len) / 4;
		} else {
			solve(row, col + len / 2, len / 2);
		}
		if (Math.abs(r - len / 2 - row) >= len / 2 || Math.abs(c - col) >= len / 2) {
			cnt += (len * len) / 4;
		} else {
			solve(row + len / 2, col, len / 2);
		}
		if (Math.abs(r - len / 2 - row) >= len / 2 || Math.abs(c - len / 2 - col) >= len / 2) {
			cnt += (len * len) / 4;
		} else {
			solve(row + len / 2, col + len / 2, len / 2);
		}
	}

}
