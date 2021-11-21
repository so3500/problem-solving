package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_236_LowestCommonAncestorOfBinaryTreeTest {
	private val lc236 = LC_236_LowestCommonAncestorOfBinaryTree()

	@Test
	fun test() {
		val p = TreeNode(5,
			TreeNode(6),
			TreeNode(2, TreeNode(7), TreeNode(4)))
		val q = TreeNode(1, TreeNode(0), TreeNode(8))
		val root = TreeNode(3, p, q)

		assertThat(lc236.lowestCommonAncestor(root, p, q)).isEqualTo(root);
	}
}