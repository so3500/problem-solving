package leetcode;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * related topic: Array, Binary Search, Dynamic Programming
 * Time Complexity:
 * Space Complexity:
 */
public class LC_300_LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		return getByDP(nums);
	}

	/**
	 * Dynamic Programming
	 * Time O(N^2)
	 * Space O(N)
	 */
	private int getByDP(int[] nums) {
		// lis[i]: max length of subsequence when start from i
		int[] lis = new int[nums.length];

		int maxLen = 1;
		int i = nums.length - 1;
		while (i >= 0) {
			lis[i] = getMaxLengthAfter(nums, lis, i);
			maxLen = Integer.max(maxLen, lis[i]);
			i--;
		}

		return maxLen;
	}

	private int getMaxLengthAfter(int[] nums, int[] lis, int i) {
		int maxLen = 1;
		for (int k = i + 1; k < nums.length; k++) {
			if (nums[i] < nums[k]) {
				maxLen = Integer.max(maxLen, lis[k] + 1);
			}
		}
		return maxLen;
	}
}