package woowa2_2018_1;

import java.util.Scanner;

public class TestA {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

}
