package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_84_LargestRectangleInHistogramTest {
	private val lc = LC_84_LargestRectangleInHistogram()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, expected: Int) {
		assertThat(lc.largestRectangleArea(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
//			Arguments.of(intArrayOf(2, 1, 5, 6, 2, 3), 10),
//			Arguments.of(intArrayOf(1), 1),
//			Arguments.of(intArrayOf(2, 4), 4),
//			Arguments.of(intArrayOf(2, 1, 2), 3),
			Arguments.of(intArrayOf(4, 2, 0, 3, 2, 5), 6)
		)
	}
}