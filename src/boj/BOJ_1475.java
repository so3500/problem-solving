/*
* 문제: 1475 방 번호
* link: https://www.acmicpc.net/problem/1475
* 알고리즘: 수학, 문자열처리
* 풀이방법:
*
*/

package boj;

import java.util.Scanner;

public class BOJ_1475 {

	static class Solution {
		int N;
		int answer;
		int[] num;

		public void init() {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			num = new int[10];
			answer = 0;
			int tmp = N;
			while (tmp > 0) {
				int digit = tmp % 10;
				tmp /= 10;

				// 방번호 6을 9로 취급
				if (digit == 6) {
					num[9]++;
				} else {
					num[digit]++;
				}
			}
			sc.close();
		}

		public void solve() {
			int setNum = 0;
			for (int digit = 0; digit < 9; digit++) {
				setNum = Integer.max(setNum, num[digit]);
			}

			int diff = num[9] - setNum * 2;
			if (diff > 0) {
				setNum += (diff / 2);
				if (diff % 2 == 1) {
					setNum++;
				}
			}

			answer = setNum;

			// 방번호가 0일 경우 1set
			if (N == 0) {
				answer = 1;
			}
			System.out.println(answer);
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.init();
		solution.solve();
	}

}
