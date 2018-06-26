package ntech;

public class TestB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 알고리즘1
	public static boolean solution(int[] arr) {
		boolean answer = true;
		boolean[] check = new boolean[100001];
		int i, maxValue, cnt, arrLen;

		arrLen = arr.length;
		cnt = 0;
		maxValue = Integer.MIN_VALUE;
		for (i = 0; i < arrLen; i++) {
			if (check[arr[i]]) {
				answer = false;
				break;
			}
			check[arr[i]] = true;
			maxValue = Integer.max(maxValue, arr[i]);
			cnt++;
		}
		if (cnt < maxValue) {
			answer = false;
		}

		return answer;
	}

	// 알고리즘2: 펠린드롬
	public static int solution(String s) {
		int answer = 0;

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("Hello Java");

		return answer;
	}

}
