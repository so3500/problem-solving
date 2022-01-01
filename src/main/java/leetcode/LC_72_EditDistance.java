package leetcode;

import java.util.Arrays;

/**
 * related topic: String, Dynamic Programming
 * Time Complexity: O()
 * Space Complexity: O(NM)
 */
public class LC_72_EditDistance {
	public int minDistance(String word1, String word2) {
		return findByRecursion(word1, word2);
	}

	/**
	 * dp[i][j] : word1 i 번째 글자에서 word2 j 번째 글자까지 변환 시 최소 연산 수
	 */
	private int findByRecursion(String word1, String word2) {
		if (word1.isEmpty()) {
			return word2.length();
		}
		if (word2.isEmpty()) {
			return word1.length();
		}

		int[][] dp = initDP(word1, word2);
		return recursion(word1, 0, word2, 0, dp);
	}

	private int recursion(String from, int fromIdx, String to, int toIdx, int[][] dp) {
		if (from.length() == fromIdx) {
			return to.length() - toIdx;
		}
		if (to.length() == toIdx) {
			return from.length() - fromIdx;
		}
		if (dp[fromIdx][toIdx] != -1) {
			return dp[fromIdx][toIdx];
		}

		if (from.charAt(fromIdx) == to.charAt(toIdx)) {
			dp[fromIdx][toIdx] = recursion(from, fromIdx + 1, to, toIdx + 1, dp);
		} else {
			int insert = recursion(from, fromIdx, to, toIdx + 1, dp);
			int delete = recursion(from, fromIdx + 1, to, toIdx, dp);
			int replace = recursion(from, fromIdx + 1, to, toIdx + 1, dp);

			dp[fromIdx][toIdx] = Integer.min(insert, Integer.min(delete, replace)) + 1;
		}
		return dp[fromIdx][toIdx];
	}

	private int[][] initDP(String word1, String word2) {
		int[][] dp = new int[word1.length()][word2.length()];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		return dp;
	}

	// todo without recursion (bottom-up)
}