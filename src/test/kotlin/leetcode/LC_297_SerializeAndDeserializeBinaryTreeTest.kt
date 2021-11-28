package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_297_SerializeAndDeserializeBinaryTreeTest {
	private val lc297 = LC_297_SerializeAndDeserializeBinaryTree()

	@ParameterizedTest
	@MethodSource
	fun test(input: TreeNode, expected: String) {
		val serializedData = lc297.serialize(input)
		val deSerializedData = lc297.deserialize(serializedData)

		assertThat(serializedData).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(TreeNode(1), "1,null,null,"),
			Arguments.of(TreeNode(1, TreeNode(2), TreeNode(3, TreeNode(4), TreeNode(5))), "1,2,null,null,3,4,null,null,5,null,null,")
		)
	}
}