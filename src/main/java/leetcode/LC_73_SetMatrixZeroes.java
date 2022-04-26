package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * related topic: Array, Hash Table, Matrix
 * Time Complexity: O(NM)
 * Space Complexity: O(1)
 */
public class LC_73_SetMatrixZeroes {
	private boolean isColsSetZeros = false;
	private boolean isRowsSetZeros = false;

	public void setZeroes(int[][] matrix) {
		initMatrixWithSettingFirstElementZero(matrix);
		setMatrixZeros(matrix);
		setFirstRowsWithZero(matrix);
		setFirstColsWithZero(matrix);
	}

	private void initMatrixWithSettingFirstElementZero(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				if (matrix[r][c] == 0) {
					matrix[0][c] = 0;
					matrix[r][0] = 0;

					if (r == 0) {
						isRowsSetZeros = true;
					}
					if (c == 0) {
						isColsSetZeros = true;
					}
				}
			}
		}
	}

	private void setMatrixZeros(int[][] matrix) {
		for (int r = 1; r < matrix.length; r++) {
			for (int c = 1; c < matrix[r].length; c++) {
				if (matrix[r][0] == 0 || matrix[0][c] == 0) {
					matrix[r][c] = 0;
				}
			}
		}
	}

	// left to right
	private void setFirstRowsWithZero(int[][] matrix) {
		if (isRowsSetZeros) {
			Arrays.fill(matrix[0], 0);
		}
	}

	// top to bottom
	private void setFirstColsWithZero(int[][] matrix) {
		if (isColsSetZeros) {
			for (int r = 0; r < matrix.length; r++) {
				matrix[r][0] = 0;
			}
		}
	}
}