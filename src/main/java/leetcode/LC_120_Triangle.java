package leetcode;

import java.util.List;

/**
 * related topic: Array, Dynamic Programming
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * N : total number of elements
 */
public class LC_120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}

		int n = triangle.size();
		int[][] dp = new int[n][n];
		dp[0][0] = triangle.get(0).get(0);

		int minPathSum = Integer.MAX_VALUE;
		for (int r = 1; r < n; r++) {
			List<Integer> t = triangle.get(r);
			int c = 0;
			for (int num : t) {
				if (c == 0) {
					dp[r][c] = num + dp[r - 1][c];
				} else if (c == t.size() - 1) {
					dp[r][c] = num + dp[r - 1][c - 1];
				} else {
					dp[r][c] = num + Integer.min(dp[r - 1][c - 1], dp[r - 1][c]);
				}

				if (r == n - 1) {
					minPathSum = Integer.min(minPathSum, dp[r][c]);
				}

				c++;
			}
		}

		return minPathSum;
	}
}