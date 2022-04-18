package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_234_PalindromeLinkedListTest {
	private val lcn = LC_234_PalindromeLinkedList()

	@ParameterizedTest
	@MethodSource
	fun test(input: Int, expected: Int) {
		assertThat(input).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(1, 1)
		)
	}
}