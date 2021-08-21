package leetcode;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class LC_647_PalindromicSubstrings {

	public int countSubstrings(String s) {
		return countSubstringsWithArray(s);
	}

	private int countSubstringWithExtend(String s) {
		// TODO
		return 0;
	}

	/**
	 * Runtime: 8 ms, faster than 51.29% of Java online submissions for Palindromic Substrings.
	 * Memory Usage: 39.4 MB, less than 25.06% of Java online submissions for Palindromic Substrings.
	 */
	private int countSubstringsWithArray(String s) {
		boolean[][] isPalindrom = new boolean[s.length()][s.length()];
		int palindromCnt = 0;

		// 1
		for (int i = 0; i < s.length(); i++) {
			isPalindrom[i][i] = true;
			palindromCnt++;
		}

		// 2
		for (int startIndex = 0; startIndex < s.length() - 1; startIndex++) {
			int endIndex = startIndex + 1;
			if (s.charAt(startIndex) == s.charAt(endIndex)) {
				isPalindrom[startIndex][endIndex] = true;
				palindromCnt++;
			}
		}

		// 3 ~ n
		for (int subsetLength = 3; subsetLength <= s.length(); subsetLength++) {
			int startIndex = 0;
			int endIndex = subsetLength - 1;

			while (endIndex < s.length()) {
				if (isPalindrom[startIndex + 1][endIndex - 1] && s.charAt(startIndex) == s.charAt(endIndex)) {
					isPalindrom[startIndex][endIndex] = true;
					palindromCnt++;
				}
				startIndex++;
				endIndex++;
			}
		}

		return palindromCnt;
	}
}