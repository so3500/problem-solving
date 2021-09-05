package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_238_ProductOfArrayExceptSelfTest {
	private val lc238 = LC_238_ProductOfArrayExceptSelf()

	@Test
	fun productExceptSelf() {
		assertThat(lc238.productExceptSelf(intArrayOf(1, 2, 3, 4))).isEqualTo(intArrayOf(24, 12, 8, 6))
		assertThat(lc238.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3))).isEqualTo(intArrayOf(0, 0, 9, 0, 0))
		assertThat(lc238.productExceptSelf(intArrayOf(1, 2))).isEqualTo(intArrayOf(2, 1))
		assertThat(lc238.productExceptSelf(intArrayOf(1, 0))).isEqualTo(intArrayOf(0, 1))
	}
}