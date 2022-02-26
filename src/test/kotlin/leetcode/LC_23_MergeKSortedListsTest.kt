package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_23_MergeKSortedListsTest {
	private val lcn = LC_23_MergeKSortedLists()

	@ParameterizedTest
	@MethodSource
	fun test(input: Array<IntArray>, expected: IntArray) {
		val lists = ListNodeUtils.convertToListNode(input)

		val actual = lcn.mergeKLists(lists)

		assertThat(ListNodeUtils.convertToIntArray(actual)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(arrayOf(intArrayOf(1, 4, 5), intArrayOf(1, 3, 4), intArrayOf(2, 6)), intArrayOf(1, 1, 2, 3, 4, 4, 5, 6)),
			Arguments.of(arrayOf(intArrayOf(1), intArrayOf(2)), intArrayOf(1, 2)),
			Arguments.of(arrayOf(intArrayOf(), intArrayOf()), intArrayOf()),
			Arguments.of(arrayOf(intArrayOf()), intArrayOf())
		)
	}
}