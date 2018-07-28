package ntech;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = { 3, 2, 1, 2 };
		// solution1(arr);
		// String[] input = { "(){}{()}", "{[]}" };
		// for (String in : input) {
		// System.out.println(in + ": " + solution2(in));
		// }

		System.out.println(solution3("zothf", "otz", "hh")); // ht
		System.out.println(solution3("ab", "ba", "a")); // ba
		System.out.println(solution3("abcdefghijklmn", "nda", "ij"));// mif
	}

	// ============================================================================
	// 1번 문제
//	  1. grade list 입력 
//	  2. studentList 에 (grade, no) 추가 
//	  3. studentList 를 grade 기준으로 내림차순 정렬 - Comparator, 람다식 활용 
//	  4. studentList 의 index(0 to N-1) 까지 rank 부여 
//	  	4-1.동점자가 나올경우 동일한 등수를 부여. 단 동점자 수 카운팅 
//	  	4-2. 낮은점수가 나올경우 동점자 수를 고려한 다음 등수를 부여 
//	  5. studentList 에서 입력순서 기준으로 오름차순 정렬
	/* 
	 *  grade: 시험점수 no: 입력순서 rank: 등수
	 * Q. 위 알고리즘의 시간복잡도는? A. 3, 5 에서 O(nlogn), 2, 4 에서 O(n)
	 * 
	 * Q. ArraysList 대신 LinkedList를 사용한 이유는? A. list를 어떻게 구현할 것인가에 대해서는 주로 사용되는 연산이
	 * 어떤 연산인가에 따라 달려있다. 해당 알고리즘에서는 list에서 index에 따라 임의로 접근하는 random access 연산 보다는
	 * element 추가, 순차적 접근 연산이 주로 사용된다. 특히 element 추가에서 LinkedList는 O(1), ArraysList는
	 * O(n) 으로 성능이 갈리므로 전자가 적절하다고 볼 수 있다.
	 * 
	 * Q. LinkedList는 정렬을 어떻게 하나? A. array 에 복사한 다음 정렬하고 그 결과를 이용하려나? 정렬할때 random
	 * access가 일어날 것 같은데...
	 * 
	 */
	public static class Student {
		int grade, no, rank; // 시험점수, 입력순서, 등수

		public Student(int grade, int no) {
			this.grade = grade;
			this.no = no;
		}
	}

	public static int[] solution1(int[] grade) {
		int[] answer = {};
		List<Student> studentList = new LinkedList<>();
		int i, gradeListLen, rank, beforeGrade, cnt;

		gradeListLen = grade.length;
		for (i = 0; i < gradeListLen; i++) {
			studentList.add(new Student(grade[i], i + 1));
		}
		// java8 이후로는 LinkedList에서 자체적으로 sort 사용가능. java.util.List 의 method 사용
		studentList.sort((Student s1, Student s2) -> s2.grade - s1.grade); // 점수기준 내림차순 정렬
//		studentList.sort((s1, s2) -> {
//			return s2.grade - s1.grade;
//		});
		rank = 1;
		beforeGrade = studentList.get(0).grade;
		cnt = -1;
		for (Student s : studentList) {
			if (beforeGrade != s.grade) {
				rank++;
				rank += cnt;
				cnt = 0;
			} else {
				cnt++;
			}
			s.rank = rank;
			beforeGrade = s.grade;
		}

		studentList.sort((Student s1, Student s2) -> s1.no - s2.no); // 입력순서 기준 오름차순 정렬

		answer = new int[studentList.size()];
		i = 0;
		for (Student s : studentList) {
			answer[i] = s.rank;
			i++;
		}

		return answer;
	}

	// ============================================================================
	// 2번 문제
	// 1. 여는 괄호 (,{,[ 등장 시 
	//	1-1. stack에 저장
	//	1-2. 등급(rank) 값 설정, 소괄호 -> 대괄호 순으로 등급이 증가.
	// 2. 닫는 괄호 등장 시
	// 	2-1. 여는 괄호가 남아있는지 검사. 없다면 false
	//	2-2. 여는 괄호와 짝이 맞는지 검사. 없다면 false
	//	2-3. 짝이 맞다면 이전 괄호의 등급(rank) 값 확인. 다음에 여는 괄호 등장 시 사용
	// 3. 1, 2를 string이 끝날 때까지 반복
	// 4. 모든 과정이 끝난 뒤 스택이 비었는지 검사. 비어있지 않다면 짝이 안맞다는 뜻이므로 false
	public static boolean solution2(String input) {
		boolean answer = true;
		char[] result = input.toCharArray();
		int length = result.length;
		char ch;
		Stack<Character> stack = new Stack<>();

		int rank = 4;
		for (int i = 0; i < length; i++) {
			ch = result[i];
			if (ch == '(' || ch == '{' || ch == '[') {
				if (ch == '(' && rank > 1) {
					rank = 1;
				} else if (ch == '{' && rank > 2) {
					rank = 2;
				} else if (ch == '[' && rank > 3) {
					rank = 3;
				} else {
					return false;
				}
				stack.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				// 닫는 괄호는 있는데 여는 괄호가 없을 경우 ()) false
				if (stack.empty()) {
					return false;
				}
				char temp = stack.pop();
				char curr = ch;

				if (temp == '(' && curr == ')') {
					rank = getInfo(stack);
				} else if (temp == '{' && curr == '}') {
					rank = getInfo(stack);
				} else if (temp == '[' && curr == ']') {
					rank = getInfo(stack);
				} else {
					return false;
				}
			}
		}
		// 여는 괄호는 있는데 닫는 괄호가 없을 경우 (() false
		answer = stack.empty();
		return answer;
	}

	// getTopInfo: top 의 괄호 정보를 리턴하는 함수
	// 남아있는 괄호가 없다면 최상위 rank 4 부여(이 다음에 어떠한 괄호도 올 수 있다는 뜻)
	public static int getInfo(Stack<Character> stack) {
		int ret = 0;
		if (stack.isEmpty()) {
			ret = 4;
		} else {
			char ch = stack.peek();
			if (ch == '(') {
				ret = 1;
			} else if (ch == '{') {
				ret = 2;
			} else if (ch == '[') {
				ret = 3;
			}
		}
		return ret;
	}

	// ============================================================================
	// 3번 문제
	// rule 을 char배열로 변환
	// A, B 를 N진수로 변환
	// 변환한 N 진수를 10진수로 변환 A(10), B(10)
	// A(10) - B(10) = result(10)
	// result(10) -> result(N) 변환
	// rule char 배열을 참고하여 result(N) -> 문자열 변환
	// 결과값 리턴
	// xxxxxxxxxxxxxxxx

	// 아래
	// intTable: 각 소문자 알파벳이 몇번의 숫자를 할당받았는지 보여주는 테이블
	// charTable: 각 숫자에 따라 어떤 알파벳이 있는지 보여주는 테이블
