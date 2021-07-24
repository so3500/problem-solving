package leetcode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * binary tree
 * pre-order, in-order, post-order
 * recursive
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class LC_226_InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		swap(root);
		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

	public void swap(TreeNode root) {
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
	}
}