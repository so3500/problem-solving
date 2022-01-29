package leetcode;

/**
 * https://leetcode.com/problems/house-robber/
 *
 * related topic: Array, Dynamic Programming
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * dp[i]: i번째 집까지 왔을 떄 훔칠 수 있는 가장 큰 돈. 단 바로 앞 집은 (i-1) 은 방문하지 않아야 함
 * dp[i]: max(dp[i-1], dp[i-2] + nums[i])
 */
public class LC_198_HouseRobber {
	public int rob(int[] nums) {
		int n = nums.length;

		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Integer.max(nums[0], nums[1]);
		}

		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Integer.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			dp[i] = Integer.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[n - 1];
	}

	/*
	배열없이 값을 구할 순 없을까?

		public int rob(int[] nums) {
		int max1 = nums[0];
		if (nums.length == 1) {
			return max1;
		}
		int max2 = Integer.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			int max = Integer.max(max2 + nums[i], max1);

			max1 = max2;
			max2 = max;
		}

		return max2;
	}
	 */
}