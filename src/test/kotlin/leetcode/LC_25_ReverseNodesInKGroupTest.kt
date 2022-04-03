package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_25_ReverseNodesInKGroupTest {
	private val lcn = LC_25_ReverseNodesInKGroup()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, k: Int, expected: IntArray) {
		val head = ListNodeUtils.convertToListNode(input)

		val reversed = ListNodeUtils.convertToIntArray(lcn.reverseKGroup(head, k))

		assertThat(reversed).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(1, 2, 3, 4, 5), 3, intArrayOf(3, 2, 1, 4, 5)),
			Arguments.of(intArrayOf(1, 2, 3, 4, 5), 2, intArrayOf(2, 1, 4, 3, 5))
		)
	}
}