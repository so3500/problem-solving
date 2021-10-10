package leetcode;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * related topic: Dynamic Programming
 * Time Complexity: O(MN)
 * Space Complexity: O(1)
 */
public class LC_64_MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				grid[row][col] = getMinimumPathSum(grid, row, col);
			}
		}

		return grid[m - 1][n - 1];
	}

	private int getMinimumPathSum(int[][] grid, int row, int col) {
		if (row == 0 && col == 0) {
			return grid[0][0];
		}

		int minPathSumFromUp = row > 0 ? grid[row - 1][col] : grid[0][col - 1];
		int minPathSumFromLeft = col > 0 ? grid[row][col - 1] : grid[row - 1][0];

		return grid[row][col] + Integer.min(minPathSumFromUp, minPathSumFromLeft);
	}
}