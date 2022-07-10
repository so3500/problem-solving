package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_79_WordSearchTest {
    private val lcn = LC_79_WordSearch()

    @ParameterizedTest
    @MethodSource
    fun test(board: Array<CharArray>, word: String, expected: Boolean) {
        assertThat(lcn.exist(board, word)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
                Arguments.of(
                        arrayOf(
                                charArrayOf('A', 'B', 'C', 'E'),
                                charArrayOf('S', 'F', 'C', 'S'),
                                charArrayOf('A', 'D', 'E', 'E')
                        ), "ABCCED", true),
                Arguments.of(
                        arrayOf(
                                charArrayOf('A', 'B', 'C', 'E'),
                                charArrayOf('S', 'F', 'C', 'S'),
                                charArrayOf('A', 'D', 'E', 'E')
                        ), "SEE", true),
                Arguments.of(
                        arrayOf(
                                charArrayOf('A', 'B', 'C', 'E'),
                                charArrayOf('S', 'F', 'C', 'S'),
                                charArrayOf('A', 'D', 'E', 'E')
                        ), "ABCB", false)
        )
    }
}