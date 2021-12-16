package leetcode;

/**
 * related topic: Tree, Binary Tree, Depth-First Search, Breadth-First Search
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LC_101_SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return isSymmetricByRecursion(root);
	}

	private boolean isSymmetricByRecursion(TreeNode root) {
		String left = inorderFromLeft(root);
		String right = inorderFromRight(root);

		return left.equals(right);
	}

	private String inorderFromLeft(TreeNode root) {
		if (root == null) {
			return "x";
		}

		String val = String.valueOf(root.val);
		val += inorderFromLeft(root.left);
		val += inorderFromLeft(root.right);

		return val;
	}

	private String inorderFromRight(TreeNode root) {
		if (root == null) {
			return "x";
		}

		String val = String.valueOf(root.val);
		val += inorderFromRight(root.right);
		val += inorderFromRight(root.left);

		return val;
	}
}