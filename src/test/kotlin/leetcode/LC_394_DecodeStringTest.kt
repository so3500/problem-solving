package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_394_DecodeStringTest {
	private val lc394 = LC_394_DecodeString()

	@Test
	fun decodeString() {
		assertThat(lc394.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")).isEqualTo("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef")
		assertThat(lc394.decodeString("10[leetcode]")).isEqualTo("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode")
		assertThat(lc394.decodeString("a")).isEqualTo("a")
		assertThat(lc394.decodeString("3[a]")).isEqualTo("aaa")
		assertThat(lc394.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc")
		assertThat(lc394.decodeString("3[a2[c]]")).isEqualTo("accaccacc")
		assertThat(lc394.decodeString("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef")
		assertThat(lc394.decodeString("abc3[cd]xyz")).isEqualTo("abccdcdcdxyz")
	}
}