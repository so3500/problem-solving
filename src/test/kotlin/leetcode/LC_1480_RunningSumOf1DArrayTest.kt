package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_1480_RunningSumOf1DArrayTest {
    private val lcn = LC_1480_RunningSumOf1DArray()

    @ParameterizedTest
    @MethodSource
    fun test(input: IntArray, expected: IntArray) {
        assertThat(lcn.runningSum(input)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
                Arguments.of(intArrayOf(1, 2, 3, 4), intArrayOf(1, 3, 6, 10)),
                Arguments.of(intArrayOf(1, 1, 1, 1, 1), intArrayOf(1, 2, 3, 4, 5)),
                Arguments.of(intArrayOf(3, 1, 2, 10, 1), intArrayOf(3, 4, 6, 16, 17))
        )
    }
}