package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_62_UniquePathsTest {
	private val lc62 = LC_62_UniquePaths();

	@Test
	fun uniquePaths() {
		assertThat(lc62.uniquePaths(3, 7)).isEqualTo(28)
		assertThat(lc62.uniquePaths(3, 3)).isEqualTo(6)
		assertThat(lc62.uniquePaths(3, 2)).isEqualTo(3)
	}
}