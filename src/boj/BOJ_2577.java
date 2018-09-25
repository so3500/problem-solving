/*
* 문제: 2577 숫자의 개수 
* link: https://www.acmicpc.net/problem/2577
* 알고리즘: 구현 
*
* */

package boj;

import java.util.Scanner;

public class BOJ_2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int result = A * B * C;
		int[] numCnt = new int[10];
		while (result > 0) {
			int digit = result % 10;
			numCnt[digit]++;
			result /= 10;
		}

		StringBuilder sb = new StringBuilder(10);
		for (int num : numCnt) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

}
