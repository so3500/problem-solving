package leetcode;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LC_26_RemoveDuplicatedFromSortedArrayTest {

	private final LC_26_RemoveDuplicatesFromSortedArray lc26 = new LC_26_RemoveDuplicatesFromSortedArray();
	private List<TestCase> testCases;

	@BeforeEach
	void setUp() {
		testCases = Arrays.asList(
			TestCase.create(new int[] {0}, "1, nums = [0]"),
			TestCase.create(new int[] {0, 0}, "1, nums = [0]"),
			TestCase.create(new int[] {1, 2}, "2, nums = [1,2]"),
			TestCase.create(new int[] {1, 1, 2}, "2, nums = [1,2]"),
			TestCase.create(new int[] {1, 2, 3}, "3, nums = [1,2,3]"),
			TestCase.create(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, "5, nums = [0,1,2,3,4]")
		);
	}

	@Test
	void removeDuplicates_usingMinElement() {
		testCases.forEach(tc -> {
			final int[] nums = tc.nums;
			final int length = lc26.removeDuplicates(nums);
			assertThat(getOutputStr(nums, length)).isEqualTo(tc.expectedOutput);
		});
	}

	@Test
	void removeDuplicated_moveElements() {
		testCases.forEach(tc -> {
			final int[] nums = tc.nums;
			final int length = lc26.removeDuplicates2(nums);
			assertThat(getOutputStr(nums, length)).isEqualTo(tc.expectedOutput);
		});
	}

	private static String getOutputStr(int[] nums, int length) {
		return String.format("%d, nums = [%s]",
			length,
			Arrays.stream(Arrays.copyOf(nums, length)).mapToObj(String::valueOf).collect(Collectors.joining(",")));
	}

	static class TestCase {
		int[] nums;
		String expectedOutput;

		public static TestCase create(int[] nums, String expectedOutput) {
			final TestCase tc = new TestCase();

			tc.nums = nums;
			tc.expectedOutput = expectedOutput;

			return tc;
		}
	}
}