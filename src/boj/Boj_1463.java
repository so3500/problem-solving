/*
* 문제: 1463 1로 만들기 / 152 ms
* link: https://www.acmicpc.net/problem/1463
* 알고리즘: DP
* 풀이방법:
* 	init DP with Integer.MAX_VALUE
* 	i 가 2, 3의 배수일 경우
* 		DP[i] <- min(DP[i], DP[i/2]+1, DP[i/3]+1, DP[i-1]+1)
* 	i 가 3의 배수일 경우
* 		DP[i] <- min(DP[i], DP[i/3]+1, DP[i-1]+1)
* 	else
* 		DP[i] <- min(DP[i], DP[i-1]+1)
* 	
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*   입력 N일 때 1차원 배열을 한번 탐색하므로
*   O(N)
*
* 공간복잡도(Space Complexity)
*   입력 N일 때 1차원 배열을 사용하므로
*   O(N)
*
* */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, i;
		N = sc.nextInt();
		int[] DP = new int[N + 1];
		Arrays.fill(DP, Integer.MAX_VALUE);
		DP[0] = 0;
		DP[1] = 0;
		if (N >= 2) DP[2] = 1;
		if (N >= 3) DP[3] = 1;
		for (i = 4; i <= N; i++) {
			if (i % 2 == 0) DP[i] = Integer.min(DP[i], DP[i / 2] + 1);
			if (i % 3 == 0) DP[i] = Integer.min(DP[i], DP[i / 3] + 1);
			DP[i] = Integer.min(DP[i], DP[i - 1] + 1);
		}
		System.out.println(DP[N]);
		sc.close();
	}
}
