package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


/**
 * isDeepEqualTo(int[][] expected): Verifies that the actual 2D array is deeply equal to the given one.
 * <a href="https://assertj.github.io/doc/#assertj-core-3-17-0-release-notes">since AssertJ Core 3.17.0</a>
 * <a href="https://example.com">Website</a>
 *
 */
class LC_73_SetMatrixZeroesTest {
	private val lcn = LC_73_SetMatrixZeroes()

	@ParameterizedTest
	@MethodSource
	fun test(input: Array<IntArray>, expected: Array<IntArray>) {
		lcn.setZeroes(input)

		assertThat(input).isDeepEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(
				arrayOf(
					intArrayOf(1, 1, 1),
					intArrayOf(1, 0, 1),
					intArrayOf(1, 1, 1)
				),
				arrayOf(
					intArrayOf(1, 0, 1),
					intArrayOf(0, 0, 0),
					intArrayOf(1, 0, 1)
				)
			),
			Arguments.of(
				arrayOf(
					intArrayOf(0, 1, 2, 0),
					intArrayOf(3, 4, 5, 2),
					intArrayOf(1, 3, 1, 5)
				),
				arrayOf(
					intArrayOf(0, 0, 0, 0),
					intArrayOf(0, 4, 5, 0),
					intArrayOf(0, 3, 1, 0)
				)
			)
		)
	}
}