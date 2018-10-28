/*
* 문제: 6378 디지털 루트
* problem-link: https://www.acmicpc.net/problem/6378
* solution-link:
*/

package boj;

import java.util.Scanner;

public class BOJ_6378 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String inputStr = sc.nextLine();
			int num = strToNum(inputStr);
			if (num == 0) {
				break;
			}
			int digiRoot = getDigiRoot(num);
			System.out.println(digiRoot);
		}
		sc.close();
	}

	private static int getDigiRoot(int input) {
		int num = input;
		while (num >= 10) {
			num = getDigitSum(num);
		}
		return num;
	}

	private static int strToNum(String input) {
		int ret = 0;
		for (int idx = 0; idx < input.length(); idx++) {
			ret += (input.charAt(idx) - '0');
		}
		return ret;
	}

	private static int getDigitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += (num % 10);
			num /= 10;
		}
		return sum;
	}
}
