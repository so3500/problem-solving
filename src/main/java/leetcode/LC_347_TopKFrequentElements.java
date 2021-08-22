package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class LC_347_TopKFrequentElements {

	/**
	 * Hash, Counting, Bucket
	 *
	 * Runtime: 10 ms, faster than 62.55% of Java online submissions for Top K Frequent Elements.
	 * Memory Usage: 41.7 MB, less than 42.94% of Java online submissions for Top K Frequent Elements.
	 */
	public int[] topKFrequent(int[] nums, int k) {
		/*
		key: number
		value: count of number in nums
		 */
		HashMap<Integer, Integer> frequentMap = new HashMap<>();
		for (int num : nums) {
			frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
		}

		/*
		index: count of num
		value: list of num
		 */
		List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
		for (int i = 0; i <= nums.length; i++) {
			buckets.add(new ArrayList<>());
		}

		for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
			int num = entry.getKey();
			int countOfNum = entry.getValue();

			buckets.get(countOfNum).add(num);
		}

		List<Integer> ret = new ArrayList<>(k);
		for (int i = buckets.size() - 1; i >= 0 && ret.size() < k; i--) {
			// if bucket[i] is not empty, then count of i is exist.
			if (!buckets.get(i).isEmpty()) {
				ret.addAll(buckets.get(i));
			}
		}

		return ret.stream().mapToInt(i -> i).toArray();
	}
}