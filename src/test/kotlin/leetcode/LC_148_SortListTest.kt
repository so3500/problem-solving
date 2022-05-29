package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_148_SortListTest {
    private val sut = LC_148_SortList()

    @ParameterizedTest
    @MethodSource
    fun test(input: IntArray, expected: IntArray) {
        val head = ListNodeUtils.convertToListNode(input);

        sut.sortList(head)

        assertThat(ListNodeUtils.convertToIntArray(head)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
                Arguments.of(intArrayOf(4, 2, 1, 3), intArrayOf(1, 2, 3, 4)),
                Arguments.of(intArrayOf(-1, 5, 3, 4, 0), intArrayOf(-1, 0, 3, 4, 5)),
                Arguments.of(intArrayOf(), intArrayOf())
        )
    }
}