package leetcode;

/**
 * related topic: Array, Two Pointers, Greedy
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * https://leetcode.com/problems/container-with-most-water/
 */
public class LC_11_ContainerWithMostWater {
	public int maxArea(int[] height) {
		int leftIdx = 0;
		int rightIdx = height.length - 1;
		int maxArea = 0;

		while (leftIdx < rightIdx) {
			maxArea = Integer.max(maxArea, calculateMaxArea(height, leftIdx, rightIdx));

			// 길이가 짧은 막대의 위치에서, 좀 더 긴 막대 위치를 찾아 이동
			if (height[leftIdx] <= height[rightIdx]) {
				leftIdx = moveLeftToRight(height, leftIdx);
			} else {
				rightIdx = moveRightToLeft(height, rightIdx);
			}
		}

		return maxArea;
	}

	private static int calculateMaxArea(int[] height, int leftIdx, int rightIdx) {
		int w = rightIdx - leftIdx;
		int h = Integer.min(height[leftIdx], height[rightIdx]);
		return w * h;
	}

	private static int moveLeftToRight(int[] height, int leftIdx) {
		int beforeHeight = height[leftIdx];
		while (leftIdx < height.length) {
			if (beforeHeight < height[leftIdx]) {
				break;
			}
			leftIdx++;
		}
		return leftIdx;
	}

	private static int moveRightToLeft(int[] height, int rightIdx) {
		int beforeHeight = height[rightIdx];
		while (rightIdx >= 0) {
			if (beforeHeight < height[rightIdx]) {
				break;
			}
			rightIdx--;
		}
		return rightIdx;
	}
}