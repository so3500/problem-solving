package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_35_SearchInsertPositionTest {
    private val lcn = LC_35_SearchInsertPosition()

    @ParameterizedTest
    @MethodSource
    fun test(nums: IntArray, target: Int, insertPosition: Int) {
        assertThat(lcn.searchInsert(nums, target)).isEqualTo(insertPosition)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
            Arguments.of(intArrayOf(1, 3, 5, 6), 5, 2),
            Arguments.of(intArrayOf(1, 3, 5, 6), 2, 1),
            Arguments.of(intArrayOf(1, 3, 5, 6), 7, 4)
        )
    }
}