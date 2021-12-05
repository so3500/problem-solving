package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * related topic: Array, Depth-First Search, Breadth-First Search, Union Find, Matrix
 * Time Complexity: O(NM)
 * Space Complexity: O(NM)
 */
public class LC_200_NumberOfIslands {
	private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public int numIslands(char[][] grid) {
		return countIslands(grid);
	}

	private int countIslands(char[][] grid) {
		int count = 0;
		Queue<Area> queue = new LinkedList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (enableTraveling(grid, i, j)) {
					travelAreaAndMark(grid, i, j, queue);
					travel(grid, queue);
					count++;
				}
			}
		}

		return count;
	}

	private void travel(char[][] grid, Queue<Area> queue) {
		while (!queue.isEmpty()) {
			Area area = queue.poll();

			for (int[] direction : directions) {
				int nextRow = area.row + direction[0];
				int nextCol = area.col + direction[1];

				if (enableTraveling(grid, nextRow, nextCol)) {
					travelAreaAndMark(grid, nextRow, nextCol, queue);
				}
			}
		}
	}

	private static void travelAreaAndMark(char[][] grid, int i, int j, Queue<Area> queue) {
		queue.add(new Area(i, j));
		grid[i][j] = 'x';
	}

	private static boolean enableTraveling(char[][] grid, int i, int j) {
		return i >= 0 && i < grid.length
			&& j >= 0 && j < grid[i].length
			&& grid[i][j] == '1';
	}

	private static final class Area {
		int row;
		int col;

		private Area(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}