package leetcode;

/**
 * https://leetcode.com/problems/search-insert-position/
 * related topic: Array, Binary Search
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */
public class LC_35_SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int insert = 0;
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			if (target < nums[left]) {
				insert = left;
				break;
			}
			if (nums[right] < target) {
				insert = right + 1;
				break;
			}

			// binary search
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] == target) {
				insert = mid;
				break;
			} else {
				right = mid - 1;
			}
		}

		return insert;
	}
}