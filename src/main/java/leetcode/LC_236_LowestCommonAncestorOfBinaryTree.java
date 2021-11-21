package leetcode;

/**
 * related topic: Tree, Depth First Search, Binary Tree
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LC_236_LowestCommonAncestorOfBinaryTree {

	private TreeNode lca;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		findLCA(root, p, q);
		return lca;
	}

	private boolean findLCA(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null) {
			return false;
		}
		if (lca != null) { // break
			return false;
		}

		boolean findFromLeft = findLCA(node.left, p, q);
		boolean findFromRight = findLCA(node.right, p, q);
		boolean findFromMid = node == p || node == q;

		if (hasFoundLCA(findFromMid, findFromLeft, findFromRight)) {
			lca = node;
		}

		return findFromMid || findFromLeft || findFromRight;
	}

	private static boolean hasFoundLCA(boolean mid, boolean left, boolean right) {
		return (mid && left) || (mid && right) || (left && right);
	}

}