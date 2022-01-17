package leetcode;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * related topic: Array, Two Pointers, Binary Search
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_167_TwoSumII_InputArrayIsSorted {
	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		int[] ret;

		while (true) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				ret = createResult(left, right);
				break;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}

		return ret;
	}

	private int[] createResult(int left, int right) {
		return new int[] {left + 1, right + 1};
	}
}