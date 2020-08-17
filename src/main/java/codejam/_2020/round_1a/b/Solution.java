package codejam._2020.round_1a.b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int caseNum = 1; caseNum <= T; caseNum++) {
			// init
			int N = sc.nextInt();
			long D = sc.nextLong();
			long[] x = new long[N];
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextLong();
			}

			// solve
			for (int i = N - 1; i >= 0; i--) {
				D = D - (D % x[i]);
			}

			// printAnswer
			System.out.printf("Case #%d: %d\n", caseNum, D);
		}
		sc.close();

	}
}
