package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LC_295_FindMedianFromDataStreamTest {
	private val lc295 = LC_295_FindMedianFromDataStream()

	@Test
	fun test() {
		val finder = lc295.MedianFinder()

		finder.addNum(6)
		assertThat(finder.findMedian()).isEqualTo(6.00000)

		finder.addNum(10)
		assertThat(finder.findMedian()).isEqualTo(8.00000)

		finder.addNum(2)
		assertThat(finder.findMedian()).isEqualTo(6.00000)

		finder.addNum(6)
		assertThat(finder.findMedian()).isEqualTo(6.00000)

		finder.addNum(5)
		assertThat(finder.findMedian()).isEqualTo(6.00000)
	}

	@Test
	fun test2() {
		val finder = lc295.MedianFinder()

		finder.addNum(1)
		finder.addNum(5)
		finder.addNum(6)
		finder.addNum(10)
		finder.addNum(11)
		finder.addNum(11)
		finder.addNum(12)
		finder.addNum(13)
		finder.addNum(15)
		finder.addNum(17)
		
		assertThat(finder.findMedian()).isEqualTo(11.00000)
	}
}