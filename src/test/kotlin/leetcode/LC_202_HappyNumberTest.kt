package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_202_HappyNumberTest {
	private val lcn = LC_202_HappyNumber()

	@ParameterizedTest
	@MethodSource
	fun test(input: Int, expected: Boolean) {
		assertThat(lcn.isHappy(input)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(1, true),
			Arguments.of(2, false),
			Arguments.of(3, false),
			Arguments.of(4, false),
			Arguments.of(5, false),
			Arguments.of(6, false),
			Arguments.of(8, false),
			Arguments.of(9, false),
			Arguments.of(10, true),
			Arguments.of(19, true),
			Arguments.of(435754, false)
		)
	}
}