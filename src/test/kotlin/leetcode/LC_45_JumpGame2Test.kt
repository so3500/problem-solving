package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_45_JumpGame2Test {
    private val lcn = LC_45_JumpGame2()

    @ParameterizedTest
    @MethodSource
    fun test(input: IntArray, expected: Int) {
        val jumpCount = lcn.jump(input)

        assertThat(jumpCount).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
                Arguments.of(intArrayOf(2, 3, 1, 1, 4), 2),
                Arguments.of(intArrayOf(2, 3, 0, 1, 4), 2),
                Arguments.of(intArrayOf(), 0),
                Arguments.of(intArrayOf(0), 0),
                Arguments.of(intArrayOf(2, 1), 1),
                Arguments.of(intArrayOf(5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5), 5),
                Arguments.of(intArrayOf(5, 8, 1, 8, 9, 8, 7, 1, 7, 5, 8, 6, 5, 4, 7, 3, 9, 9, 0, 6, 6, 3, 4, 8, 0, 5, 8, 9, 5, 3, 7, 2, 1, 8, 2, 3, 8, 9, 4, 7, 6, 2, 5, 2, 8, 2, 7, 9, 3, 7, 6, 9, 2, 0, 8, 2, 7, 8, 4, 4, 1, 1, 6, 4, 1, 0, 7, 2, 0, 3, 9, 8, 7, 7, 0, 6, 9, 9, 7, 3, 6, 3, 4, 8, 6, 4, 3, 3, 2, 7, 8, 5, 8, 6, 0), 16)

        )
    }
}