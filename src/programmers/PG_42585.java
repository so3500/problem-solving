/*
* 문제: 42585 쇠막대기
* problem-link: https://programmers.co.kr/learn/courses/30/lessons/42585
* solution-link:
* 
* 1. '(' 일 경우
* 	stack에 push
* 	바로 다음에 ')'가 올 경우 레이저가 되므로 isStick 플래그 false
* 
* 2. ')' && isStick
* 	쇠막대기가 끝나므로 +1
* 	stack에서 pop
* 
* 3. ')'
* 	레이저이므로 stack의 size만큼 더하기
* 	stack에서 pop
* 	바로 다음에 ')'가 올 경우 쇠막대기가 되므로 isStick 플래그 true
*/

package programmers;

import java.util.Stack;

public class PG_42585 {

	static class Solution {

		public int solution(String arrangement) {
			int answer = 0;
			Stack<Character> stick = new Stack<>();
			boolean isStick = false;
			for (int idx = 0; idx < arrangement.length(); idx++) {
				char chr = arrangement.charAt(idx);
				if (chr == '(') {
					stick.push('(');
					isStick = false;
				} else if (chr == ')' && isStick) {
					answer++;
					stick.pop();
				} else if (chr == ')') {
					stick.pop();
					answer += stick.size();
					isStick = true;
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("()(((()())(())()))(())")); // 17
		System.out.println(solution.solution("(((()(()()))(())()))(()())")); // 24
	}

}
