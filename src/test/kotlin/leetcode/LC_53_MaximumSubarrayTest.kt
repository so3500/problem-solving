package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_53_MaximumSubarrayTest {
	private val lc53 = LC_53_MaximumSubarray()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, expected: Int) {
		assertThat(lc53.maxSubArray(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
			Arguments.of(intArrayOf(1), 1),
			Arguments.of(intArrayOf(5, 4, -1, 7, 8), 23)
		)
	}
}