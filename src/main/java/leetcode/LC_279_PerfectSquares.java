package leetcode;

/**
 * related topic: Math, Dynamic Programming, Breadth-First Search
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class LC_279_PerfectSquares {
	public int numSquares(int n) {

		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;

			for (int j = 1; j * j <= i; j++) {
				dp[i] = Integer.min(dp[i], dp[i - j * j] + 1);
			}
		}

		return dp[n];
	}
}