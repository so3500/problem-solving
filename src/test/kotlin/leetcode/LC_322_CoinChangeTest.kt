package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_322_CoinChangeTest {
	private val lcn = LC_322_CoinChange()

	@ParameterizedTest
	@MethodSource
	fun test(coins: IntArray, amount: Int, output: Int) {
		assertThat(lcn.coinChange(coins, amount)).isEqualTo(output)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(intArrayOf(1, 2, 5), 11, 3),
			Arguments.of(intArrayOf(2), 3, -1),
			Arguments.of(intArrayOf(1), 0, 0),
			Arguments.of(intArrayOf(2), 1, -1),
			Arguments.of(intArrayOf(186, 419, 83, 408), 6249, 20)
		)
	}
}