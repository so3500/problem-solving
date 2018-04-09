/*
* 문제: 13458 시험감독 / 692 ms
* link: https://www.acmicpc.net/problem/13458
* 알고리즘: 구현
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

import java.util.Scanner;

public class Boj_13458 {

	static int N, A, B, C;
	static long minNum;
	static int[] room;

	public static void main(String[] args) {
		init();
		solve();
		System.out.println(minNum);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		room = new int[N];
		for (int i = 0; i < N; i++) {
			room[i] = sc.nextInt();
		}
		B = sc.nextInt();
		C = sc.nextInt();
		minNum = 0;
		sc.close();
	}

	static void solve() {
		int q;
		// 총감독관의 수 = 시험장의 수
		minNum += N;
		// 시험장마다 총 감독관이 감시할 수 있는 수를 제외한 나머지 응시자들을 감독하는
		// 최대 부감독관 구하기
		for (int i = 0; i < N; i++) {
			room[i] -= B;
			if (room[i] < 0) continue;
			q = room[i] / C;
			minNum += q;
			room[i] -= q * C;
			if (room[i] > 0) minNum++;
		}
	}
}
