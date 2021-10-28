package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * related topic:
 * Time Complexity:
 * Space Complexity:
 *
 * https://leetcode.com/problems/decode-string/
 */
public class LC_394_DecodeString {

	public String decodeString(String s) {
		StringBuilder sb = new StringBuilder();

		Deque<Integer> numStack = new LinkedList<>();
		Deque<String> strStack = new LinkedList<>();
		String[] sArray = s.split("");

		for (String str : sArray) {
			if ("[".equals(str)) {
				findNumberStrAndPushToNumberStack(numStack, strStack);
				strStack.addLast(str);
			} else if ("]".equals(str)) {
				multiplyString(numStack, strStack);
			} else {
				strStack.addLast(str);
			}
		}

		// 결과물을 리턴값에 추가
		while (!strStack.isEmpty()) {
			sb.append(strStack.removeFirst());
		}

		return sb.toString();
	}

	private static void findNumberStrAndPushToNumberStack(Deque<Integer> numStack, Deque<String> strStack) {
		StringBuilder tempNum = new StringBuilder();

		while (isNumber(strStack.peekLast())) {
			tempNum.append(strStack.removeLast());
		}

		String numberStr = tempNum.reverse().toString(); // 001 -> 100

		numStack.addLast(Integer.parseInt(numberStr));
	}

	private static void multiplyString(Deque<Integer> numStack, Deque<String> strStack) {
		// "[" 이 나올 때 까지 꺼내기
		Deque<String> temp = new LinkedList<>();
		while (!"[".equals(strStack.peekLast())) {
			temp.add(strStack.removeLast());
		}
		strStack.removeLast(); // draw "["

		// 숫자 스택에 있는 수 만큼 문자열 반복
		int repeatNum = numStack.removeLast();
		String repeatedStr = repeat(convertToString(temp), repeatNum);

		// 결과 문자열을 스택에 추가
		strStack.addLast(repeatedStr);
	}

	private static String convertToString(Deque<String> temp) {
		StringBuilder sb = new StringBuilder(temp.size());

		while (!temp.isEmpty()) {
			sb.append(temp.removeLast());
		}

		return sb.toString();
	}

	private static String repeat(String s, int count) {
		StringBuilder temp = new StringBuilder(s.length() * count);
		for (int i = 0; i < count; i++) {
			temp.append(s);
		}

		return temp.toString();
	}

	private static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}