package scpc_2018_r1;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	static int Answer;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int N, K, i, j, busCnt;
			N = sc.nextInt();
			K = sc.nextInt();
			int[] input = new int[N + 1];
			int[] bus = new int[N + 1];
			boolean find = false;
			for (i = 0; i < N; i++) {
				input[i] = sc.nextInt();
			}
			Arrays.sort(input, 0, N);
			Arrays.fill(bus, -1000000001);
			busCnt = 1;
			for (i = 0; i < N; i++) {
				for (j = 0; j < busCnt; j++) {
					if (abs(input[i], bus[j]) > K) {
						bus[j] = input[i];
						find = true;
						break;
					}
					find = false;
				}
				if (!find) {
					bus[j] = input[i];
					busCnt++;
				}
			}
			Answer = busCnt;
			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
	}

	public static int abs(int a, int b) {
		if (a >= b) {
			return a - b;
		} else {
			return b - a;
		}
	}
}
