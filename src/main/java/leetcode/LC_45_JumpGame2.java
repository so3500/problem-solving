package leetcode;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * related topic: Array, Dynamic Programming, Greedy
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_45_JumpGame2 {
	public int jump(int[] nums) {
		int jumpCount = 0;
		int lastMaxJump = 0;
		int maxJump = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			maxJump = Integer.max(maxJump, i + nums[i]);
			if (i == lastMaxJump) {
				jumpCount++;
				lastMaxJump = maxJump;
			}
		}
		return jumpCount;
	}
}