package leetcode;

/**
 * related topic: Array, Dynamic Programming
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_53_MaximumSubarray {
	/**
	 * sum: 현재 index 가 반영된 최대값
	 * maxSum: 전체 array 중 최대값
	 */
	public int maxSubArray(int[] nums) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int num : nums) {
			sum = Integer.max(sum + num, num);
			maxSum = Integer.max(maxSum, sum);
		}

		return maxSum;
	}
}