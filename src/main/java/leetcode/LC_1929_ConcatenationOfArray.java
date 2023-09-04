package leetcode;

/**
 * <a href="https://leetcode.com/problems/concatenation-of-array">link</a>
 * related topic: Array
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LC_1929_ConcatenationOfArray {
	public int[] getConcatenation(int[] nums) {
		int[] ans = new int[nums.length * 2];
		int ansLeftIdx = 0;
		int ansRightIdx = nums.length;

		for (int num : nums) {
			ans[ansLeftIdx++] = num;
			ans[ansRightIdx++] = num;
		}

		return ans;
	}

	public int[] getConcatenation2(int[] nums) {
		int[] ans = new int[nums.length * 2];

		for (int i = 0; i < nums.length; i++) {
			ans[i] = nums[i];
			ans[i + nums.length] = nums[i];
		}

		return ans;
	}
}