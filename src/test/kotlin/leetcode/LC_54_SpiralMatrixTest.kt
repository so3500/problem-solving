package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_54_SpiralMatrixTest {
	private val lcn = LC_54_SpiralMatrix()

	@ParameterizedTest
	@MethodSource
	fun test(input: Array<IntArray>, expected: List<Int>) {
		assertThat(lcn.spiralOrder(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(
				arrayOf(
					intArrayOf(1, 2, 3),
					intArrayOf(4, 5, 6),
					intArrayOf(7, 8, 9)
				),
				listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
			),
			Arguments.of(
				arrayOf(
					intArrayOf(1, 2, 3, 4),
					intArrayOf(5, 6, 7, 8),
					intArrayOf(9, 10, 11, 12)
				),
				listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
			),
			Arguments.of(
				arrayOf(
					intArrayOf(1, 2, 3, 4),
					intArrayOf(5, 6, 7, 8),
					intArrayOf(9, 10, 11, 12),
					intArrayOf(13, 14, 15, 16)
				),
				listOf(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10)
			),
			Arguments.of(
				arrayOf(
					intArrayOf(1)
				),
				listOf(1)
			)
		)
	}
}