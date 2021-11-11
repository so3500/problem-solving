package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_11_ContainerWithMostWaterTest {
	private val lc11 = LC_11_ContainerWithMostWater();

	@Test
	fun test() {
		assertThat(lc11.maxArea(intArrayOf(1, 1))).isEqualTo(1)
		assertThat(lc11.maxArea(intArrayOf(4, 3, 2, 1, 4))).isEqualTo(16)
		assertThat(lc11.maxArea(intArrayOf(1, 2, 1))).isEqualTo(2)
		assertThat(lc11.maxArea(intArrayOf(9, 3, 1, 1, 1, 10, 1, 2, 1, 12, 6))).isEqualTo(81)
	}
}