package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_1498_NumberOfSubsequencesThatSatisfyTheGivenSumConditionTest {
    private val lcn = LC_1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition()

    @ParameterizedTest
    @MethodSource
    fun test(nums: IntArray, target: Int, answer: Int) {
        assertThat(lcn.numSubseq(nums, target)).isEqualTo(answer)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
            Arguments.of(intArrayOf(3, 5, 6, 7), 9, 4),
            Arguments.of(intArrayOf(3, 3, 6, 8), 10, 6),
            Arguments.of(intArrayOf(2, 3, 3, 4, 6, 7), 12, 61),
            Arguments.of(intArrayOf(14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14), 22, 272187084
            )
        )
    }
}