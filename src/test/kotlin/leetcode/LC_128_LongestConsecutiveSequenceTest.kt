package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_128_LongestConsecutiveSequenceTest {
	private val lc = LC_128_LongestConsecutiveSequence()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, expected: Int) {
		assertThat(lc.longestConsecutive(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(100, 4, 200, 1, 3, 2), 4),
			Arguments.of(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1), 9),
			Arguments.of(intArrayOf(1), 1)
		)
	}
}