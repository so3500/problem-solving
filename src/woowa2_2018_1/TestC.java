package woowa2_2018_1;

import java.util.Scanner;

public class TestC {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String ans;
		if (n % 4 == 0) {
			if (n % 100 == 0) {
				if (n % 400 == 0) {
					ans = "Leap Year";
				} else {
					ans = "Not Leap Year";
				}
			} else {
				ans = "Leap Year";
			}
		} else {
			ans = "Not Leap Year";
		}
		System.out.println(ans);
	}

}
