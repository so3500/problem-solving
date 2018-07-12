/*
* 문제: 1049 기타줄
* link: https://www.acmicpc.net/problem/1049
* 알고리즘: 그리티 알고리즘
* 풀이방법:
*	각 브랜드의 패키지, 낱개가격 중 최소가격을 구한다.
*	각 패키지와 낱개가격을 가지고 최선의 선택을 한다.
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

public class BOJ_1049 {

	private static int N, M, minTotalCost, minPackCost, minUnitCost;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		init(sc);
		solve();
		System.out.println(minTotalCost);
		sc.close();
	}

	private static void init(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
		int packCost, unitCost;
		minPackCost = Integer.MAX_VALUE;
		minUnitCost = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			packCost = sc.nextInt();
			unitCost = sc.nextInt();
			minPackCost = Integer.min(minPackCost, packCost);
			minUnitCost = Integer.min(minUnitCost, unitCost);
		}
	}

	private static void solve() {
		minTotalCost = 0;

		if (minPackCost >= minUnitCost * 6) { // 낱개가 가장 쌀 경우
			minTotalCost = N * minUnitCost;
		} else {
			if (N <= 6) { // 한 팩이 쌀 경우
				minTotalCost = minPackCost;
			} else {
				minTotalCost = (N / 6) * minPackCost;
				N -= (N / 6) * 6;
				if (minPackCost < minUnitCost * N) { // 팩 단위로 사고 나머지를 팩으로 처리
					minTotalCost += minPackCost;
				} else { // 팩 단위로 사고 나머지를 낱개로 처리
					minTotalCost += (minUnitCost * N);
				}
				N = 0;
			}
		}
	}

}
