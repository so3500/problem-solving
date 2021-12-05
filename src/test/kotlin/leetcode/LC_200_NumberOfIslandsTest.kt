package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_200_NumberOfIslandsTest {
	private val lc200 = LC_200_NumberOfIslands()

	@ParameterizedTest
	@MethodSource
	fun test(input: Array<CharArray>, expected: Int) {
		assertThat(lc200.numIslands(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(
				arrayOf(
					charArrayOf('1', '1', '1', '1', '0'),
					charArrayOf('1', '1', '0', '1', '0'),
					charArrayOf('1', '1', '0', '0', '0'),
					charArrayOf('0', '0', '0', '0', '0')), 1,
				arrayOf(
					charArrayOf('1', '1', '0', '0', '0'),
					charArrayOf('1', '1', '0', '0', '0'),
					charArrayOf('0', '0', '1', '0', '0'),
					charArrayOf('0', '0', '0', '1', '1')), 3,
				arrayOf(
					charArrayOf('1', '1'),
					charArrayOf('1', '1')), 1,
				arrayOf(
					charArrayOf('0', '1'),
					charArrayOf('1', '0')), 2,
				arrayOf(
					charArrayOf('0'),
					charArrayOf('1')), 1,
				arrayOf(
					charArrayOf('0')), 0,
				arrayOf(
					charArrayOf('1')), 1
			)
		)
	}
}