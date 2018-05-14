/*
* 문제: 1924 2007년 / 132 ms
* link: https://www.acmicpc.net/problem/1924
* 알고리즘: 구현
* 풀이방법:
* 	x월 y일이 주어질 때 x-1월까지의 모든 일 + y일을 구한다.
* 	요일은 반복되므로 구한 일수에 7 나머지 연산을 한다.
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
* 
* 공간복잡도(Space Complexity)
*
* */

package boj;

import java.util.Scanner;

public class Boj_1924 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, day;
		int[] D = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String ans = "";
		x = sc.nextInt();
		y = sc.nextInt();
		for (int i = 1; i <= 12; i++) {
			D[i] += D[i - 1];
		}
		day = D[x - 1] + y;
		day %= 7;
		if (day == 0) {
			ans = "SUN";
		} else if (day == 1) {
			ans = "MON";
		} else if (day == 2) {
			ans = "TUE";
		} else if (day == 3) {
			ans = "WED";
		} else if (day == 4) {
			ans = "THU";
		} else if (day == 5) {
			ans = "FRI";
		} else if (day == 6) {
			ans = "SAT";
		}
		System.out.println(ans);
		sc.close();
	}
	
}
