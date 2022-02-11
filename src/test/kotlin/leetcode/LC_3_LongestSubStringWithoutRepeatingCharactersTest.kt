package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_3_LongestSubStringWithoutRepeatingCharactersTest {
    private val lcn = LC_3_LongestSubStringWithoutRepeatingCharacters()

    @ParameterizedTest
    @MethodSource
    fun test(input: String, expected: Int) {
        assertThat(lcn.lengthOfLongestSubstring(input)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
            Arguments.of("abcabcbb", 3),
            Arguments.of("bbbbb", 1),
            Arguments.of("pwwkew", 3),
            Arguments.of("pwawkew", 4),
            Arguments.of("", 0)
        )
    }
}