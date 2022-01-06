package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_1299_ReplaceElementsWithGreatestElementOnRightSideTest {
	private val lc = LC_1299_ReplaceElementsWithGreatestElementOnRightSide()

	@ParameterizedTest
	@MethodSource
	fun test(input: IntArray, expected: IntArray) {
		assertThat(lc.replaceElements(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(17, 18, 5, 4, 6, 1), intArrayOf(18, 6, 6, 6, 1, -1)),
			Arguments.of(intArrayOf(17, 18, 19, 4, 6, 1), intArrayOf(19, 19, 6, 6, 1, -1)),
			Arguments.of(intArrayOf(20, 18, 19, 4, 6, 1), intArrayOf(19, 19, 6, 6, 1, -1)),
			Arguments.of(intArrayOf(3, 18, 19, 4, 6, 19, 1, 6), intArrayOf(19, 19, 19, 19, 19, 6, 6, -1)),
			Arguments.of(intArrayOf(5, 4, 3, 2, 1), intArrayOf(4, 3, 2, 1, -1)),
			Arguments.of(intArrayOf(400), intArrayOf(-1))
		)
	}
}