package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_1920_BuildArrayFromPermutationTest {
    private val lcn = LC_1920_BuildArrayFromPermutation()

    @ParameterizedTest
    @MethodSource
    fun test(input: IntArray, expected: IntArray) {
        assertThat(lcn.buildArray(input)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
            Arguments.of(intArrayOf(0, 2, 1, 5, 3, 4), intArrayOf(0, 1, 2, 4, 5, 3)),
            Arguments.of(intArrayOf(5, 0, 1, 2, 3, 4), intArrayOf(4, 5, 0, 1, 2, 3))
        )
    }
}