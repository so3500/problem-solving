package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_208_ImplementTriePrefixTreeTest {
	private val lc208 = LC_208_ImplementTriePrefixTree()

	@Test
	fun test() {
		val trie = lc208.Trie()

		trie.insert("apple")

		assertThat(trie.search("apple")).isTrue()
		assertThat(trie.search("app")).isFalse()
		assertThat(trie.startsWith("app")).isTrue()

		trie.insert("app")

		assertThat(trie.search("app")).isTrue()
	}
}