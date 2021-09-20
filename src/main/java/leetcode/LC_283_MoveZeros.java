package leetcode;

import java.util.Arrays;

public class LC_283_MoveZeros {

	public void moveZeroes(int[] nums) {
		moveZeroes1(nums);
		//moveZeroes2(nums);
	}

	/**
	 * Time complexity: O(N) 최악의 경우에도 N번 연산
	 * Space complexity: O(1) in-place
	 */
	public void moveZeros3(int[] nums) {
		// TODO
	}

	/**
	 * Time complexity: O(N) 단. 최악의 경우 2N [0, 0, 0, 0, ..., 0]
	 * Space complexity: O(1) in-place
	 */
	public void moveZeroes1(int[] nums) {
		int position = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[position] = num;
				position++;
			}
		}

		Arrays.fill(nums, position, nums.length, 0);
	}

	/**
	 * Time complexity: O(N)
	 * Space complexity: O(1) in-place
	 */
	public void moveZeroes2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int nonZeroIndex = findNonZeroIndex(nums, i + 1);

				if (nonZeroIndex == nums.length) {
					break;
				}

				swap(nums, i, nonZeroIndex);
			}
		}
	}

	private int findNonZeroIndex(int[] nums, int start) {
		int nonZeroIndex = start;
		while (nonZeroIndex < nums.length) {
			if (nums[nonZeroIndex] != 0) {
				break;
			}
			nonZeroIndex++;
		}
		return nonZeroIndex;
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
