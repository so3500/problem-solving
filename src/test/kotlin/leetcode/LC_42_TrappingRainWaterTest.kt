package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_42_TrappingRainWaterTest {
	private val lc42 = LC_42_TrappingRainWater()

	@Test
	fun test() {
		assertThat(lc42.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))).isEqualTo(6)
		assertThat(lc42.trap(intArrayOf(4, 2, 0, 3, 2, 5))).isEqualTo(9)
		assertThat(lc42.trap(intArrayOf(0))).isEqualTo(0)
		assertThat(lc42.trap(intArrayOf(1, 1))).isEqualTo(0)
	}
}