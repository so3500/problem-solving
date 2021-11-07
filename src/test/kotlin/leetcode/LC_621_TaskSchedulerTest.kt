package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_621_TaskSchedulerTest {
	private val lc621 = LC_621_TaskScheduler()

	@Test
	fun test() {
		// A -> B -> idle -> A -> B -> idle -> A -> B
		assertThat(lc621.leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2)).isEqualTo(8)

		// ['A','A','A','B','B','B'], ...
		assertThat(lc621.leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 0)).isEqualTo(6)

		// A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
		assertThat(lc621.leastInterval(charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'), 2)).isEqualTo(16)
	}
}