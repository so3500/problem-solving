/*
* 문제: 2812 크게 만들기
* problem-link: https://www.acmicpc.net/problem/2812
* solution-link: 
* 
* 성능 개선 필요
*/

package boj;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_2812 {

	static class Solution {

		int N;
		int K;
		String number;
		Stack<Character> stack;

		public void solution() {
			init();
			deleteKnumber();
			String maxNumber = getMaxNumber();
			System.out.println(maxNumber);
		}

		private void init() {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			K = sc.nextInt();
			number= sc.next();
			stack = new Stack<>();
			sc.close();
		}

		private void deleteKnumber() {
			stack.push(number.charAt(0));
			for (int idx = 1; idx < number.length(); idx++) {
				char stdChr = number.charAt(idx);
				while (!stack.isEmpty() && K > 0) {
					char preChr = stack.peek();
					if (preChr >= stdChr) {
						break;
					}
					if (preChr < stdChr) {
						stack.pop();
						K--;
					}
				}
				stack.push(stdChr);
			}
			while (K > 0) {
				stack.pop();
				K--;
			}
		}

		private String getMaxNumber() {
			StringBuilder maxNumber = new StringBuilder();
			while (!stack.isEmpty()) {
				maxNumber.insert(0, stack.pop());
			}
			return maxNumber.toString();
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution();
	}

}
