package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_221_MaximalSquareTest {
	private val lcn = LC_221_MaximalSquare()

	@ParameterizedTest
	@MethodSource
	fun test(input: Array<CharArray>, expected: Int) {
		assertThat(lcn.maximalSquare(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(
				arrayOf(
					charArrayOf('1', '0', '1', '0', '0'),
					charArrayOf('1', '0', '1', '1', '1'),
					charArrayOf('1', '1', '1', '1', '1'),
					charArrayOf('1', '0', '0', '1', '0')
				), 4
			),
			Arguments.of(
				arrayOf(
					charArrayOf('0', '1'),
					charArrayOf('1', '0')
				), 1
			),
			Arguments.of(
				arrayOf(charArrayOf('0')),
				0
			)
		)
	}
}