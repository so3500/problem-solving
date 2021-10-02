package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_199_BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		rightSideViewWithRecursion(root, 0, result);
		return result;
	}

	private void rightSideViewWithRecursion(TreeNode root, int depth, List<Integer> result) {
		if (root == null) {
			return;
		}

		if (result.size() == depth) {
			result.add(root.val);
		}

		rightSideViewWithRecursion(root.right, depth + 1, result);
		rightSideViewWithRecursion(root.left, depth + 1, result);
	}
}