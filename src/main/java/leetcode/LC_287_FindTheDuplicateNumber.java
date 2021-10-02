package leetcode;

public class LC_287_FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		while (nums[0] != nums[nums[0]]) {
			swap(nums, 0, nums[0]);
		}
		return nums[0];
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}