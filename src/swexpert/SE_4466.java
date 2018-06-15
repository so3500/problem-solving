package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_4466 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, t, N, K, maxSum, i;
		int[] arr;
		T = sc.nextInt();
		for (t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			for (i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			maxSum = 0;
			for (i = N - 1; i > N - 1 - K; i--) {
				maxSum += arr[i];
			}
			System.out.println("#" + t + " " + maxSum);
		}
		sc.close();
	}

}
