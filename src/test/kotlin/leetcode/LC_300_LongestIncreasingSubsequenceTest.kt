package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_300_LongestIncreasingSubsequenceTest {
	private val lcn = LC_300_LongestIncreasingSubsequence()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, expected: Int) {
		assertThat(lcn.lengthOfLIS(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18), 4),
			Arguments.of(intArrayOf(0, 1, 0, 3, 2, 3), 4),
			Arguments.of(intArrayOf(7, 7, 7, 7, 7), 1)
		)
	}
}