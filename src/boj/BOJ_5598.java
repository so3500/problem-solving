/*
* 문제: 5598 카이사르 암호 
* link: https://www.acmicpc.net/problem/5598
* 알고리즘: 수학, 정수론
* 풀이방법:
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
*
* */

package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_5598 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String plainStr = sc.next();
		sc.close();

		Map<Character, Character> table = getTable();

		StringBuilder builder = new StringBuilder(plainStr);
		for (int idx = 0, len = builder.length(); idx < len; idx++) {
			char plainChr = builder.charAt(idx);
			builder.setCharAt(idx, table.get(plainChr));
		}

		System.out.println(builder.toString());
	}

	private static Map<Character, Character> getTable() {
		Map<Character, Character> table = new HashMap<>();
		char plainChr = 'A';
		char cyperChr = 'D';
		for (int i = 0; i < 26; i++) {
			table.put(cyperChr, plainChr);
			plainChr++;
			cyperChr++;
			if (cyperChr > 'Z') {
				cyperChr = 'A';
			}
		}
		return table;
	}

}
