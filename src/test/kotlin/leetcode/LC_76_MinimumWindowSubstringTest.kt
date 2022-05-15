package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_76_MinimumWindowSubstringTest {
	private val lcn = LC_76_MinimumWindowSubstring()

	@ParameterizedTest
	@MethodSource
	fun test(s: String, t: String, output: String) {
		assertThat(lcn.minWindow(s, t)).isEqualTo(output)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
			Arguments.of("a", "a", "a"),
			Arguments.of("a", "aa", "")
		)
	}
}