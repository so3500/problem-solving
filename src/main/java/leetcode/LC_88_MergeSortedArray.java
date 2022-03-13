package leetcode;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * related topic: Array, Two Pointers, Sorting
 * Time Complexity: O(M+N)
 * Space Complexity: O(1)
 */
public class LC_88_MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int insert = nums1.length - 1;

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[insert--] = nums1[i--];
			} else {
				nums1[insert--] = nums2[j--];
			}
		}

		while (j >= 0) {
			nums1[insert--] = nums2[j--];
		}
	}
}