package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
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
public class LC_94_BinaryTreeInorderTraversal {

	List<Integer> ret;

	public List<Integer> inorderTraversal(TreeNode root) {
		ret = new ArrayList<>();
		inorderTraversalWithIterativeStack(root);
		return ret;
	}

	/**
	 * interative with stack
	 */
	private void inorderTraversalWithIterativeStack(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			ret.add(current.val);
			current = current.right;
		}
	}

	/**
	 * recursive
	 */
	private void inorderTraversalWithRecursive(TreeNode root) {
		if (root == null) {
			return;
		}

		inorderTraversalWithRecursive(root.left);
		ret.add(root.val);
		inorderTraversalWithRecursive(root.right);
	}
}