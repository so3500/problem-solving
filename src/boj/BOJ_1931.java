/*
* 문제: 1931 회의실 배정
* link: https://www.acmicpc.net/problem/1931
* 알고리즘: 그리디 알고리즘
* 풀이방법:
* 	일반적인 방법으로 완전탐색 할 시 
* 		O(N^2)
* 	그리디 알고리즘 사용 시 
* 		정렬 O(NlogN) + 회의실 선택O(N) = O(NlogN)
* 		최대 사용할 수 있는 회의 수 = 가장 많이 선택하는 서로 겹치치 않는 회의 집합의 크기
* 
* 		1. 각 회의의 종료시간을 기준으로 오름차순 정렬한다.(종료시간이 같을 경우 시작시간 오름차순 정렬)
* 			반례) 2 
* 				 2 2
* 				 1 2
* 		2. 가장 먼저 끝나는 회의를 집합에 추가(마지막 종료 회의시간 갱신)
* 		3. 집합에 추가된 회의와 겹치는 회의는 집합에서 제외
* 		4. 2, 3을 반복
*
*/

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1931 {

	static class Solution {
		int N;
		Meeting[] meeting;

		class Meeting implements Comparable<Meeting> {
			int startTime;
			int endTime;

			public Meeting(int startTime, int endTime) {
				this.startTime = startTime;
				this.endTime = endTime;
			}

			@Override
			public int compareTo(Meeting o) {
				if (this.endTime == o.endTime) {
					return this.startTime - o.startTime;
				} else {
					return this.endTime - o.endTime;
				}
			}

		}

		public void solve() {
			init();
			System.out.println(getMaxMeetCnt());
		}

		private void init() {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			meeting = new Meeting[N];
			for (int idx = 0; idx < N; idx++) {
				int startTime = sc.nextInt();
				int endTime = sc.nextInt();
				meeting[idx] = new Meeting(startTime, endTime);
			}
			Arrays.sort(meeting);
			sc.close();
		}

		private int getMaxMeetCnt() {
			int meetCnt = 1;
			int lastEndTime = meeting[0].endTime;
			for (int idx = 1; idx < N; idx++) {
				if (meeting[idx].startTime >= lastEndTime) {
					lastEndTime = meeting[idx].endTime;
					meetCnt++;
				}
			}
			return meetCnt;
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

}
