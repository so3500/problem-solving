package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_207_CourseScheduleTest {
	private val lcn = LC_207_CourseSchedule()

	@ParameterizedTest
	@MethodSource
	fun test(numCourses: Int, prerequisites: Array<IntArray>, expected: Boolean) {
		assertThat(lcn.canFinish(numCourses, prerequisites)).isEqualTo(expected)
	}

	companion object {
		@JvmStatic
		private fun test() = listOf(
			Arguments.of(2, arrayOf(intArrayOf(1, 0)), true),
			Arguments.of(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)), false),
			Arguments.of(4, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(2, 3)), false)
		)
	}
}