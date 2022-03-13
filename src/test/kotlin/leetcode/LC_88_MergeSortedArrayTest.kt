package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_88_MergeSortedArrayTest {
    private val lcn = LC_88_MergeSortedArray()

    @ParameterizedTest
    @MethodSource
    fun test(nums1: IntArray, m: Int, nums2: IntArray, n: Int, output: IntArray) {
        lcn.merge(nums1, m, nums2, n)

        assertThat(nums1).isEqualTo(output)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
            Arguments.of(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3, intArrayOf(1, 2, 2, 3, 5, 6)),
            Arguments.of(intArrayOf(1), 1, intArrayOf(), 0, intArrayOf(1)),
            Arguments.of(intArrayOf(0), 0, intArrayOf(1), 1, intArrayOf(1)),
            Arguments.of(intArrayOf(2, 2, 3, 8, 10, 0, 0, 0), 5, intArrayOf(1, 3, 4), 3, intArrayOf(1, 2, 2, 3, 3, 4, 8, 10))
        )
    }
}