package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_215_KthLargestElementInAnArrayTest {
	private val lc215 = LC_215_KthLargestElementInAnArray();

	@Test
	fun findKthLargest() {
		assertThat(lc215.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2)).isEqualTo(5)
		assertThat(lc215.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4)).isEqualTo(4)
		assertThat(lc215.findKthLargest(intArrayOf(1), 1)).isEqualTo(1)
	}
}