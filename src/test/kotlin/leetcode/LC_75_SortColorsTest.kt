package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_75_SortColorsTest {
	private val lc75 = LC_75_SortColors()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, expected: IntArray) {
		lc75.sortColors(input)
		assertThat(input).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(2, 0, 2, 1, 1, 0), intArrayOf(0, 0, 1, 1, 2, 2)),
			Arguments.of(intArrayOf(2, 1, 0), intArrayOf(0, 1, 2)),
			Arguments.of(intArrayOf(0), intArrayOf(0)),
			Arguments.of(intArrayOf(1), intArrayOf(1)),
			Arguments.of(intArrayOf(2), intArrayOf(2)),
			Arguments.of(intArrayOf(1, 2, 1), intArrayOf(1, 1, 2))
		)
	}
}