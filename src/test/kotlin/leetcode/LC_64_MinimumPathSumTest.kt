package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_64_MinimumPathSumTest {
	private val lc64 = LC_64_MinimumPathSum()

	@Test
	fun minPathSum() {
		assertThat(lc64.minPathSum(arrayOf(
			intArrayOf(1, 3, 1),
			intArrayOf(1, 5, 1),
			intArrayOf(4, 5, 1)
		))).isEqualTo(7)

		assertThat(lc64.minPathSum(arrayOf(
			intArrayOf(1, 2, 3),
			intArrayOf(4, 5, 6)
		))).isEqualTo(12)
	}
}