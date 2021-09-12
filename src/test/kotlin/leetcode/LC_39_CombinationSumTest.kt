package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_39_CombinationSumTest {
	private val lc39 = LC_39_CombinationSum();

	@Test
	fun combinationSum() {
		assertThat(lc39.combinationSum(intArrayOf(2, 3, 6, 7), 7))
			.containsExactlyInAnyOrder(
				listOf(2, 2, 3),
				listOf(7)
			)

		assertThat(lc39.combinationSum(intArrayOf(2, 3, 5), 8))
			.containsExactlyInAnyOrder(
				listOf(2, 2, 2, 2),
				listOf(2, 3, 3),
				listOf(3, 5)
			)

		assertThat(lc39.combinationSum(intArrayOf(2), 1)).isEmpty()
		assertThat(lc39.combinationSum(intArrayOf(1), 1)).containsExactlyInAnyOrder(listOf(1))
		assertThat(lc39.combinationSum(intArrayOf(1), 2)).containsExactlyInAnyOrder(listOf(1, 1))
	}
}