package leetcode;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class LC_48_RotateImage {
	public void rotate(int[][] matrix) {
		rotateWithRecursive(matrix, matrix.length, 0, 0);
	}

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
	 * Memory Usage: 39.1 MB, less than 66.86% of Java online submissions for Rotate Image.
	 *
	 * @param matrix 2D matrix
	 * @param matrixLen length of sub matrix
	 * @param startRow start row of sub matrix
	 * @param startCol start column of sub matrix
	 */
	public void rotateWithRecursive(int[][] matrix, int matrixLen, int startRow, int startCol) {
		if (matrixLen < 2) {
			return;
		}

		int rotateCount = matrixLen - 1;

		// start from left top
		int m1Row = startRow;
		int m1Col = startCol;

		// start from left bottom
		int m2Row = matrix.length - 1 - startRow;
		int m2Col = startCol;

		// start from right bottom
		int m3Row = matrix.length - 1 - startRow;
		int m3Col = matrix.length - 1 - startCol;

		// start from right top
		int m4Row = startRow;
		int m4Col = matrix.length - 1 - startCol;

		while (rotateCount-- > 0) {
			int m1ValueTemp = matrix[m1Row][m1Col];
			matrix[m1Row][m1Col] = matrix[m2Row][m2Col];
			matrix[m2Row][m2Col] = matrix[m3Row][m3Col];
			matrix[m3Row][m3Col] = matrix[m4Row][m4Col];
			matrix[m4Row][m4Col] = m1ValueTemp;

			m1Col++;
			m2Row--;
			m3Col--;
			m4Row++;
		}

		rotateWithRecursive(matrix, matrixLen - 2, startRow + 1, startCol + 1);
	}
}