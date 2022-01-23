package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_152_MaximumProductSubarrayTest {
    private val lc = LC_152_MaximumProductSubarray()

    @ParameterizedTest
    @MethodSource
    fun test(input: IntArray, expected: Int) {
        assertThat(lc.maxProduct(input)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
            Arguments.of(intArrayOf(2, -4, -2, -10, 0, 3), 20),
            Arguments.of(intArrayOf(2, -5, -2, -4, 3), 24),
            Arguments.of(intArrayOf(1), 1),
            Arguments.of(intArrayOf(1, 0), 1)
        )
    }
}