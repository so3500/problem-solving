package leetcode;

import java.util.Arrays;

/**
 * related topic: Array Tow Pointers, Binary Search, Sorting
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 */
public class LC_1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
	public int numSubseq(int[] nums, int target) {
		Arrays.sort(nums);

		int l = 0;
		int r = nums.length - 1;
		int answer = 0;
		int mod = (int)Math.pow(10, 9) + 7;
		int[] pow = calculatePow(nums.length, mod);

		while (l <= r) {
			if (nums[l] + nums[r] > target) {
				r--;
			} else {
				// nums[l] + nums[r] <= target 일때 subseq 에는 무조건 l이 들어가야 한다.
				// l+1, ..., r 범위에서 subseq 를 선택하는 경우의 수 = 2^(l-r)
				answer = (answer + pow[r - l] % mod) % mod;
				l++;
			}
		}

		return answer;
	}

	private int[] calculatePow(int n, int mod) {
		int[] pow = new int[n];
		pow[0] = 1;
		for (int i = 1; i < n; i++) {
			pow[i] = pow[i - 1] * 2 % mod;
		}
		return pow;
	}

}