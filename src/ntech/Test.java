package ntech;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		Deque<Integer> deq = new LinkedList<>();
		char a = '4' - '2';
		int b = 4 - 2;
		// atoi
		// String[] sList = { "12345", "45600", "00243" };
		// for (String s : sList) {
		// System.out.println(atoi(s));
		// }
		// itoa
		// int[] iList = { 12345, 3435, 2455600 };
		// for (int i : iList) {
		// System.out.println(itoa(i));
		// }
//		fizzBuzz(100);
//		altFizzBuzz(15);

	}

	private static int atoi(String s) {
		int i, num, digit;
		digit = 1;
		num = 0;
		for (i = s.length() - 1; i >= 0; i--) {
			num += ((s.charAt(i) - '0') * digit);
			digit *= 10;
		}
		return num;
	}

	private static StringBuilder itoa(int i) {
		StringBuilder sb = new StringBuilder();
		int num = i;
		while (num > 0) {
			sb.insert(0, num % 10);
			num /= 10;
		}
		return sb;
	}

	private static void fizzBuzz(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				sb.append("FizzBuzz\n");
			} else if (i % 3 == 0) {
				sb.append("Fizz\n");
			} else if (i % 5 == 0) {
				sb.append("Buzz\n");
			} else {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}

	private static List<String> altFizzBuzz(int n) {
		final List<String> toReturn = new ArrayList<>(n);
		for (int i = 1; i <= n; i++) {
			String word = toWord(3, i, "Fizz") + toWord(5,i,"Buzz");
			if(word.equals("")) {
				toReturn.add(Integer.toString(i));
			} else {
				toReturn.add(word);
			}
		}
		return toReturn;
	}

	private static String toWord(int divisor, int value, String word) {
		return value % divisor == 0 ? word : "";
	}

}
