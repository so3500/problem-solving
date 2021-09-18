package leetcode;

/**
 * https://leetcode.com/problems/majority-element
 */
public class LC_169_MajorityElement {

	public int majorityElement(int[] nums) {
		return getMajorityElementWithBoyerMooreVoting(nums);
	}

	private int getMajorityElementWithHashMap(int[] nums) {
		return 0;
	}

	/**
	 * Boyer-Moore Voting Algorithm
	 *
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	private int getMajorityElementWithBoyerMooreVoting(int[] nums) {
		int count = 0;
		int majorityElement = 0;
		for (int n : nums) {
			if (count == 0) {
				majorityElement = n;
			}

			if (n == majorityElement) {
				count++;
			} else {
				count--;
			}
		}

		return majorityElement;
	}
}