package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_120_TriangleTest {
	private val lcn = LC_120_Triangle()

	@ParameterizedTest
	@MethodSource
	fun test(input: List<List<Int>>, expected: Int) {
		assertThat(lcn.minimumTotal(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(listOf(listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3)), 11),
			Arguments.of(listOf(listOf(-10)), -10)
		)
	}
}