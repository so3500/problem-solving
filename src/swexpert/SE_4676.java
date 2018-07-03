// 늘어지는 소리 만들기

package swexpert;

import java.util.Scanner;

public class SE_4676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, t, H, inputIdx, i;
		int[] cnt;
		StringBuilder sb;
		String input;
		T = sc.nextInt();
		for (t = 1; t <= T; t++) {
			input = sc.next();
			cnt = new int[input.length() + 1];
			sb = new StringBuilder(input);
			H = sc.nextInt();
			
			// 하이픈 '-'이 들어갈 위치를 미리 구하기
			for (i = 0; i < H; i++) {
				inputIdx = sc.nextInt();
				cnt[inputIdx]++;
			}
			// 하이픈이 들어갈 위치대로 하이픈 추가(뒤에서부터 하이픈 추가 시 변경되는 인덱스를 고려할 필요가 없다)
			for (i = input.length(); i >= 0; i--) {
				while (cnt[i] > 0) {
					cnt[i]--;
					sb.insert(i, '-');
				}
			}
			System.out.println("#" + t + " " + sb.toString());
		}
		sc.close();
	}

}
