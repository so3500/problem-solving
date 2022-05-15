package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_4_MedianOfTwoSortedArraysTest {
	private val lcn = LC_4_MedianOfTwoSortedArrays()

	@ParameterizedTest
	@MethodSource
	fun test(nums1: IntArray, nums2: IntArray, output: Double) {
		assertThat(lcn.findMedianSortedArrays(nums1, nums2)).isEqualTo(output)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(1,3), intArrayOf(2), 2.0),
			Arguments.of(intArrayOf(1,2), intArrayOf(3,4), 2.5)
		)
	}
}