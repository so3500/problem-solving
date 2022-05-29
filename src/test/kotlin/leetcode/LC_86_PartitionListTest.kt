package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


/**
 * [1,4,3,2,5,2] 3
 * [2,1] 2
 */
class LC_86_PartitionListTest {
	private val lcn = LC_86_PartitionList()

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