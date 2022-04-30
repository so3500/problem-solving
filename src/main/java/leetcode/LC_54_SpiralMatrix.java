package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * related topic: Array, Matrix, Simulation
 *
 * M : matrix.length
 * N : matrix[i].length
 * Time Complexity: O(NM)
 * Space Complexity: O(NM)
 */
public class LC_54_SpiralMatrix {
	private List<Integer> order;
	private boolean[][] visited;

	public List<Integer> spiralOrder(int[][] matrix) {
		order = new LinkedList<>();
		visited = new boolean[matrix.length][matrix[0].length];

		visit(matrix, 0, 0, Direction.LEFT);

		return order;
	}

	private void visit(int[][] matrix, int r, int c, Direction direction) {
		if (!visitable(matrix, r, c)) {
			return;
		}

		visited[r][c] = true;
		order.add(matrix[r][c]);

		int nextRow = r + direction.getNextRow();
		int nextCol = c + direction.getNextCol();

		// move in a fixed direction
		visit(matrix, nextRow, nextCol, direction);

		// If you can't go, move according to the priority
		visit(matrix, r, c + 1, Direction.RIGHT);
		visit(matrix, r + 1, c, Direction.DOWN);
		visit(matrix, r, c - 1, Direction.LEFT);
		visit(matrix, r - 1, c, Direction.UP);
	}

	private boolean visitable(int[][] matrix, int r, int c) {
		return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length && !visited[r][c];
	}

	/**
	 * int[0]: row
	 * int[1]: column
	 */
	enum Direction {
		RIGHT(new int[] {0, 1}),
		DOWN(new int[] {1, 0}),
		LEFT(new int[] {0, -1}),
		UP(new int[] {-1, 0});

		final int[] direction;

		Direction(int[] direction) {
			this.direction = direction;
		}

		int getNextRow() {
			return direction[0];
		}

		int getNextCol() {
			return direction[1];
		}
	}
}