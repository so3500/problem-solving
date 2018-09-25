package sw_test.kakao.codefestival_2018.a;

import java.util.Scanner;

public class Main {

	static int a, b;
	static int[] first, second;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		init(sc);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			int sum = 0;
			if (a <= 21) {
				sum += first[a];
			}
			if (b <= 31) {
				sum += second[b];
			}
			System.out.println(sum * 10000);
		}
		sc.close();
	}

	static void init(Scanner sc) {
		first = new int[22];
		second = new int[32];

		int[] firstTable = { 0, 500, 300, 200, 50, 30, 10 };
		int[] secondTable = { 0, 512, 256, 128, 64, 32 };

		int cnt = 0;
		int personIdx = 1;
		for (int prizeIdx = 1; prizeIdx <= 6; prizeIdx++) {
			cnt++;
			for (int idx = 0; idx < cnt; idx++) {
				first[personIdx] = firstTable[prizeIdx];
				personIdx++;
			}
		}

		cnt = 1;
		personIdx = 1;
		for (int prizeIdx = 1; prizeIdx <= 5; prizeIdx++) {
			for (int idx = 0; idx < cnt; idx++) {
				second[personIdx] = secondTable[prizeIdx];
				personIdx++;
			}
			cnt *= 2;
		}

	}

}