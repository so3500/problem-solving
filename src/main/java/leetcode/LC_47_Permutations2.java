package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO: faster
 * https://leetcode.com/problems/permutations-ii/
 * related topic: Array, Backtracking
 * Time Complexity: O(?)
 * Space Complexity: O(N)
 */
public class LC_47_Permutations2 {
	private Set<List<Integer>> ret;
	private boolean[] used;
	private int n;
	private List<Integer> permutation;

	public List<List<Integer>> permuteUnique(int[] nums) {
		ret = new HashSet<>();
		n = nums.length;
		used = new boolean[n];
		permutation = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			permute(nums, i, 0);
		}

		return new ArrayList<>(ret);
	}

	private void permute(int[] nums, int i, int pLen) {
		if (pLen == n) {
			ret.add(new ArrayList<>(permutation));
			return;
		}
		if (i >= n || used[i]) {
			return;
		}

		used[i] = true;
		permutation.add(nums[i]);
		for (int j = 0; j < n; j++) {
			permute(nums, j, pLen + 1);
		}
		permutation.remove(permutation.size() - 1);
		used[i] = false;
	}
}
