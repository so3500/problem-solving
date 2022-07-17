package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_71_SimplifyPathTest {
	private val lcn = LC_71_SimplifyPath()

	@ParameterizedTest
	@MethodSource
	fun test(input: String, expected: String) {
		assertThat(lcn.simplifyPath(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of("/home/", "/home"),
			Arguments.of("/../", "/"),
			Arguments.of("/./", "/"),
			Arguments.of("/home//foo/", "/home/foo"),
			Arguments.of("/a/./b/../../c/", "/c")
		)
	}
}