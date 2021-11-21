package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_337_HouseRobber3Test {
	private val lc337 = LC_337_HouseRobber3()

	@Test
	fun test1() {
		val root = TreeNode(3,
			TreeNode(2, null, TreeNode(3)),
			TreeNode(3, null, TreeNode(1)))

		assertThat(lc337.rob(root)).isEqualTo(7)
	}

	@Test
	fun test2() {
		val root = TreeNode(4,
			TreeNode(1,
				TreeNode(2,
					TreeNode(6), null), null), null)

		assertThat(lc337.rob(root)).isEqualTo(10)
	}
}