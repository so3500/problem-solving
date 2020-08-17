package leetcode;

// https://leetcode.com/problems/rotate-array
public class LC_189_RotateArray {

	public void rotate(int[] nums, int k) {
		useReverse(nums, k);
	}

	// Using Cyclic Replacements

	// Using Extra Array
	// done.

	/***
	 * Using Reverse
	 * time: O(n)
	 * space: O(1)
	 */
	public void useReverse(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	/***
	 * Brute Force
	 * time: O(n*k)
	 * space: O(1). no extra space is used.
	 */
	public void bruteForce(int[] nums, int k) {
		int moveRightCount = k % nums.length;

		for (int i = 0; i < moveRightCount; i++) {
			moveRight(nums);
		}
	}

	private void moveRight(int[] nums) {
		int left = 0;
		int right = 1;
		int moveCount = 0;
		int leftTemp = nums[left];
		int rightTemp = nums[right];

		while (moveCount < nums.length) {
			nums[right] = leftTemp;
			left++;
			right = (right + 1) % nums.length;
			leftTemp = rightTemp;
			rightTemp = nums[right];

			moveCount++;
		}
	}
}
