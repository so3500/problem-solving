package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_1466_ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest {
	private val lc = LC_1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero()

	@ParameterizedTest
	@MethodSource
	fun test(n: Int, connections: Array<IntArray>, expected: Int) {
		assertThat(lc.minReorder(n, connections)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(5, arrayOf(intArrayOf(4, 3), intArrayOf(2, 3), intArrayOf(1, 2), intArrayOf(1, 0)), 2),
			Arguments.of(6, arrayOf(intArrayOf(0, 1), intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(4, 0), intArrayOf(4, 5)), 3),
			Arguments.of(6, arrayOf(intArrayOf(0, 1), intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(5, 0), intArrayOf(5, 4)), 3),
			Arguments.of(5, arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(3, 2), intArrayOf(3, 4)), 2),
			Arguments.of(3, arrayOf(intArrayOf(1, 0), intArrayOf(2, 0)), 0)
		)
	}
}