package leetcode;

/**
 * related topic: Array, Two Pointers, Dynamic Programming, Stack, Monotonic Stack
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * TODO runtime :200ms -> 20ms 미만으로 줄이기 (DP, Stack)
 *
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class LC_42_TrappingRainWater {
	public int trap(int[] height) {
		int totalTrappingWater = 0;

		for (int i = 0; i < height.length; i++) {
			int leftMax = findMax(height, 0, i);
			int rightMax = findMax(height, i, height.length - 1);

			totalTrappingWater += computeTrappingWater(height[i], leftMax, rightMax);
		}

		return totalTrappingWater;
	}

	private int computeTrappingWater(int currentHeight, int leftMax, int rightMax) {
		return Integer.min(leftMax, rightMax) - currentHeight;
	}

	private int findMax(int[] height, int from, int to) {
		int maxHeight = 0;
		for (int i = from; i <= to; i++) {
			maxHeight = Integer.max(height[i], maxHeight);
		}
		return maxHeight;
	}

}