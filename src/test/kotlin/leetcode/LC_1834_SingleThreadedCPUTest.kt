package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_1834_SingleThreadedCPUTest {
    private val lcn = LC_1834_SingleThreadedCPU()

    @ParameterizedTest
    @MethodSource
    fun test(input: Array<IntArray>, expected: IntArray) {
        val order = lcn.getOrder(input)

        assertThat(order).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
                Arguments.of(arrayOf(intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(3, 2), intArrayOf(4, 1)), intArrayOf(0, 2, 3, 1)),
                Arguments.of(arrayOf(intArrayOf(7, 10), intArrayOf(7, 12), intArrayOf(7, 5), intArrayOf(7, 4), intArrayOf(7, 2)), intArrayOf(4, 3, 2, 0, 1))
        )
    }
}