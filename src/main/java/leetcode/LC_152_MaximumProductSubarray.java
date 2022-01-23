package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/#
 *
 * related topic: Array, Dynamic Programming
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * simple idea: 다 곱하면서 그 중 max 값 구하기
 * 그런데 음수를 곱하면서 부호가 바뀌면 min 값이 됨
 * 하지만 음수가 짝수개 있으면 상관없음
 * 음수가 홀수개 있을 때가 관건
 * 가능한 많이 곱하면서, 짝수개의 음수가 포함될 만큼 선택. 그 중에서 최대값 구하기
 */
public class LC_152_MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int ans = nums[0];
		int max = ans;
		int min = ans;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}

			max = Integer.max(nums[i], max * nums[i]);
			min = Integer.min(nums[i], min * nums[i]);
			ans = Integer.max(ans, max);
		}

		return ans;
	}
}