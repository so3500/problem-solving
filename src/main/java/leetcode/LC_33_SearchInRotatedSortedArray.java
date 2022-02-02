package leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * related topic: Array, Binary Search
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 *
 */
public class LC_33_SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		return findTarget(nums, target);
	}

	/**
	 * circular array 를 고려하여 search
	 *
	 * Time Complexity: O(logN)
	 * Space Complexity: O(1)
	 *
	 * https://leetcode.com/submissions/detail/632793419/
	 *
	 * target: 9
	 * 0 1 2 3 4 5 6 7 8 9
	 * 6 7 8 9 0 1 2 3 4 5
	 * l       m         r
	 * l  m  r
	 *
	 * target: 3
	 * 0 1 2 3 4 5 6 7 8 9
	 * 6 7 8 9 0 1 2 3 4 5
	 * l       m         r
	 *           l   m   r
	 */
	private int findTarget(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		int targetIndex = -1;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				targetIndex = mid;
				break;
			}

			if (isSorted(nums, left, mid)) {
				if (nums[left] <= target && target <= nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[left] > target && nums[mid] < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

		}

		return targetIndex;
	}

	private boolean isSorted(int[] nums, int i, int j) {
		return nums[i] <= nums[j];
	}

	/**
	 * circular array 가 아닌 가상의 0부터 시작하는 array 로 생각. 실제 값 비교시에만 보정된 인덱스 사용 (pass) - 보정수 찾는 과정이 O(N)
	 *
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 */
	private int findTarget2(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int cNum = findCalibratedNum(nums);

		int targetIndex = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int cMid = calibrate(nums, mid, cNum);

			if (nums[cMid] > target) {
				end = mid - 1;
			} else if (nums[cMid] < target) {
				start = mid + 1;
			} else {
				targetIndex = cMid;
				break;
			}
		}

		return targetIndex;
	}

	private int calibrate(int[] nums, int origin, int calibratedNum) {
		return (origin + calibratedNum) % nums.length;
	}

	private int findCalibratedNum(int[] nums) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
				minIndex = i;
			}
		}

		return minIndex;
	}
}