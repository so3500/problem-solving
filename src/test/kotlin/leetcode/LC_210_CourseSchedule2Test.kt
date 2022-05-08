package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_210_CourseSchedule2Test {
	private val lcn = LC_210_CourseSchedule2()

	@ParameterizedTest
	@MethodSource
	fun test(numCourses: Int, prerequisites: Array<IntArray>, expected: IntArray) {
		assertThat(lcn.findOrder(numCourses, prerequisites)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(2, arrayOf(intArrayOf(1, 0)), intArrayOf(0, 1)),
			Arguments.of(4, arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2)), intArrayOf(0, 1, 2, 3)) // or 0, 2, 1, 3
		)
	}
}