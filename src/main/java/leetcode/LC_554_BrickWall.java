package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/brick-wall/
 * related topic: Array, Hash Table
 *
 * N: number of wall
 * M: number of bricks
 * Time Complexity: O(N*M)
 * Space Complexity: O(M)
 */
public class LC_554_BrickWall {
	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> pathCountMap = new HashMap<>();

		int maxPathCount = 0;
		for (List<Integer> bricks : wall) {
			int index = 0;

			for (int col = 0; col < bricks.size() - 1; col++) {
				index += bricks.get(col);

				int pathCount = pathCountMap.getOrDefault(index, 0) + 1;
				pathCountMap.put(index, pathCount);

				maxPathCount = Integer.max(maxPathCount, pathCount);
			}
		}

		return wall.size() - maxPathCount;
	}
}