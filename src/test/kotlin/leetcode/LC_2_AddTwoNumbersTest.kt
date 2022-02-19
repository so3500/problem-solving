package leetcode

import leetcode.ListNodeUtils.convertToIntArray
import leetcode.ListNodeUtils.convertToListNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_2_AddTwoNumbersTest {
	private val lcn = LC_2_AddTwoNumbers()

	@ParameterizedTest
	@MethodSource
	fun test(input1: IntArray, input2: IntArray, expected: IntArray) {
		val l1 = convertToListNode(input1)
		val l2 = convertToListNode(input2)

		val actual = convertToIntArray(lcn.addTwoNumbers(l1, l2))

		assertThat(actual).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(2, 4, 3), intArrayOf(5, 6, 4), intArrayOf(7, 0, 8)),
			Arguments.of(intArrayOf(0), intArrayOf(0), intArrayOf(0)),
			Arguments.of(intArrayOf(1, 1), intArrayOf(0), intArrayOf(1, 1)),
			Arguments.of(intArrayOf(9, 9, 9, 9, 9, 9, 9), intArrayOf(9, 9, 9, 9), intArrayOf(8, 9, 9, 9, 0, 0, 0, 1))
		)
	}
}