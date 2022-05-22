package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning
 * related topic: String, Dynamic Programming, Backtracking
 * Time Complexity: O(N*2^N)
 * Space Complexity: O(N)
 */
public class LC_131_PalindromePartitioning {
	private List<List<String>> ret;

	public List<List<String>> partition(String s) {
		ret = new ArrayList<>();
		dfs(new ArrayList<>(), s, 0);
		return ret;
	}

	void dfs(List<String> palindrome, String s, int start) {
		if (start >= s.length()) {
			ret.add(new ArrayList<>(palindrome));
		}

		for (int end = start; end < s.length(); end++) {
			if (isPalindrome(s, start, end)) {
				palindrome.add(s.substring(start, end + 1));
				dfs(palindrome, s, end+1);
				palindrome.remove(palindrome.size() - 1);
			}
		}
	}

	boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}