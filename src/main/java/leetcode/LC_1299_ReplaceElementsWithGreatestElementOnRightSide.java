package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 *
 * related topic: Array
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
public class LC_1299_ReplaceElementsWithGreatestElementOnRightSide {
	/**
	 * while pointer to lastIndex-1
	 * 		for index from pointer to lastIndex
	 * 			find max
	 *
	 * 		fill max arr[pointer : indexOfMax]
	 * 		pointer <- index of max
	 */
	public int[] replaceElements(int[] arr) {
		int pointer = 0;
		while (pointer < arr.length - 1) {
			int indexOfMax = 0;
			int max = 0;
			for (int i = pointer + 1; i < arr.length; i++) {
				if (arr[i] >= max) {
					max = arr[i];
					indexOfMax = i;
				}
			}

			Arrays.fill(arr, pointer, indexOfMax, max);
			pointer = indexOfMax;
		}

		arr[arr.length - 1] = -1;

		return arr;
	}
}