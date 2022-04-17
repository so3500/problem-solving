package leetcode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * related topic: Tree, Depth-First Search, Binary Search Tree, Binary Tree
 *
 * N : number of nodes
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_98_ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean validate(TreeNode current, long min, long max) {
		if (current == null) {
			return true;
		}
		if (current.val >= max || current.val <= min) {
			return false;
		}
		return validate(current.left, min, current.val) && validate(current.right, current.val, max);
	}
}