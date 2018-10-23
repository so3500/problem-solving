/*
* 문제: 1032 명령 프롬프트 
* problem-link: https://www.acmicpc.net/problem/1032
* solution-link: https://bibibim.tistory.com/9
*/

package boj;

import java.util.Scanner;

public class BOJ_1032 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();

		// 출력할 패턴을 첫번째로 입력하는 문자열로 초기화
		char[] pattern = sc.nextLine().toCharArray();

		// 다음부터 입력되는 문자열과 기존 문자열의 다른 부분을 '?'로 변경
		for (int pCnt = 1; pCnt < N; pCnt++) {
			char[] input = sc.nextLine().toCharArray();
			for (int idx = 0; idx < input.length; idx++) {
				if (pattern[idx] == '?') {
					continue;
				} else if (pattern[idx] != input[idx]) {
					pattern[idx] = '?';
				}
			}
		}
		System.out.println(pattern);
		sc.close();
	}
}
