package leetcode;

/**
 * related topic: Array, Binary Search, Divide and Conquer
 * Time Complexity: O(log(M+N))
 * Space Complexity: O(1)
 */
public class LC_4_MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums2.length < nums1.length) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int len1 = nums1.length;
		int len2 = nums2.length;
		int lo = 0;
		int hi = len1;

		while (lo <= hi) {
			int i = (lo + hi) / 2;
			int j = (len1 + len2 + 1) / 2 - i;

			int left1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
			int right1 = i == len1 ? Integer.MAX_VALUE : nums1[i];
			int left2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
			int right2 = j == len2 ? Integer.MAX_VALUE : nums2[j];

			if (left1 <= right2 && left2 <= right1) {
				if ((len1 + len2) % 2 == 0) {
					return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
				} else {
					return Math.max(left1, left2);
				}
			} else if (left1 > right2) {
				hi = i - 1;
			} else {
				lo = i + 1;
			}
		}
		return 0.0;
	}
}