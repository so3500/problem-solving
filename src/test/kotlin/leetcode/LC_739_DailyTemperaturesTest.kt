package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_739_DailyTemperaturesTest {
	private val lc739 = LC_739_DailyTemperatures()

	@Test
	fun dailyTemperatures() {
		assertThat(lc739.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))).isEqualTo(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0))
		assertThat(lc739.dailyTemperatures(intArrayOf(30, 40, 50, 60))).isEqualTo(intArrayOf(1, 1, 1, 0))
		assertThat(lc739.dailyTemperatures(intArrayOf(30, 60, 90))).isEqualTo(intArrayOf(1, 1, 0))
		assertThat(lc739.dailyTemperatures(intArrayOf(1))).isEqualTo(intArrayOf(0))
	}
}