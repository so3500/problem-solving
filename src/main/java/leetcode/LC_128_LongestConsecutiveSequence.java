package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * related topic: Array, Hash Table, Union Find
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_128_LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (int num : nums) {
			set.add(num);
		}

		int maxLength = 0;
		for (int num : nums) {
			int length = 0;
			if (set.contains(num)) {
				length++;
				length += findLeft(set, num - 1);
				length += findRight(set, num + 1);
			}
			maxLength = Integer.max(maxLength, length);
			set.remove(num);
		}

		return maxLength;
	}

	private int findRight(Set<Integer> set, int i) {
		int ret = 0;

		if (set.contains(i)) {
			ret = 1;
			ret += findRight(set, i + 1);
		}
		set.remove(i);

		return ret;
	}

	private int findLeft(Set<Integer> set, int i) {
		int ret = 0;

		if (set.contains(i)) {
			ret = 1;
			ret += findLeft(set, i - 1);
		}
		set.remove(i);

		return ret;
	}
}