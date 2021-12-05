package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_17_LetterCombinationsOfaPhoneNumberTest {
	private val lc17 = LC_17_LetterCombinationsOfaPhoneNumber()

	@ParameterizedTest
	@MethodSource
	fun test(input: String, expected: Array<String>) {
		assertThat(lc17.letterCombinations(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(
				"23", arrayOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
				"", emptyArray<String>(),
				"2", arrayOf("a", "b", "c")
			))
	}
}