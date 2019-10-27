package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_1_TwoSum {

    // Brute-force
    // Time complexity: O(N^2)
    // Space complexity: O(1)
//	public int[] twoSum(int[] nums, int target) {
//		for (int left = 0; left < nums.length; left++) {
//			for (int right = left + 1; right < nums.length; right++) {
//				if (nums[left] + nums[right] == target) {
//					return new int[]{left, right};
//				}
//			}
//		}
//		throw new IllegalArgumentException("No two sum solution");
//	}

    // Two-pass HashTable, O(N), O(N)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // One-pass HashTable, O(N), O(N)
    // TODO: think!

}
