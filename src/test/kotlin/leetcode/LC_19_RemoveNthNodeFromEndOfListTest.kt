package leetcode

import leetcode.ListNodeUtils.convertToIntArray
import leetcode.ListNodeUtils.convertToListNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_19_RemoveNthNodeFromEndOfListTest {
	private val lcn = LC_19_RemoveNthNodeFromEndOfList()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, n: Int, output: IntArray) {
		val head = convertToListNode(input)

		val actual = lcn.removeNthFromEnd(head, n)

		assertThat(convertToIntArray(actual)).isEqualTo(output)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(1, 2, 3, 4, 5), 2, intArrayOf(1, 2, 3, 5)),
			Arguments.of(intArrayOf(1), 1, intArrayOf()),
			Arguments.of(intArrayOf(1, 2), 1, intArrayOf(1)),
			Arguments.of(intArrayOf(1, 2), 2, intArrayOf(2))
		)
	}
}