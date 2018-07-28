package woowa_2018_1;

public class Test {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] A) {
		int ret = 1;
		int i = 0;
		boolean[] check = new boolean[100000];
		for (i = 0; i < A.length; i++) {
			if (A[i] >= 0) {
				check[A[i]] = true;
			}
		}

		for (i = 1; i < check.length; i++) {
			if (!check[i]) {
				ret = i;
				break;
			}
		}
		if (i == check.length) {
			ret = check.length;
		}
		return ret;
	}

}
