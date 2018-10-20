/*
* 문제: 43104 타일 장식물
* problem-link: https://programmers.co.kr/learn/courses/30/lessons/43104
* solution-link: 
*/

package programmers;

public class PG_43104 {

	static class Solution {

		long[] sideLen;

		public long solution(int N) {
			initSideLen(N);
			long answer = 0;
			if (N >= 4) {
				answer = 3 * sideLen[N] + 2 * sideLen[N - 1] + 2 * sideLen[N - 2] + sideLen[N - 3];
			} else {
				answer = 3 * sideLen[N] + 4 * sideLen[N - 1];
			}
			return answer;
		}

		private void initSideLen(int N) {
			sideLen = new long[N + 1];
			sideLen[1] = 1;
			sideLen[2] = 1;
			sideLen[3] = 2;
			for (int idx = 4; idx <= N; idx++) {
				sideLen[idx] = sideLen[idx - 1] + sideLen[idx - 2];
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(5); // return 26
		solution.solution(6); // return 42
	}

}
