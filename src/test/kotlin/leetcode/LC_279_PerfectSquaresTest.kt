package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_279_PerfectSquaresTest {
	private val lc279 = LC_279_PerfectSquares()

	@ParameterizedTest
	@MethodSource
	fun test(input: Int, expected: Int) {
		assertThat(lc279.numSquares(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(1, 1),
			Arguments.of(2, 2),
			Arguments.of(3, 3),
			Arguments.of(4, 1), // 4
			Arguments.of(12, 3), // 4+4+4
			Arguments.of(19, 3), // 9+9+1
			Arguments.of(299, 3)
		)
	}
}