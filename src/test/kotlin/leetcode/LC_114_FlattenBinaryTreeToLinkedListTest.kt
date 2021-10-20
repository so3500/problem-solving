package leetcode

import org.junit.jupiter.api.Test

class LC_114_FlattenBinaryTreeToLinkedListTest {
	val lc114 = LC_114_FlattenBinaryTreeToLinkedList()

	@Test
	fun flatten() {
		lc114.flatten(makeNode2())
	}

	/**
	 * [1,2,5,3,4,null,6]
	 */
	private fun makeNode1(): TreeNode {
		val node1 = TreeNode(1)
		val node2 = TreeNode(2)
		val node3 = TreeNode(5)
		val node4 = TreeNode(3)
		val node5 = TreeNode(4)
		val node6 = TreeNode(6)
		
		node1.left = node2
		node1.right = node3

		node2.left = node4
		node2.right = node5

		node3.right = node6

		return node1
	}

	/**
	 * [1,null,2,3]
	 */
	private fun makeNode2(): TreeNode {
		val node1 = TreeNode(1)
		val node2 = TreeNode(2)
		val node3 = TreeNode(3)

		node1.right = node2;
		node2.left = node3;

		return node1;
	}
}