//package codejam._2020.round_1a.c;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Solution {
//
//	private static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//	private static Stack<Character> stack = new Stack<>();
//	private static StringBuilder sb = new StringBuilder();
//
//	public static void main(String[] args) {
//		int T = sc.nextInt();
//		for (int caseNum = 1; caseNum <= T; caseNum++) {
//			// init
//			String program = sc.next();
//			int index = program.length() - 1;
//			stack.clear();
//			int closeCnt = 0;
//			sb.setLength(0);
//
//			int W = 1;
//			int H = 1;
//
//			// solve
//			while (index >= 0) {
//				char p = program.charAt(index);
//
//				if (p == 'S' || p == 'E' || p == 'W' || p == 'N') {
//					stack.push(p);
//					index--;
//					continue;
//				}
//
//				if (p == ')') {
//					closeCnt++;
//					stack.push(p);
//					index--;
//					continue;
//				}
//
//				if (p == '(') {
//					int num = program.charAt(index - 1);
//					while (!stack.isEmpty() && stack.peek() != ')') {
//						sb.append(stack.pop());
//					}
//					stack.pop();
//
//					String repeatedPrograms = repeatString(sb, num);
//					for (char c : repeatedPrograms.toCharArray()) {
//						stack.push(c);
//					}
//
//					index -= 2;
//				}
//
//			}
//
//			// compute
//			while (!stack.empty()) {
//				char c = stack.pop();
//				if (c == 'W') {
//					W--;
//				} else if (c == 'E') {
//					W++;
//				} else if (c == 'N') {
//					H--;
//				} else if (c == 'S') {
//					H++;
//				}
//			}
//
//			if (W == 0) {
//				W--;
//			}
//			if (H == 0) {
//				H--;
//			}
//			W = (W + 1_000_000_000) % 1_000_000_001;
//			H = (H + 1_000_000_000) % 1_000_000_001;
//
//			// printAnswer
//			System.out.printf("Case #%d: %d %d\n", caseNum, W, H);
//		}
//		sc.close();
//
//	}
//
//	private static String repeatString(StringBuilder sb, int count) {
//		return String.valueOf(sb).repeat(Math.max(0, count));
//	}
//}
