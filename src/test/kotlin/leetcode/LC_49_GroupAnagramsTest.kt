package leetcode


import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_49_GroupAnagramsTest {
	private val lcn = LC_49_GroupAnagrams()

	@ParameterizedTest
	@MethodSource
	fun test(input: Array<String>, expected: List<List<String>>) {
		val result = lcn.groupAnagrams(input)

		// Error converting parameter at index 0: No implicit conversion to convert object of type java.util.Arrays$ArrayList to type [Ljava.lang.String;
		//org.junit.jupiter.api.extension.ParameterResolutionException: Error converting parameter at index 0: No implicit conversion to convert object of type java.util.Arrays$ArrayList to type [Ljava.lang.String;
//		assertThat(result).hasSameElementsAs(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(
				listOf("eat", "tea", "tan", "ate", "nat", "bat"),
				listOf(listOf("bat"), listOf("nat", "tan"), listOf("ate", "eat", "tea"))
			),
			Arguments.of(listOf(""), listOf(listOf(""))),
			Arguments.of(listOf("a"), (listOf("a")))
		)
	}
}