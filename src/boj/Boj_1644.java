/*
* 문제: 1644 소수의 연속합 / 200 ms
* link: https://www.acmicpc.net/problem/1644
* 알고리즘: 에라토스테네스의 체(소수 구하는 알고리즘), 투 포인터
* 풀이방법:
* 
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*   입력 N일 때 2 ~ N 범위에 해당하는 소수를 에라토스테네스의 체 알고리즘을 이용하여 구하므로 O(NloglogN)
*   이때 구한 소수의 개수는 N보다 항상 작으므로(2, 3 의 경우 제외) 최대 N개라고 가정하자.
*   연속된 소수의 합을 구할 때 투 포인터를 사용할 경우 left, right 포인터 둘 다 index 0 부터 N 까지 선형 탐색하므로 O(N)
*   따라서 O(NloglogN)
*
* 공간복잡도(Space Complexity)
*   입력 N에 대하여 1차원 배열을 사용하므로
*   O(N)
*
* */


package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_1644 {

	static int N, cnt;
	static boolean[] prime;
	static List<Integer> primeList;

	public static void main(String[] args) {
		init();
		if(N != 1) solve();
		System.out.println(cnt);			
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		prime = new boolean[N + 1];
		primeList = new ArrayList<>(N);
		cnt = 0;
		sc.close();
	}

	static void solve() {
		// 1. 에라토스테네스의 체로 2 to N 범위의 소수 구하기
		int num, start, left, right, sum;
		for (start = 2; start <= N; start++) {
			num = start;
			if (prime[num]) continue;
			num += start;
			while (num <= N) {
				prime[num] = true;
				num += start;
			}
			// 소수 리스트에 추가
			primeList.add(start);
		}

		// 2. 소수의 연속합 경우의 수 구하기
		left = 0;
		right = 0;
		sum = primeList.get(0);
		
		while (left <= right) {
			if (sum < N) {
				// 합이 N보다 작으면 오른쪽 소수 추가
				right++;
				if(right == primeList.size()) break;
				sum += primeList.get(right);
			} else if (sum == N) {
				cnt++;
				// e.g. N: 41 일 때 left, right 가 41에 해당하는 인덱스까지 왔으므로 더 이상 탐색 할 필요 없음
				if (left == right) break;
				sum -= primeList.get(left);
				left++;
				right++;
				if(right == primeList.size()) break;		
				sum += primeList.get(right);
			} else {
				// 합이 N보다 크면 왼쪽 소수 삭제
				sum -= primeList.get(left);
				left++;
			}
		}
	}
}
