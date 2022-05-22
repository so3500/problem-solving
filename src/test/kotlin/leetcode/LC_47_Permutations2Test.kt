package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_47_Permutations2Test {
	private val lcn = LC_47_Permutations2()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, expected: List<List<Int>>) {
		val permutations = lcn.permuteUnique(input)

		assertThat(permutations).containsExactlyInAnyOrderElementsOf(expected)

	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(1, 1, 2), listOf(listOf(1, 1, 2), listOf(1, 2, 1), listOf(2, 1, 1))),
			Arguments.of(intArrayOf(1, 2, 3), listOf(listOf(1, 2, 3), listOf(1, 3, 2), listOf(2, 1, 3), listOf(2, 3, 1), listOf(3, 1, 2), listOf(3, 2, 1)))
		)
	}
}
