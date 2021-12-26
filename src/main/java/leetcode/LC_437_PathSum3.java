package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * related topic: Tree, Depth-First Search, Breadth-First Search, HashMap, BinaryTree
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class LC_437_PathSum3 {
	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}

		return findNumOfPaths(root, targetSum);
	}

	private int findNumOfPaths(TreeNode root, int targetSum) {
		Queue<TreeNodeWithPathSum> q = new LinkedList<>();
		q.add(TreeNodeWithPathSum.createStartingFromSelf(root));

		int numOfPaths = 0;

		while (!q.isEmpty()) {
			TreeNodeWithPathSum node = q.poll();

			if (node.equalsPathSum(targetSum)) {
				numOfPaths++;
			}

			if (node.getLeft() != null) {
				// 현재 노드에서 시작한 경우에만 다음 자식 노드에서 시작하는 노드를 설정할 수 있다.
				if (node.isFromSelf()) {
					q.add(TreeNodeWithPathSum.createStartingFromSelf(node.getLeft()));
				}
				// 조상 노드에서 시작한 경우 이어서 탐색만 가능하다.
				q.add(TreeNodeWithPathSum.createStartingFromAsc(node, node.getLeft()));

			}

			if (node.getRight() != null) {
				if (node.isFromSelf()) {
					q.add(TreeNodeWithPathSum.createStartingFromSelf(node.getRight()));
				}
				q.add(TreeNodeWithPathSum.createStartingFromAsc(node, node.getRight()));
			}
		}

		return numOfPaths;
	}

	static class TreeNodeWithPathSum {
		/**
		 * 조상노드 ~ 현재 노드까지의 val 합
		 */
		private int pathSum;

		/**
		 * 현재 노드
		 */
		private TreeNode node;

		/**
		 * 조상노드에서 시작 여부
		 * true: 조상 node 에서 시작
		 * false: 현재 node 에서 시작
		 */
		private boolean fromAsc;

		public static TreeNodeWithPathSum createStartingFromSelf(TreeNode node) {
			TreeNodeWithPathSum n = new TreeNodeWithPathSum();
			n.pathSum = node.val;
			n.node = node;
			n.fromAsc = false;
			return n;
		}

		public static TreeNodeWithPathSum createStartingFromAsc(TreeNodeWithPathSum node, TreeNode startNode) {
			TreeNodeWithPathSum n = new TreeNodeWithPathSum();
			n.pathSum = node.pathSum + startNode.val;
			n.node = startNode;
			n.fromAsc = true;
			return n;
		}

		public TreeNode getLeft() {
			return node.left;
		}

		public TreeNode getRight() {
			return node.right;
		}

		public boolean equalsPathSum(int targetSum) {
			return this.pathSum == targetSum;
		}

		public boolean isFromSelf() {
			return !fromAsc;
		}
	}
}