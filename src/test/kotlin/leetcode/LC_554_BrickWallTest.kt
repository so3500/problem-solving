package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_554_BrickWallTest {
    private val lcn = LC_554_BrickWall()

    @ParameterizedTest
    @MethodSource
    fun test(input: List<List<Int>>, expected: Int) {
        val leastBricks = lcn.leastBricks(input)

        assertThat(leastBricks).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
                Arguments.of(listOf(
                        listOf(1, 2, 2, 1),
                        listOf(3, 1, 2),
                        listOf(1, 3, 2),
                        listOf(2, 4),
                        listOf(3, 1, 2),
                        listOf(1, 3, 11)
                ), 2),
                Arguments.of(listOf(
                        listOf(1),
                        listOf(1),
                        listOf(1)
                ), 3)
        )
    }
}