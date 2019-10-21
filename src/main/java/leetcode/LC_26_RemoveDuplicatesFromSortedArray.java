package leetcode;

public class LC_26_RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int minNum = nums[0];
		int distinctCount = 1;
		int leftIdx = 0;

		for (int num : nums) {
			if (minNum < num) {
				leftIdx++;
				nums[leftIdx] = num;
				distinctCount++;
				minNum = num;
			}
		}
		return distinctCount;
	}
}
