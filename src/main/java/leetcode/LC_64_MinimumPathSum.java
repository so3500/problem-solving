package leetcode;

/**
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
		int minPathSum = grid[row][col];

		if (row == 0 && col == 0) {
			// nothing
		} else if (row == 0) {
			minPathSum += grid[0][col - 1];
		} else if (col == 0) {
			minPathSum += grid[row - 1][0];
		} else {
			minPathSum += Integer.min(grid[row - 1][col], grid[row][col - 1]);
		}

		return minPathSum;
	}
}