package leetcode;

public class LC_136_SingleNumber {

	/**
	 * bit manipulation with XOR
	 * hint: a XOR b XOR c XOR b XOR a = c
	 */
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}
}