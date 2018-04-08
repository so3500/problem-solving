/*
* 문제: 1806 부분합 / 268 ms
* link: https://www.acmicpc.net/problem/1806
* 알고리즘: DP, two-pointer
* 풀이방법:
* 	DP[i]: arr 배열의 index 1 to i 까지 의 합
* 	DP[i] + DP[j-1]: arr 배열의 index j부터 i까지의 합(상수시간에 구할 수 있다)
* 	sum 값이 S보다 작을 경우 right index 증가(더 많은 수가 필요하므로)
* 	sum 값이 S보다 클 경우 left index 를 증가(그 이상의 수가 필요없으므로)
* 
* 	단, DP를 사용하지 않고 투 포인터를 이용하여 leftIndex 증가 시 leftIndex-1값을 sum에서 빼고
* 	rightIndex 증가 시 rightIndex에 해당하는 값을 sum에 더하는 방법으로 구현할 수도 있다.
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*   입력 N일 때 1차원 배열을 right, left pointer를 이용하여 두번 탐색하는 경우 
*   O(N)
*
* 공간복잡도(Space Complexity)
*   입력 N일 때 1차원 배열 사용
*   O(N)
*
* */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1806 {

	static int N, S, minLen;
	static int[] arr, DP;
	static boolean find;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(minLen);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);
		arr = new int[N + 1];
		DP = new int[N + 1];
		input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			arr[i + 1] = Integer.parseInt(input[i]);
			DP[i + 1] = DP[i] + arr[i + 1];
		}
		minLen = Integer.MAX_VALUE;
		br.close();
	}

	static void solve() {
		int left, right, sum, len;
		len = 0;
		left = 1;
		right = 1;
		sum = 0;
		find = false;
		while (left <= right && right <= N) {
			if (left == right) {
				sum = arr[left];
				len = 1;
			} else if (left < right) {
				sum = DP[right] - DP[left - 1];
			}

			if (sum < S) {
				right++;
				len++;
			} else {
				find = true;
				minLen = Integer.min(minLen, len);
				left++;
				len--;
			}
		}
		if (!find) minLen = 0;
	}
}
