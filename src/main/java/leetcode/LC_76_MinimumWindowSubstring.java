package leetcode;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * related topic: Hash Table, String, Sliding Window
 * Time Complexity: O(M+N)
 * Space Complexity: O(M+N)
 */
public class LC_76_MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		int[] tMap = initMap(tArray);

		int wLeft = 0;
		int wRight = 0;
		int lo = 0;
		int hi = 0;
		int needCount = tArray.length;
		int minLen = Integer.MAX_VALUE;

		while (hi < sArray.length) {
			char c = sArray[hi];
			if (tMap[c] >= 1) {
				needCount--;
			}
			tMap[c]--;
			hi++;

			while (needCount == 0) {
				if (hi - lo < minLen) {
					minLen = hi - lo;
					wLeft = lo;
					wRight = hi;
				}
				char prev = sArray[lo++];
				if (tMap[prev]++ >= 0) {
					needCount++;
				}
			}
		}

		return s.substring(wLeft, wRight);
	}

	private int[] initMap(char[] tArray) {
		int[] tMap = new int[256];
		for (char c : tArray) {
			tMap[c]++;
		}
		return tMap;
	}
}