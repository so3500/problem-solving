package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * related topic: Array, Stack, Monotonic Stack
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LC_84_LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<Integer> indexStack = new Stack<>();

		for (int i = 0; i < heights.length; i++) {
			while (!indexStack.isEmpty() && heights[i] < heights[indexStack.peek()]) {
				int area = calculateArea(heights, indexStack, i);
				maxArea = Math.max(maxArea, area);
			}
			indexStack.push(i);
		}

		while (!indexStack.isEmpty()) {
			int area = calculateArea(heights, indexStack, heights.length);
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}

	private int calculateArea(int[] heights, Stack<Integer> indexStack, int index) {
		int popedIndex = indexStack.pop();
		int h = heights[popedIndex];
		int w = index - getLeftIndex(indexStack);
		return h * w;
	}

	/**
	 * stack is empty : 너비 시작점은 0
	 * stack is not empty : 너비 시작점은 아직 남은 element 의 index
	 *
	 * @return 너비 시작점
	 */
	private int getLeftIndex(Stack<Integer> indexStack) {
		return indexStack.isEmpty() ? 0 : indexStack.peek() + 1;
	}
}