package leetcode;

/**
 * related topic: Math, Dynamic Programming, Breadth-First Search
 * Time Complexity: O()
 * Space Complexity: O()
 *
 * dp[n]: n 을 만드는 제곱수의 최소개수
 * dp[0] = 0
 * dp[1] = 1
 * dp[2] = dp[1] + 1 = 2
 * dp[3] = dp[2] + 1 = 3
 * dp[4] = min(dp[4-1]+1, dp[4-4]+1) = 1 (4)
 * dp[12] = min(dp[12-1]+1, dp[12-4]+1, dp[12-9]+1) = 3 (4+4+4)
 * dp[17] = min(dp[17-1]+1, dp[17-4]+1, dp[17-9]+1, dp[17-16]+1) = 2 (1+16)
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