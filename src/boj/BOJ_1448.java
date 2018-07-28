/*
* 문제: 1448 삼각형 만들
* link: https://www.acmicpc.net/problem/1448
* 알고리즘: 수
* 풀이방법:
* 	세 변의 길이를 알 때 삼각형의 조건은 (가장 긴 변의 길이) > 나머지 두 변의 길이의 합
*	배열에 변의 길이 정보를 입력
*	정렬
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*   O(NlogN)
*
* 공간복잡도(Space Complexity)
*   O(N)
*
* */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1448 {

	private static int N;
	private static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		init(sc);
		int maxSum = solve();
		System.out.println(maxSum);
		sc.close();
	}

	private static void init(Scanner sc) {
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
	}

	private static int solve() {
		for (int i = N - 1; i >= 2; i--) {
			if (arr[i] < arr[i - 1] + arr[i - 2]) {
				return arr[i] + arr[i - 1] + arr[i - 2];
			}
		}
		return -1;
	}

}
