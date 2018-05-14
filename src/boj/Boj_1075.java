/*
* 문제: 1075 나누기 / 120 ms
* link: https://www.acmicpc.net/problem/1075
* 알고리즘: 수학
* 풀이방법:
* 	N의 마지막 두 자리를 00으로 변경
* 	F로 나누어 질때까지 N의 마지막 두자리가 00 에서 99 까지 1씩 더함
* 	나누어 떨어질 때 x값을 두자리의 문자열로 변환후 출력
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

public class Boj_1075 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, F, x;
		String ans;
		N = sc.nextInt();
		F = sc.nextInt();
		x = N % 100;
		N -= x;
		while (N % F != 0) {
			N++;
		}
		x = N % 100;
		if (x < 10) {
			ans = "0" + x;
		} else {
			ans = Integer.toString(x);
		}
		System.out.println(ans);
		sc.close();
	}

}
