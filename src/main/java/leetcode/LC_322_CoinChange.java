package leetcode;

/**
 * https://leetcode.com/problems/coin-change/
 * related topic: Array, Dynamic Programming, Breadth-First Search
 *
 * dp[i]: minimum number of coins for i
 * A: amount, C: coins
 * Time Complexity: O(A*C)
 * Space Complexity: O(A)
 */
public class LC_322_CoinChange {
	private final int MAX_VALUE = 10_000 + 1;

	public int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}

		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			dp[i] = getMinNumOfCoin(coins, dp, i);
		}

		return dp[amount] != MAX_VALUE ? dp[amount] : -1;
	}

	private int getMinNumOfCoin(int[] coins, int[] dp, int amount) {
		int minNumOfCoin = MAX_VALUE;
		for (int coin : coins) {
			if (amount - coin >= 0) {
				minNumOfCoin = Integer.min(minNumOfCoin, dp[amount - coin] + 1);
			}
		}
		return minNumOfCoin;
	}
}