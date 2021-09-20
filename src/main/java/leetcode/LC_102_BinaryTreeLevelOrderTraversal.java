package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class LC_102_BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> travelWithRecursion(TreeNode root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		travelWithRecursion(map, root, 0);
		return new ArrayList<>(map.values());
	}

	private void travelWithRecursion(Map<Integer, List<Integer>> map, TreeNode root, int depth) {
		if (root == null) {
			return;
		}

		map.putIfAbsent(depth, new ArrayList<>());
		map.get(depth).add(root.val);

		travelWithRecursion(map, root.left, depth + 1);
		travelWithRecursion(map, root.right, depth + 1);
	}

	private void travelWithQueue() {
		// TODO
	}
}