package leetcode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
public class LC_108_ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return recursive(nums, 0, nums.length - 1);
	}

	/**
	 * divide and conquer with recursive
	 *
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
	 * Memory Usage: 38.4 MB, less than 90.04% of Java online submissions for Convert Sorted Array to Binary Search Tree.
	 */
	private TreeNode recursive(int[] nums, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return null;
		}

		int midIndex = (startIndex + endIndex) / 2;
		TreeNode subRoot = new TreeNode(nums[midIndex]);
		subRoot.left = recursive(nums, startIndex, midIndex - 1);
		subRoot.right = recursive(nums, midIndex + 1, endIndex);

		return subRoot;
	}
}