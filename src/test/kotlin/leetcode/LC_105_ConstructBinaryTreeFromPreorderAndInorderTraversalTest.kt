package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_105_ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
	private val lc105 = LC_105_ConstructBinaryTreeFromPreorderAndInorderTraversal()

	@Test
	fun buildTree() {
		val preorder = intArrayOf(3, 9, 20, 15, 7)
		val inorder = intArrayOf(9, 3, 15, 20, 7)

		val node = lc105.buildTree(preorder, inorder)

		assertThat(node.`val`).isEqualTo(3)
		assertThat(node.left.`val`).isEqualTo(9)
		assertThat(node.right.`val`).isEqualTo(20)
		assertThat(node.right.left.`val`).isEqualTo(15)
		assertThat(node.right.right.`val`).isEqualTo(7)
	}
}