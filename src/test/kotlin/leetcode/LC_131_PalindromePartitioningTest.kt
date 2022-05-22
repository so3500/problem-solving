package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_131_PalindromePartitioningTest {
    private val lcn = LC_131_PalindromePartitioning()

    @ParameterizedTest
    @MethodSource
    fun test(input: String, expected: List<List<String>>) {
        assertThat(lcn.partition(input)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
                Arguments.of("aab", listOf(listOf("a", "a", "b"), listOf("aa", "b"))),
                Arguments.of("a", listOf(listOf("a")))
        )
    }
}