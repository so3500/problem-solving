/*
* 문제: 1946 신입사원
* link: https://www.acmicpc.net/problem/1946
* 알고리즘: 그리디 알고리즘
* 풀이방법:
* 	rank[서류등수]: 면접등수
* 	동석차가 없으므로 init에서 서류 등수에 따라 정렬된 값을 저장할 수 있다.
* 	입력이 아래와 같을 경우
* 	3 2
* 	1 4
* 	4 1
* 	2 3
* 	5 5
* 
* 	rank에는 아래와 같이 저장
* 	서류등수(index)	면접등수(value)
* 	1				4
* 	2				3
* 	3				2
* 	4				1
* 	5				5
* 
* 	서류등수가 1인 사람은 면접등수가 4이므로
* 	다음 사람인 서류등수 2인 사람은 최소 면접등수가 4보다 낮아야 한다.
* 	
*/

package boj;

import java.util.Scanner;

public class BOJ_1946 {

	static class Solution {
		int[] rank;
		int N;

		public void solve() {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for (int tc = 0; tc < T; tc++) {
				init(sc);
				System.out.println(getMaxJunior());
			}
			sc.close();
		}

		private void init(Scanner sc) {
			N = sc.nextInt();
			rank = new int[N + 1];
			for (int idx = 0; idx < N; idx++) {
				int pRank = sc.nextInt();
				int iRank = sc.nextInt();
				rank[pRank] = iRank;
			}
		}

		private int getMaxJunior() {
			int jCnt = 1;
			int iRank = rank[1];
			for (int pRank = 2; pRank <= N; pRank++) {
				// 기준 면접 등수가 1등이 될 경우, 다음 서류 등수인 사람들은
				// 모두 기준 면접등수보다 낮으므로 break
				if(iRank == 1) {
					break;
				}
				if (rank[pRank] < iRank) {
					jCnt++;
					iRank = rank[pRank];
				}
			}
			return jCnt;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

}
