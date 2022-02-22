package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number
 *
 * related topic: Hash Table, Math, Two Pointers
 * Time Complexity: O(logN)
 * Space Complexity: O(logN)
 *
 * solutions: https://leetcode.com/problems/happy-number/solution/
 */
public class LC_202_HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while (!set.contains(n) && n != 1) {
			set.add(n);
			n = calculateNuxtSum(n);
		}

		return n == 1;
	}

	private int calculateNuxtSum(int n) {
		int ret = 0;

		while (n > 0) {
			ret += (int)Math.pow(n % 10, 2);
			n /= 10;
		}

		return ret;
	}
}