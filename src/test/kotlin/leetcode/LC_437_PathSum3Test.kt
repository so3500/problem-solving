package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_437_PathSum3Test {
	private val lc437 = LC_437_PathSum3()

	@ParameterizedTest
	@MethodSource
	fun test(input: Input, expected: Int) {
		assertThat(lc437.pathSum(input.root, input.targetSum)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(Input(TreeNode(1, null, TreeNode(2, null, TreeNode(3, null, TreeNode(4, null, TreeNode(5))))), 3), 2)
		)
	}

	data class Input(val root: TreeNode, val targetSum: Int)
}