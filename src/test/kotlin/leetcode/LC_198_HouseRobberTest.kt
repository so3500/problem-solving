package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_198_HouseRobberTest {
	private val lc = LC_198_HouseRobber()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, expected: Int) {
		assertThat(lc.rob(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(1, 2, 3, 1), 4),
			Arguments.of(intArrayOf(100, 1, 1, 100), 200),
			Arguments.of(intArrayOf(1), 1),
			Arguments.of(intArrayOf(1, 3), 3)
		)
	}
}