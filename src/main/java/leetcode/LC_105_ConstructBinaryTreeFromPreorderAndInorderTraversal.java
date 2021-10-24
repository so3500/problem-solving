package leetcode;

/**
 * related topic: Divide and Conquer, Tree, Binary Tree
 * Time Complexity: O(N^2) - node 수 만큼 recursion O(N) * findInorderIndex O(N)
 * Space Complexity: O(1) - 요구사항인 tree 생성 외 추가 메모리 사용하지 않음
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class LC_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
	private int[] preorder;
	private int[] inorder;
	private int preorderIndex;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorder = inorder;

		return buildTree(0, preorder.length - 1);
	}

	private TreeNode buildTree(int start, int end) {
		if (start > end) {
			return null;
		}

		int inorderIndex = findIndexOfInorder(preorderIndex++);

		TreeNode node = new TreeNode(inorder[inorderIndex]);
		node.left = buildTree(start, inorderIndex - 1);
		node.right = buildTree(inorderIndex + 1, end);

		return node;
	}

	private int findIndexOfInorder(int nodeIndex) {
		int startNodeValue = preorder[nodeIndex];

		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == startNodeValue) {
				index = i;
				break;
			}
		}
		return index;
	}
}