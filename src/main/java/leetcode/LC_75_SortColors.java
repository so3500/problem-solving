package leetcode;

/**
 * related topic: Array, Two Pointers, Sorting
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * https://leetcode.com/problems/sort-colors/
 */
public class LC_75_SortColors {
	public void sortColors(int[] nums) {
		sortWithInplace(nums);
	}

	private void sortWithInplace(int[] nums) {
		int redIdx = 0;
		int whiteIdx = 0;
		int blueIdx = nums.length - 1;

		while (whiteIdx <= blueIdx) {
			if (nums[whiteIdx] == 0) {
				swap(nums, redIdx, whiteIdx);
				redIdx++;
				whiteIdx++;
			} else if (nums[whiteIdx] == 1) {
				whiteIdx++;
			} else if (nums[whiteIdx] == 2) {
				swap(nums, whiteIdx, blueIdx);
				blueIdx--;
			}
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}