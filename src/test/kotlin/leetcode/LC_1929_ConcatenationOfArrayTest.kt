package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_1929_ConcatenationOfArrayTest {
    private val lcn = LC_1929_ConcatenationOfArray()

    @ParameterizedTest
    @MethodSource
    fun test(input: IntArray, expected: IntArray) {
        assertThat(lcn.getConcatenation(input)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
            Arguments.of(intArrayOf(1, 2, 1), intArrayOf(1, 2, 1, 1, 2, 1)),
            Arguments.of(intArrayOf(1, 3, 2, 1), intArrayOf(1, 3, 2, 1, 1, 3, 2, 1))
        )
    }
}