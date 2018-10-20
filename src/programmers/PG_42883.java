/*
* 문제: 42883 큰 수 만들기
* problem-link: https://programmers.co.kr/learn/courses/30/lessons/42883
* solution-link: 
* 
* stack.push(number[0])
* for idx 1 to number.length-1
* 	stdChr = number[idx];
* 	while
* 		stack에 있는 chr 중 stdChr보다 작은 chr은 삭제
* 	if k > 0
* 		stack에서 top에서 k개 만큼 삭제
* 
* stack에 있는 chr역순으로 출력
* 
*/

package programmers;

import java.util.Stack;

public class PG_42883 {

	static class Solution {

		Stack<Character> stack = new Stack<>();

		public String solution(String number, int k) {
			String answer = "";
			deleteKChar(number, k);
			answer = getMaxNumber();
			return answer;
		}

		private void deleteKChar(String number, int k) {
			stack.push(number.charAt(0));
			for (int idx = 1; idx < number.length(); idx++) {
				char stdChr = number.charAt(idx);
				while (!stack.isEmpty() && k > 0) {
					char preChr = stack.peek();
					if (preChr >= stdChr) {
						break;
					}
					if (preChr < stdChr) {
						stack.pop();
						k--;
					}
				}
				stack.push(stdChr);
			}
			while (k > 0) {
				stack.pop();
				k--;
			}
		}

		private String getMaxNumber() {
			StringBuilder number = new StringBuilder(stack.size());
			while (!stack.isEmpty()) {
				number.insert(0, stack.pop());
			}
			return number.toString();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("1924", 2)); // "94"
		System.out.println(solution.solution("1231234", 3)); // "3234"
		System.out.println(solution.solution("4177252841", 4)); // "775841"
	}

}
