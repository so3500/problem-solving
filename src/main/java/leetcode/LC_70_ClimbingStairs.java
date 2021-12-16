package leetcode;

/**
 * related topic: Math, Dynamic Programming, Memoization
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LC_70_ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}

		int[] stairs = new int[n + 1];
		stairs[0] = 0;
		stairs[1] = 1;
		stairs[2] = 2;

		for (int i = 3; i <= n; i++) {
			stairs[i] = stairs[i - 1] + stairs[i - 2];
		}

		return stairs[n];
	}
}