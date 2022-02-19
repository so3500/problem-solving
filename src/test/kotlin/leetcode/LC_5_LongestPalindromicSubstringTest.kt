package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_5_LongestPalindromicSubstringTest {
	private val lcn = LC_5_LongestPalindromicSubstring()

	@ParameterizedTest
	@MethodSource
	fun test(input: String, expected: String) {
		assertThat(lcn.longestPalindrome(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of("babad", "bab"), // == aba
			Arguments.of("cbbd", "bb"),
			Arguments.of("a", "a"),
			Arguments.of("aa", "aa"),
			Arguments.of("aaa", "aaa"),
			Arguments.of("aaaa", "aaaa")
		)
	}
}