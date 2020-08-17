package codejam._2020.round_1a.a;

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
			int[] h = new int[N];
			for (int i = 0; i < N; i++) {
				h[i] = sc.nextInt();
			}
			// solve
			int numOfPeaks = 0;
			for (int i = 1; i < N - 1; i++) {
				if (h[i - 1] < h[i] && h[i] > h[i + 1]) {
					numOfPeaks++;
				}
			}

			// printAnswer
			System.out.printf("Case #%d: %d\n", caseNum, numOfPeaks);
		}
		sc.close();

	}
}
