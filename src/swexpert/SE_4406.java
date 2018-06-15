package swexpert;

import java.util.Scanner;

public class SE_4406 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, t, i, wordLen;
		char c;
		String word;
		StringBuilder sb;
		T = sc.nextInt();
		for (t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			word = sc.next();
			wordLen = word.length();
			for (i = 0; i < wordLen; i++) {
				c = word.charAt(i);
				if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
					sb.append(c);
				}
			}
			System.out.println(sb);
		}
		sc.close();
	}

}
