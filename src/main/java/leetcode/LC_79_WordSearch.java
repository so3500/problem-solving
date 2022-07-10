package leetcode;

/**
 * https://leetcode.com/problems/word-search/
 * related topic: Array, Backtracking, Matrix
 * Time Complexity:
 * Space Complexity:
 */
public class LC_79_WordSearch {

	private boolean[][] visited;
	private boolean searched;
	private final int[][] DIRECTIONS = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

	public boolean exist(char[][] board, String word) {
		visited = new boolean[board.length][board[0].length];
		searched = false;

		search(board, word);

		return searched;
	}

	private void search(char[][] board, String word) {
		char[] wordChars = word.toCharArray();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == wordChars[0] && !searched) {
					dfs(board, wordChars, 1, row, col);
				}
			}
		}
	}

	private void dfs(char[][] board, char[] wordChars, int searchLength, int row, int col) {
		if (searchLength == wordChars.length) {
			searched = true;
			return;
		}

		visited[row][col] = true;

		for (int[] direction : DIRECTIONS) {
			int nextRow = row + direction[0];
			int nextCol = col + direction[1];

			if (enableVisit(board, wordChars, searchLength, nextRow, nextCol)) {
				dfs(board, wordChars, searchLength + 1, nextRow, nextCol);
			}
		}

		visited[row][col] = false;
	}

	private boolean enableVisit(char[][] board, char[] wordChars, int searchLength, int nextRow, int nextCol) {
		return valid(board, nextRow, nextCol)
			&& !visited[nextRow][nextCol]
			&& wordChars[searchLength] == board[nextRow][nextCol];
	}

	private boolean valid(char[][] board, int nextRow, int nextCol) {
		return nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[nextRow].length;
	}

}