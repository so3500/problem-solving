package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 *
 * related topic: Depth-First Search, Breadth-First Search, Graph
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class LC_1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero {

	public int minReorder(int n, int[][] connections) {
		List<List<Integer>> adjacent = initAdjacent(n);
		boolean[] visited = new boolean[n];

		for (int[] connection : connections) {
			adjacent.get(connection[0]).add(connection[1]);
			adjacent.get(connection[1]).add(-connection[0]);
		}

		return dfs(adjacent, visited, 0);
	}

	private List<List<Integer>> initAdjacent(int n) {
		List<List<Integer>> adjacent = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjacent.add(new LinkedList<>());
		}

		return adjacent;
	}

	public int dfs(List<List<Integer>> adjacent, boolean[] visited, int v) {
		int reOrderCount = 0;
		visited[v] = true;
		List<Integer> children = adjacent.get(v);

		for (int child : children) {
			if (visited[Math.abs(child)]) {
				continue;
			}

			reOrderCount += dfs(adjacent, visited, Math.abs(child)) + (child > 0 ? 1 : 0);
		}
		return reOrderCount;
	}
}