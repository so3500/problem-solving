package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_169_MajorityElementTest {
	private val lc169 = LC_169_MajorityElement();

	@Test
	fun majorityElement() {
		assertThat(lc169.majorityElement(intArrayOf(3, 2, 3))).isEqualTo(3)
		assertThat(lc169.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2))).isEqualTo(2)
		assertThat(lc169.majorityElement(intArrayOf(1, 1, 2, 2, 1, 1, 3, 3, 3, 1, 1))).isEqualTo(1)
	}
}