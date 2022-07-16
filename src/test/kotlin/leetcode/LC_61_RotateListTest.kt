package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_61_RotateListTest {
    private val sut = LC_61_RotateList()

    @ParameterizedTest
    @MethodSource
    fun test(input: IntArray, k: Int, expected: IntArray) {
        val head = ListNodeUtils.convertToListNode(input)

        val actualHead = sut.rotateRight(head, k)

        assertThat(ListNodeUtils.convertToIntArray(actualHead)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 0, intArrayOf(1, 2, 3, 4, 5)),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 1, intArrayOf(5, 1, 2, 3, 4)),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 2, intArrayOf(4, 5, 1, 2, 3)),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 3, intArrayOf(3, 4, 5, 1, 2)),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 4, intArrayOf(2, 3, 4, 5, 1)),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 5, intArrayOf(1, 2, 3, 4, 5)),
                Arguments.of(intArrayOf(0, 1, 2), 4, intArrayOf(2, 0, 1)),
                Arguments.of(intArrayOf(), 1, intArrayOf())
        )
    }
}