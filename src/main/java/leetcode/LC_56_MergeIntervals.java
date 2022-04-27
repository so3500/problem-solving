package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/merge-intervals/
 * related topic: Array, Sorting
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 */
public class LC_56_MergeIntervals {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		LinkedList<int[]> list = new LinkedList<>();
		mergeIntervals(intervals, list);
		return getMergedIntervals(list);
	}

	private void mergeIntervals(int[][] intervals, LinkedList<int[]> list) {
		for (int[] interval : intervals) {
			if (list.isEmpty() || list.getLast()[1] < interval[0]) {
				// non-overlapping
				list.add(interval);
			} else {
				// overlapping
				list.getLast()[1] = Integer.max(list.getLast()[1], interval[1]);
			}
		}
	}

	private int[][] getMergedIntervals(LinkedList<int[]> list) {
		return list.toArray(new int[list.size()][]);
	}
}