//	1. rule 로부터 intTable, charTable 생성
//	2. intTable을 참고하여 A, B 를 N진수인 aNum, bNum 으로 변환
//	3. aNum - bNum 을 charTable을 참고하여 string으로 변환
	public static String solution3(String rule, String A, String B) {
		String answer = "";
		int[] intTable = new int[26];
		char[] charTable = new char[26];
		int N, i, idx, aNum, bNum;
		N = rule.length();

		for (i = 0; i < N; i++) {
			idx = (int) (rule.charAt(i) - 'a');
			intTable[idx] = i;
			charTable[i] = rule.charAt(i);
		}

		// digit: 1, 10, 100, ... 자릿수
		aNum = strToNNum(intTable, N, A); // A의 N진수
		bNum = strToNNum(intTable, N, B); // B의 N진수
		answer = nNumToStr(charTable, N, aNum - bNum); // (A의 N진수 - B의 N진수) to string
		return answer;
	}

	// 문자열 -> N진수
	private static int strToNNum(int[] intTable, int N, String s) {
		int num, idx, i, len, digit;
		len = s.length();
		num = 0;
		len = s.length();
		digit = 1;
		for (i = len - 1; i >= 0; i--) {
			idx = (int) s.charAt(i) - 'a';
			num += intTable[idx] * digit;
			digit *= N;
		}
		return num;
	}

	// N진수 -> 문자열
	private static String nNumToStr(char[] charTable, int N, int nNum) {
		StringBuilder sb = new StringBuilder();
		int idx, tempNNum;
		tempNNum = nNum;
		while (tempNNum > 0) {
			idx = tempNNum % N;
			sb.insert(0, charTable[idx]);
			tempNNum /= N;
		}
		return sb.toString();
	}

}
