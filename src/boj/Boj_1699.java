/*
* 문제: 1699 제곱수의 함 / 2576 ms
* link: https://www.acmicpc.net/problem/1699
* 알고리즘: DP
* 풀이방법:
* 	DP[i]: 숫자 i로 나타낼 수 있는 제곱수의 수 중 최소값
*   숫자 i일 때 (1, i-1), (2, i-2), ... 의 쌍 중에서 DP의 합이 최소인 값을 DP[i]에 저장한다.
* 
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
*
* */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1699 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, i, left, right;
		int[] DP;
		N = sc.nextInt();
		DP = new int[N + 1];
		i = 1;
		Arrays.fill(DP, Integer.MAX_VALUE);
		// 제곱수 구하기
		while (true) {
			if (i * i <= N) DP[i * i] = 1;
			else break;
			i++;
		}

		for (i = 2; i <= N; i++) {
			if (DP[i] == 1) continue;
			left = 1;
			right = i - 1;
			while (left <= right) {
				DP[i] = Integer.min(DP[i], DP[left] + DP[right]);
				left++;
				right--;
			}
		}
		System.out.println(DP[N]);
	}
}
