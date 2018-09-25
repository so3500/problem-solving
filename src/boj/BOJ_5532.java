/*
 * 5532 방학숙제
 * https://www.acmicpc.net/problem/5532
 * 시뮬레이션, 구현
 * */

package boj;

import java.util.Scanner;

public class BOJ_5532 {

	private static int L, A, B, C, D, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		init(sc);
		solve();

		System.out.println(ans);
	}

	private static void init(Scanner sc) {
		L = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		ans = 0;
	}

	private static void solve() {
		int mathStudyDay = getStudyDay(A, C);
		int koreanStudyDay = getStudyDay(B, D);

		ans = L - Integer.max(mathStudyDay, koreanStudyDay);
		if (ans < 0) {
			ans = 0;
		}
	}

	private static int getStudyDay(int allWorkload, int dayWorkload) {
		int studyDay = 0;
		int workload = 0;
		while (workload < allWorkload) {
			workload += dayWorkload;
			studyDay++;
		}
		return studyDay;
	}

}
