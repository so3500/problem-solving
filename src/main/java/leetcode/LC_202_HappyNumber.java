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
		int sum = n;
		boolean isHappyNumber = false;

		while (!set.contains(sum)) {
			set.add(sum);
			sum = calculateNuxtSum(sum);

			if (sum == 1) {
				isHappyNumber = true;
				break;
			}
		}

		return isHappyNumber;
	}

	private int calculateNuxtSum(int sum) {
		int ret = 0;

		while (sum > 0) {
			ret += (int)Math.pow(sum % 10, 2);
			sum /= 10;
		}

		return ret;
	}
}