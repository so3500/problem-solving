package leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * related topic: String, Dynamic Programming
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 */
public class LC_5_LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.length() == 1) {
			return s;
		}

		int start = 0;
		int end = 0;
		int n = s.length();
		boolean[][] palindrome = new boolean[n][n];
		int maxLen = 0;

		// for length 1
		for (int left = 0; left < n; left++) {
			palindrome[left][left] = true;
		}
		// for length 2
		for (int left = 0; left < n - 1; left++) {
			int right = left + 1;

			if (s.charAt(left) == s.charAt(right)) {
				palindrome[left][right] = true;
				start = left;
				end = right;
			}
		}
		// for length from 3 to n
		for (int mid = 1; mid < n; mid++) {
			for (int left = 0; left < n - mid - 1; left++) {
				int right = left + mid + 1;
				if (s.charAt(left) == s.charAt(right) && palindrome[left + 1][right - 1]) {
					palindrome[left][right] = true;
					if (maxLen < right - left + 1) {
						maxLen = right - left + 1;
						start = left;
						end = right;
					}
				}
			}
		}

		return s.substring(start, end + 1);
	}
}