package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_98_ValidateBinarySearchTreeTest {
	private val lcn = LC_98_ValidateBinarySearchTree()

	@ParameterizedTest
	@MethodSource
	fun test(input: TreeNode, expected: Boolean) {
		assertThat(lcn.isValidBST(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(TreeNode(2, TreeNode(1), TreeNode(3)), true),
			Arguments.of(TreeNode(2, TreeNode(1), TreeNode(3)), true),
			Arguments.of(TreeNode(1, TreeNode(1), TreeNode(1)), false),
			Arguments.of(TreeNode(2147483647), true)
		)
	}
}