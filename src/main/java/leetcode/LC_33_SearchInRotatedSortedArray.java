package leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * related topic: Array, Binaray Search
 * Time Complexity: O(N) =>
 * Space Complexity: O(1)
 *
 * 접근방법1. circular array 를 고려하여 index 계산. 탈출조건 복잡 (fail)
 * 접근방법2. circular array 가 아닌 가상의 0부터 시작하는 array 로 생각. 실제 값 비교시에만 보정된 인덱스 사용 (pass) - TODO 보정수 찾는 과정이 O(N). O(logN) 방법 찾기
 */
public class LC_33_SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		return findTarget(nums, target);
	}

	private int findTarget(int[] nums, int target) {
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