package woowa_2018_1;

import java.util.Stack;

public class A {

	public static void main(String[] args) {
		String input = "13 DUP 4 POP 5 DUP + DUP + -";
		System.out.println(solution(input));
	}

	public static int solution(String S) {
		int i, ret;
		boolean valid = true;
		long value, numA, numB;
		String[] input = S.split(" ");
		ret = -1;
		Stack<Long> stack = new Stack<>();
		for (i = 0; i < input.length && valid; i++) {
			if (isStringLong(input[i])) {
				stack.push(Long.parseLong(input[i]));
			} else {
				switch (input[i]) {
				case "DUP":
					if (stack.isEmpty()) {
						ret = -1;
						valid = false;
					}
					stack.add(stack.peek());
					break;
				case "POP":
					if (stack.isEmpty()) {
						ret = -1;
						valid = false;
					}
					stack.pop();
					break;
				case "+":
					if (stack.size() < 2) {
						ret = -1;
						valid = false;
						break;
					}
					value = stack.pop() + stack.pop();
					// if overflow
					if (value > ((long) Math.pow(2, 20)) - 1) {
						ret = -1;
						valid = false;
					} else {
						stack.push(value);
					}
					break;
				case "-":
					if (stack.size() < 2) {
						ret = -1;
						valid = false;
						break;
					}
					numA = stack.pop();
					numB = stack.pop();
					// if underflow
					if (numA < numB) {
						ret = -1;
						valid = false;
					} else {
						stack.push(numA - numB);
					}
					break;
				}
			}
		}

		if (valid && !stack.isEmpty()) {
			ret = stack.pop().intValue();
		}

		return ret;

	}

	public static boolean isStringLong(String s) {
		try {
			Long.parseLong(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
