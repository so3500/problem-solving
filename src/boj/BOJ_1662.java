/*
* 문제: 1662 압축
* link: https://www.acmicpc.net/problem/1662
* 알고리즘: 재귀호출
* 풀이방법:
*	( 괄호일 때 ( 괄호앞의 수를 재귀함수의 인수로 넘겨준다. 해당 수는 괄호안의 숫자 개수와 곱할 수
*	) 괄호일 때 이전 ( 괄호앞의 숫자와 () 괄호 내부의 숫자의 곱을 리턴
*	숫자일 때 전체 문자 수 +1
*   
* TC:
* 	input: 33(562(71(9)))
* 	output: 19
* 
* 	input: 4(2(25))
* 	output: 16
* 
* 	input: 33(562(72(922)3(2)))
* 	output: 67
* 
* 	input: 9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(111))))))))))))))))))))))))
* 	output: 8165106457226027331
*       
*/

package boj;

import java.util.Scanner;

public class BOJ_1662 {

	private static class StringSolution {

		private String input;
		private int inputLen;
		private int curIdx;

		public StringSolution() {
			this.input = "";
			this.inputLen = 0;
			this.curIdx = 0;
		}
		
		private void init() {
			Scanner sc = new Scanner(System.in);
			this.input = sc.nextLine();
			this.inputLen = this.input.length();

			sc.close();
		}

		private long solve(int mul) {
			long sum = 0;

			while (this.curIdx < inputLen) {
				if (input.charAt(this.curIdx) == '(') {
					sum--;
					this.curIdx++;
					sum += solve(getIntValue(input.charAt(this.curIdx - 2)));
				} else if (input.charAt(curIdx) == ')') {
					this.curIdx++;
					return sum * mul;
				} else {
					this.curIdx++;
					sum++;
				}
			}

			return sum;
		}

		private int getIntValue(int chr) {
			return (int) (chr - '0');
		}

	}

	public static void main(String[] args) {
		StringSolution strSol = new StringSolution();
		strSol.init();
		long ans = strSol.solve(1);
		System.out.println(ans);
	}

}
