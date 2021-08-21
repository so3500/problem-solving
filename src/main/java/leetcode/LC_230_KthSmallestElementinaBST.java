package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
public class LC_230_KthSmallestElementinaBST {

	/**
	 * 주어진 Binary Search Tree 의 특성을 이용한다.
	 * left -> root -> right 순으로 탐색 시 오름차순 탐색이 보장된다.
	 * 탐색하면서 오름차순 큐를 생성한다.
	 * 큐에서 k번째 수를 반환한다.
	 *
	 * Runtime: 1 ms, faster than 36.91% of Java online submissions for Kth Smallest Element in a BST.
	 * Memory Usage: 40.5 MB, less than 12.81% of Java online submissions for Kth Smallest Element in a BST.
	 */
	public int kthSmallest(TreeNode root, int k) {
		Queue<Integer> queue = new LinkedList<>();

		traverseAndPushValue(queue, root);

		return findKthNumber(queue, k);
	}

	private void traverseAndPushValue(Queue<Integer> queue, TreeNode root) {
		if (root == null) {
			return;
		}

		traverseAndPushValue(queue, root.left);
		queue.add(root.val);
		traverseAndPushValue(queue, root.right);

	}

	private int findKthNumber(Queue<Integer> queue, int k) {
		int ret = 0;
		while (k-- > 0) {
			ret = queue.remove();
		}
		return ret;
	}
}