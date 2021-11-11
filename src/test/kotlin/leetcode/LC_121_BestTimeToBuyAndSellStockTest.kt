package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_121_BestTimeToBuyAndSellStockTest {
	private val lc121 = LC_121_BestTimeToBuyAndSellStock()

	@Test
	fun test() {
		assertThat(lc121.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))).isEqualTo(5)
		assertThat(lc121.maxProfit(intArrayOf(7, 6, 4, 3, 1))).isEqualTo(0)
		assertThat(lc121.maxProfit(intArrayOf(7, 6, 4, 1, 3))).isEqualTo(2)
		assertThat(lc121.maxProfit(intArrayOf(7))).isEqualTo(0)
	}
}