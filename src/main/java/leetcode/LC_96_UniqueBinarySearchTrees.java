package leetcode;

public class LC_96_UniqueBinarySearchTrees {

	/**
	 * related topic: Dynamic Programming
	 * Time Complexity: O(N^2)
	 * Space Complexity: O(N)
	 */
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int depth = 1; depth <= n; depth++) {
			for (int root = 1; root <= depth; root++) {
				dp[depth] += dp[root - 1] * dp[depth - root]; // leftSubTrees * rightSubTrees
			}
		}
		return dp[n];
	}
}