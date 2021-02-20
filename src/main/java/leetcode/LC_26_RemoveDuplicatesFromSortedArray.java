package leetcode;

public class LC_26_RemoveDuplicatesFromSortedArray {

	/**
	 * nums 의 특성(오름차순 정렬)을 활용한다.
	 *
	 * time: O(N)
	 * space: O(1)
	 */
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

	/**
	 * 중복된 element 를 앞으로 위치시키고, 남은 공간은 유효하지 않은 값 {@link Integer.MAX_VALUE} 로 마킹한다.
	 *
	 * time: O(N^2)
	 * space: O(1)
	 */
	public static int removeDuplicates2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int distinctCount = 0;
		int duplicatedCount = 0;

		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (temp != nums[j]) {
					int duplicatedNum = j - i - 1;

					// 중복된 element 수 만큼 앞으로 당긴다.
					System.arraycopy(nums, j, nums, j - duplicatedNum, nums.length - j);

					// 뒤에서부터 j-i-1 개 칸 만큼 유효하지 않은 값으로 채우기
					duplicatedCount += j - i - 1;
					for (int r = nums.length - 1; r >= nums.length - duplicatedCount; r--) {
						nums[r] = Integer.MAX_VALUE;
					}

					distinctCount++;

					break;
				}
			}

		}

		if (duplicatedCount == 0) {
			distinctCount++;
		}

		return distinctCount;
	}
}
