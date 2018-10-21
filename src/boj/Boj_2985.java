package boj;

import java.util.Scanner;

public class Boj_2985 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] num = new double[3];
		num[0] = sc.nextDouble();
		num[1] = sc.nextDouble();
		num[2] = sc.nextDouble();
		System.out.println(solve(num));
		sc.close();
	}

	private static String solve(double[] num) {
		String answer = "";
		if (num[0] + num[1] == num[2]) {
			answer = (int) num[0] + "+" + (int) num[1] + "=" + (int) num[2];
		} else if (num[0] - num[1] == num[2]) {
			answer = (int) num[0] + "-" + (int) num[1] + "=" + (int) num[2];
		} else if (num[0] * num[1] == num[2]) {
			answer = (int) num[0] + "*" + (int) num[1] + "=" + (int) num[2];
		} else if (num[0] / num[1] == num[2]) {
			answer = (int) num[0] + "/" + (int) num[1] + "=" + (int) num[2];
		}
		return answer;
	}
}
