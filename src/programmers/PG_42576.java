/*
* 문제: 42576 완주하지 못한 선수
* link: https://programmers.co.kr/learn/courses/30/lessons/42576
* 알고리즘: 해쉬
* 풀이방법:
*
*/

package programmers;

import java.util.HashMap;

public class PG_42576 {
	
	class Solution {
		public String solution(String[] participants, String[] completions) {
			HashMap<String, Integer> partMap = new HashMap<>();

			for (String participant : participants) {
				partMap.put(participant, partMap.getOrDefault(participant, 0) + 1);
			}

			for (String completion : completions) {
				partMap.put(completion, partMap.get(completion) - 1);
			}

			String answer = "";
			for(String key : partMap.keySet()) {
				if(partMap.get(key) > 0) {
					answer = key;
					break;
				}
			}
			
			return answer;
		}
	}
	
	public static void main(String[] args) {

	}
}
