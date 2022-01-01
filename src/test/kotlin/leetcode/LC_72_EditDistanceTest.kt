package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_72_EditDistanceTest {
	private val lc72 = LC_72_EditDistance()

	@ParameterizedTest
	@MethodSource
	fun test(from: String, to: String, expected: Int) {
		assertThat(lc72.minDistance(from, to)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of("horse", "ros", 3),
			Arguments.of("intention", "execution", 5),
			Arguments.of("aaa", "", 3),
			Arguments.of("", "aaa", 3),
			Arguments.of("aaa", "aaa", 0),
			Arguments.of("dinitrophenylhydrazine", "acetylphenylhydrazine", 6)
		)
	}
}