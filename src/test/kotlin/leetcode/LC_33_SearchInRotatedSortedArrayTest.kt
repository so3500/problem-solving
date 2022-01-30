package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_33_SearchInRotatedSortedArrayTest {
	private val lc = LC_33_SearchInRotatedSortedArray()

	@ParameterizedTest
	@MethodSource
	fun test(nums: IntArray, target: Int, indexOfTarget: Int) {
		assertThat(lc.search(nums, target)).isEqualTo(indexOfTarget)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0, 4),
			Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3, -1),
			Arguments.of(intArrayOf(1), 1, 0),
			Arguments.of(intArrayOf(1), 0, -1),
			Arguments.of(intArrayOf(1, 3), 0, -1),
			Arguments.of(intArrayOf(1, 3), 1, 0),
			Arguments.of(intArrayOf(1, 3), 3, 1),
			Arguments.of(intArrayOf(7, 8, 1, 2, 3, 4, 5, 6), 2, 3)
		)
	}
}