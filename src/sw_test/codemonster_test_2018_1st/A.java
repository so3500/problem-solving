package sw_test.codemonster_test_2018_1st;

import java.util.Arrays;

class SolutionA {
	public int solution(int[] people, int[] tshirts) {
		int answer = 0;

		Arrays.sort(people);
		Arrays.sort(tshirts);

		int pIdx = 0;
		int tIdx = 0;
		int pLen = people.length;
		int tLen = tshirts.length;
		while (pIdx < pLen && tIdx < tLen) {
			if(people[pIdx] <= tshirts[tIdx]) {
				answer++;
				pIdx++;
				tIdx++;
			} else {
				tIdx++;
			}
		}

		return answer;
	}
}

public class A {

	public static void main(String[] args) {
		SolutionA solution = new SolutionA();
		int[] people = {2, 3};
		int[] tshirts = {1, 2, 3};
		int answer = solution.solution(people, tshirts);
		System.out.println(answer);
	}

}
