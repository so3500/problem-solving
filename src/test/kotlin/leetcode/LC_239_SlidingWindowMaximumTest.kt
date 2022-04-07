package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_239_SlidingWindowMaximumTest {
	private val lcn = LC_239_SlidingWindowMaximum()

	@ParameterizedTest
	@MethodSource
	fun test(nums: IntArray, k: Int, expected: IntArray) {
		assertThat(lcn.maxSlidingWindow(nums, k)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3, intArrayOf(3, 3, 5, 5, 6, 7)),
			Arguments.of(intArrayOf(1), 1, intArrayOf(1))
		)
	}
}