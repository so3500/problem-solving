package kakao.codefestival_2018.b;

import java.util.Scanner;

public class Main {

	static int N, K;
	static int[] arr, arrSum;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		init(sc);
		double ans = solve();
		System.out.println(ans);
		sc.close();
	}

	static void init(Scanner sc) {
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		arrSum = new int[N];
		arr[0] = sc.nextInt();
		arrSum[0] = arr[0];
		for (int idx = 1; idx < N; idx++) {
			arr[idx] = sc.nextInt();
			arrSum[idx] = arrSum[idx - 1] + arr[idx];
		}
	}

	static double solve() {
		double ans = Double.MAX_VALUE;

		for (int selectCnt = K; selectCnt <= N; selectCnt++) {
			for (int startIdx = 0; startIdx <= N - selectCnt; startIdx++) {
				int toIdx = startIdx + selectCnt - 1;
				double sum = arrSum[toIdx] - arrSum[startIdx] + arr[startIdx];
				double m = sum / selectCnt;
				double sdv = getSDV(startIdx, toIdx, selectCnt, m);
				ans = Double.min(ans, sdv);
			}
		}
		return ans;
	}

	static double getSDV(int startIdx, int toIdx, int n, double m) {
		double sdv = 0.0;

		double sum = 0.0;
		for (int idx = startIdx; idx <= toIdx; idx++) {
			sum += Math.pow((arr[idx] - m), 2);
		}
		sdv = Math.sqrt(sum / n);
		return sdv;
	}
}