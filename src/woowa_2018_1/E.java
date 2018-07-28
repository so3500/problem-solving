package woowa_2018_1;

public class E {

	public static void main(String[] args) {
		int[] arr = { 6, 1, 4, 6, 3, 2, 7, 4 };
		System.out.println(solution(arr, 3, 2));

	}

	public static int solution(int[] A, int K, int L) {
		int ret, i, j, aLen, aSum, bSum;
		aLen = A.length;
		int[] sum = new int[aLen + 1];
		sum[0] = 0;
		sum[1] = A[0];
		for (i = 1; i < aLen; i++) {
			sum[i + 1] = sum[i] + A[i];
		}

		aSum = 0;
		bSum = 0;
		ret = Integer.MIN_VALUE;

		if (K + L > aLen) {
			ret = -1;
		} else if (K + L == aLen) {
			ret = sum[aLen];
		} else {
			for (i = K; i <= aLen; i++) {
				aSum = sum[i] - sum[i - K];
				// left
				if (L < i - K + 1) {
					for (j = L; j < i - K + 1; j++) {
						bSum = sum[j] - sum[j - L];
						ret = Integer.max(ret, aSum + bSum);
					}
				}
				// right
				if (i + L + 1 < aLen + 1) {
					for (j = i + L; j <= aLen; j++) {
						bSum = sum[j] - sum[j - L];
						ret = Integer.max(ret, aSum + bSum);
					}
				}
			}
		}
		return ret;
	}

}
