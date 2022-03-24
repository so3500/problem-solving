package leetcode;

/**
 * related topic: Array, Dynamic Programming Matrix
 * Time Complexity: O(MN)
 * Space Complexity: O(MN)
 */
public class LC_221_MaximalSquare {
	private int n;
	private int m;
	private int[][] squareLength; // save length of square

	public int maximalSquare(char[][] matrix) {
		init(matrix);

		int maxSquare = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (matrix[r][c] == '1') {
					squareLength[r][c] = calculateMaximalSquare(r, c);
					maxSquare = Integer.max(maxSquare, squareLength[r][c] * squareLength[r][c]);
				}
			}
		}

		return maxSquare;
	}

	private void init(char[][] matrix) {
		n = matrix.length;
		m = matrix[0].length;
		squareLength = new int[n][m];
	}

	private int calculateMaximalSquare(int r, int c) {
		int fromLeft = calculateSquare(r, c - 1);
		int fromUp = calculateSquare(r - 1, c);
		int fromLeftUp = calculateSquare(r - 1, c - 1);

		return Integer.min(fromLeft, Integer.min(fromUp, fromLeftUp)) + 1;
	}

	private int calculateSquare(int r, int c) {
		if (r < 0 || r >= n || c < 0 || c >= m) {
			return 0;
		}
		return squareLength[r][c];
	}
}