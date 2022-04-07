package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * related topic: Array, Queue, Sliding Window, Heap(Priority Queue), Monotonic Queue
 * Time Complexity: O(N)
 * Space Complexity: O(N) : (N-K) + K -> N-K : result size, K : window size
 */
public class LC_239_SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();

		// first element of deq is always max number in window.
		Deque<Integer> deq = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			removeOutWindow(deq, i, k);
			removeSmallNumsInWindow(nums, deq, i);
			deq.addLast(i);
			addMaxNumInWindowToResult(nums, deq, i, k, result);
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	private void removeOutWindow(Deque<Integer> indexDeq, int i, int k) {
		int windowStart = i - k + 1;
		while (!indexDeq.isEmpty() && indexDeq.peekFirst() < windowStart) {
			indexDeq.removeFirst();
		}
	}

	private void removeSmallNumsInWindow(int[] nums, Deque<Integer> indexDeq, int i) {
		while (!indexDeq.isEmpty() && nums[i] >= nums[indexDeq.peekLast()]) {
			indexDeq.removeLast();
		}
	}

	private void addMaxNumInWindowToResult(int[] nums, Deque<Integer> indexDeq, int i, int k, List<Integer> result) {
		if (i >= k - 1) {
			result.add(nums[indexDeq.peekFirst()]);
		}
	}
}