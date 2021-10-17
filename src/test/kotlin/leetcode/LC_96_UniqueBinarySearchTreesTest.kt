package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_96_UniqueBinarySearchTreesTest {
	private val lc96 = LC_96_UniqueBinarySearchTrees();

	@Test
	fun numTrees() {
		assertThat(lc96.numTrees(1)).isEqualTo(1)
		assertThat(lc96.numTrees(2)).isEqualTo(2)

		// 2+1+1
		assertThat(lc96.numTrees(3)).isEqualTo(5)

		// 5+2+2+5
		assertThat(lc96.numTrees(4)).isEqualTo(14)

		// 14+5+2+5+14
		assertThat(lc96.numTrees(5)).isEqualTo(42)
	}
}