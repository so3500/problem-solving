package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_56_MergeIntervalsTest {
	private val lcn = LC_56_MergeIntervals()

	@ParameterizedTest
	@MethodSource
	fun test(input: Array<IntArray>, expected: Array<IntArray>) {
		assertThat(lcn.merge(input)).isDeepEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(
				arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
				arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))
			),
			Arguments.of(
				arrayOf(intArrayOf(15, 18), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(1, 3)),
				arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))
			),
			Arguments.of(
				arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)),
				arrayOf(intArrayOf(1, 5))
			),
			Arguments.of(
				arrayOf(intArrayOf(1, 5)),
				arrayOf(intArrayOf(1, 5))
			),
			Arguments.of(
				arrayOf(intArrayOf(1, 4), intArrayOf(2, 3)),
				arrayOf(intArrayOf(1, 4))
			),
			Arguments.of(
				arrayOf(intArrayOf(2, 3), intArrayOf(4, 5), intArrayOf(6, 7), intArrayOf(8, 9), intArrayOf(1, 10)),
				arrayOf(intArrayOf(1, 10))
			)
		)
	}
}