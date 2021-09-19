package leetcode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class LC_215_KthLargestElementInAnArray {

	public int findKthLargest(int[] nums, int k) {
		return quickSelection(nums, k, 0, nums.length - 1);
	}

	/**
	 * QuickSelect
	 *
	 * Time complexity: Avg O(N), Worst O(N^2)
	 * Space complexity: O(1) in-place
	 */
	private int quickSelection(int[] nums, int k, int start, int end) {
		int pivotIndex = partition(nums, start, end);
		int kIndex = k - 1;

		int ret;
		if (kIndex < pivotIndex) {
			ret = quickSelection(nums, k, start, pivotIndex - 1);
		} else if (kIndex == pivotIndex) {
			ret = nums[pivotIndex];
		} else {
			ret = quickSelection(nums, k, pivotIndex + 1, end);
		}

		return ret;
	}

	private int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int pivotIndex = start - 1;

		for (int j = start; j <= end; j++) {
			// desc sorting
			if (nums[j] >= pivot) {
				pivotIndex++;
				swap(nums, pivotIndex, j);
			}
		}
		return pivotIndex;
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	/*
	// Divides array into two partitions
	algorithm partition(A, lo, hi) is
	  pivot := A[hi] // The pivot must be the last element

	  // Pivot index
	  i := lo - 1

	  for j := lo to hi do
		// If the current element is less than or equal to the pivot
		if A[j] <= pivot then
		  // Move the pivot index forward
		  i := i + 1

		  // Swap the current element with the element at the pivot
		  swap A[i] with A[j]
	  return i // the pivot index

	i: -1, j: 0
	1 10 1 6 3 8 7

	i: 0,  j:1
	1 10 1 6 3 8 7

	swap
	1 10 6 3 8 7

	i: 1, j: 2
	swap
	1 6 10 3 8 7

	iL 2, j: 3
	swap
	1 6 3 10 8 7

	i: 2, j: 4
	i: 3, j: 5
	swap
	1 6 3 7 8 10
	 */
}