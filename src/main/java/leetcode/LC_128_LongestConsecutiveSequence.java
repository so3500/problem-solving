package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * related topic: Array, Hash Table, Union Find
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_128_LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = initSet(nums);

		int maxLength = 0;
		for (int num : nums) {
			// 각 consecutive sequence 중 가장 작은 수에서 시작하도록 보장
			if (set.contains(num - 1)) {
				continue;
			}

			if (set.contains(num)) {
				int nextNum = num + 1;
				int length = 1;

				while (set.contains(nextNum)) {
					set.remove(nextNum); // optimization (한번 탐색한 수는 더 이상 필요없음)

					nextNum++;
					length++;
				}

				maxLength = Integer.max(maxLength, length);
				set.remove(num); // optimization (한번 탐색한 수는 더 이상 필요없음)
			}
		}

		return maxLength;
	}

	private Set<Integer> initSet(int[] nums) {
		return Arrays.stream(nums).boxed().collect(Collectors.toSet());
	}
}