package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_70_ClimbingStairsTest {
	private val lc70 = LC_70_ClimbingStairs()

	@ParameterizedTest
	@MethodSource
	fun test(input: Int, expected: Int) {
		assertThat(lc70.climbStairs(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(1, 1),
			Arguments.of(2, 2),
			Arguments.of(3, 3),
			Arguments.of(4, 5),
			Arguments.of(10, 89),
			Arguments.of(45, 1836311903)
		)
	}
}