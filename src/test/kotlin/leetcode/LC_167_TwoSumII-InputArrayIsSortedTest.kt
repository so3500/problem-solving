package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class `LC_167_TwoSumII-InputArrayIsSortedTest` {
	private val lc = LC_167_TwoSumII_InputArrayIsSorted()

	@ParameterizedTest
	@MethodSource
	fun test(numbers: IntArray, target: Int, expected: IntArray) {
		assertThat(lc.twoSum(numbers, target)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(2, 7, 11, 15), 9, intArrayOf(1, 2)),
			Arguments.of(intArrayOf(2, 3, 4), 6, intArrayOf(1, 3)),
			Arguments.of(intArrayOf(-1, 0), -1, intArrayOf(1, 2)),
			Arguments.of(intArrayOf(1, 2, 3, 4, 5, 7, 10, 21), 13, intArrayOf(3, 7)),
			Arguments.of(intArrayOf(2, 3, 6, 8, 10, 12), 16, intArrayOf(3, 5))
		)
	}
}