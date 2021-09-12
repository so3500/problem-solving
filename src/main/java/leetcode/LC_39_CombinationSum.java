package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_39_CombinationSum {

	private List<List<Integer>> ret;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ret = new ArrayList<>();
		combinationSum(candidates, target, new ArrayList<>(), 0, 0);
		return ret;
	}

	/**
	 * Related Topics: Array, Backtracking
	 */
	private void combinationSum(int[] candidates, int target, List<Integer> combinations, int combinationSum, int currentIndex) {
		if (currentIndex == candidates.length || target < combinationSum) {
			return;
		}

		if (target == combinationSum + candidates[currentIndex]) {
			combinations.add(candidates[currentIndex]);
			ret.add(new ArrayList<>(combinations));
			combinations.remove(combinations.size() - 1);
		} else if (target >= combinationSum + candidates[currentIndex]) {
			combinations.add(candidates[currentIndex]);
			combinationSum(candidates, target, combinations, combinationSum + candidates[currentIndex], currentIndex);
			combinations.remove(combinations.size() - 1);
		}

		combinationSum(candidates, target, combinations, combinationSum, currentIndex + 1);
	}
}