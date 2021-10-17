package leetcode;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class LC_62_UniquePaths {
	public int uniquePaths(int m, int n) {
		return uniquePathsWithDP(m, n);
	}

	/**
	 * related topic: Dynamic Programming
	 * Time Complexity: O(MN)
	 * Space Complexity: O(MN)
	 */
	public int uniquePathsWithDP(int m, int n) {
		int[][] dp = new int[m][n];

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				dp[row][col] = getUniquePaths(dp, row, col);
			}
		}

		return dp[m - 1][n - 1];
	}

	private int getUniquePaths(int[][] dp, int row, int col) {
		if (row == 0 || col == 0) {
			return 1;
		}

		return dp[row - 1][col] + dp[row][col - 1];
	}

	/**
	 * Combinatorics
	 * Time Complexity: O(?)
	 * Space Complexity: O(1)
	 */
	public int uniquePathsWithCombinatorics(int m, int n) {
		return 0; // TODO
	}
}