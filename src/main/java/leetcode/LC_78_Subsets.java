package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/subsets/
 */
public class LC_78_Subsets {

	private List<List<Integer>> ret;
	private boolean[] flags;
	private int[] nums;

	public List<List<Integer>> subsets(int[] nums) {
		ret = new ArrayList<>();
		this.nums = nums;
		flags = new boolean[nums.length];
		Set<Integer> subset = new HashSet<>();

		findAndAddSubsets(subset, 0);

		return ret;
	}

	private void findAndAddSubsets(Set<Integer> subset, int startIndex) {
		ret.add(new ArrayList<>(subset));

		for (int i = startIndex; i < nums.length; i++) {
			if (!flags[i]) {
				flags[i] = true;
				subset.add(nums[i]);

				findAndAddSubsets(subset, i);

				flags[i] = false;
				subset.remove(nums[i]);
			}
		}
	}
}