/*
* 문제: 1918 후위표기식 
* problem-link: https://www.acmicpc.net/problem/1918
* solution-link: https://bibibim.tistory.com/10
*/

package boj;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1918 {

	private static Stack<Character> optStack = new Stack<>();
	private static StringBuilder postOrderExp = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inOrderExp = sc.next();
		System.out.println(inOrderToPostOrder(inOrderExp));
//		operateExp(inOrderToPostOrder(inOrderExp)); // 변환된 후위표기식을 기반으로 계산
		sc.close();
	}

	private static String inOrderToPostOrder(String inOrderExp) {
		for (int idx = 0; idx < inOrderExp.length(); idx++) {
			char chr = inOrderExp.charAt(idx);
			if (isOpt(chr)) {
				processOperator(chr);
			} else {
				processOperand(chr);
			}
		}
		addRemainOptToInOrderExp();

		return postOrderExp.toString();
	}

	private static void processOperator(char operator) {
		if (operator == '(') {
			optStack.push(operator);
		} else if (operator == ')') {
			char opt = optStack.pop();
			while (opt != '(') {
				postOrderExp.append(opt);
				opt = optStack.pop();
			}
		} else {
			while (!optStack.isEmpty() && compareOpt(optStack.peek(), operator)) {
				postOrderExp.append(optStack.pop());
			}
			optStack.push(operator);
		}
	}

	private static void processOperand(char operand) {
		postOrderExp.append(operand);
	}

	private static boolean isOpt(char chr) {
		boolean ret = false;
		switch (chr) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '(':
		case ')':
			ret = true;
			break;
		}
		return ret;
	}

	private static boolean compareOpt(char opt1, char opt2) {
		int priority1 = getPriority(opt1);
		int priority2 = getPriority(opt2);
		boolean ret = false;
		if (priority1 >= priority2) {
			ret = true;
		}
		return ret;
	}

	private static int getPriority(char opt) {
		int priority = 0;
		switch (opt) {
		case '+':
		case '-':
			priority = 1;
			break;
		case '*':
		case '/':
			priority = 2;
			break;
		}
		return priority;
	}

	private static void addRemainOptToInOrderExp() {
		while (!optStack.isEmpty()) {
			postOrderExp.append(optStack.pop());
		}
	}

	// test for (5*4*3/4-5)+3*3 = 19
	private static void operateExp(String postOrderExp) {
		Stack<Integer> numStack = new Stack<>();
		for (int idx = 0; idx < postOrderExp.length(); idx++) {
			char chr = postOrderExp.charAt(idx);
			if (isOpt(chr)) {
				int num1 = numStack.pop();
				int num2 = numStack.pop();
				int result = operation(num2, num1, chr);
				numStack.push(result);
			} else {
				int num = chr - '0';
				numStack.push(num);
			}
		}
		int result = numStack.pop();
		System.out.println(result);
	}

	private static int operation(int d1, int d2, char opt) {
		int result = 0;
		switch (opt) {
		case '+':
			result = d1 + d2;
			break;
		case '-':
			result = d1 - d2;
			break;
		case '*':
			result = d1 * d2;
			break;
		case '/':
			result = d1 / d2;
			break;
		}
		return result;
	}

}
