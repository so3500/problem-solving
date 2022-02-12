package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * related topic: Hash Table, String, Sliding Window
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LC_3_LongestSubStringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		int pointer = 0;
		char[] chars = s.toCharArray();
		int n = s.length();

		while (pointer < n) {
			char chr = chars[pointer];
			if (map.containsKey(chr)) {
				// 문자열 반복 시, 먼저 추가된 반복 문자 다음부터 다시 시작
				pointer = map.get(chr);
				map.clear();
			} else {
				// 문자열이 반복되지 않을 시, map 에 추가 및 최대 길이 갱신
				map.put(chr, pointer);
				maxLen = Integer.max(maxLen, map.size());
			}

			pointer++;
		}

		return maxLen;
	}
}