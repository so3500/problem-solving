package leetcode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class LC_114_FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		flattenWithRecursion(root);
	}

	/**
	 * time complexity:
	 * space complexith: O(1)
	 */
	private static void flattenWithRecursion(TreeNode root) {
		if (root == null) {
			return;
		}

		// leftSubTree 를 rightSubTree 로 옮긴다.
		// 옮길 leftSubTree 의 pre-order 마지막 순서 node 의 right 를 구한다.
		// 그 rightNode.right 에 기존 rightSubTree 를 옮긴다.
		if (root.left != null) {
			TreeNode right = root.right;
			TreeNode nodeInLeftSubTreeWhereRightIsNull = findNodeInLeftSubTreeWhereRightIsNull(root.left);
			root.right = root.left;
			root.left = null;
			nodeInLeftSubTreeWhereRightIsNull.right = right;
		}
		flattenWithRecursion(root.right);
	}

	/**
	 * root 기준 right 가 null 인 가장 오른쪽 node 를 구한다.
	 */
	private static TreeNode findNodeInLeftSubTreeWhereRightIsNull(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}

		return root;
	}
}