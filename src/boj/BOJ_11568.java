/*
* 문제: 11568 민균이의 계략
* link: https://www.acmicpc.net/problem/11568
* 알고리즘: LIS
* 풀이방법:
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*   O(N^2)
*
* 공간복잡도(Space Complexity)
*   O(N)
*
* */

package boj;

import java.util.Scanner;

public class BOJ_11568 {

	private static int N, maxLen;
	private static int[] arr, DP;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		init(sc);
		solve();
		System.out.println(maxLen);
		sc.close();
	}

	private static void init(Scanner sc) {
		N = sc.nextInt();
		arr = new int[N];
		DP = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		maxLen = 0;
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			DP[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					DP[i] = Integer.max(DP[i], DP[j] + 1);
				}
			}
			maxLen = Integer.max(maxLen, DP[i]);
		}
	}

}
