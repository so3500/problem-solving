package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_146_LRUCacheTest {
	private val lcn = LC_146_LRUCache()

	@Test
	fun test() {
		val cache = lcn.LRUCache(2)
		cache.put(1, 1)
		cache.put(2, 2)
		assertThat(cache.get(1)).isEqualTo(1)
		cache.put(3, 3)
		assertThat(cache.get(2)).isEqualTo(-1)
		cache.put(4, 4)
		assertThat(cache.get(1)).isEqualTo(-1)
		assertThat(cache.get(3)).isEqualTo(3)
		assertThat(cache.get(4)).isEqualTo(4)
	}
}