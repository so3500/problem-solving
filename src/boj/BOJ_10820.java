/*
* 문제: 10820 문자열 분석
* problem-link: https://www.acmicpc.net/problem/10820
* solution-link:
*/
package boj;

import java.util.Scanner;

public class BOJ_10820 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			int upperCnt = 0;
			int lowerCnt = 0;
			int numCnt = 0;
			int blankCnt = 0;

			for (int idx = 0; idx < input.length(); idx++) {
				char chr = input.charAt(idx);
				if (chr >= 'a' && chr <= 'z') {
					lowerCnt++;
				} else if (chr >= '0' && chr <= '9') {
					numCnt++;
				} else if (chr >= 'A' && chr <= 'Z') {
					upperCnt++;
				} else if (chr == ' ') {
					blankCnt++;
				}
			}
			System.out.println(String.format("%d %d %d %d", lowerCnt, upperCnt, numCnt, blankCnt));
		}
		sc.close();
	}

}
