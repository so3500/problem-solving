package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class LC_46_Permutations {

	private List<List<Integer>> permutations;
	private boolean[] numFlag;

	public List<List<Integer>> permute(int[] nums) {
		permutations = new ArrayList<>(new ArrayList<>());
		numFlag = new boolean[nums.length];

		Deque<Integer> d = new LinkedList<>();
		makePermutations(nums, d);

		return permutations;
	}

	private void makePermutations(int[] nums, Deque<Integer> selectedNums) {
		for (int i = 0; i < nums.length; i++) {
			if (numFlag[i]) {
				continue;
			}

			numFlag[i] = true;
			selectedNums.add(nums[i]);
			if (selectedNums.size() == numFlag.length) {
				permutations.add(new ArrayList<>(selectedNums));
			}

			makePermutations(nums, selectedNums);

			numFlag[i] = false;
			selectedNums.pollLast();
		}
	}

}