package leetcode;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class LC_238_ProductOfArrayExceptSelf {

	/**
	 * @return output[i]: nums[i] 를 제외한 nums[0], ..., nums[i] 를 모두 곱한 값
	 *
	 * 제약사항
	 * - output 외 O(1) 공간만 사용할 것
	 * - 나누기 연산을 사용하지 말 것
	 *
	 * Related Topics: Prefix Sum
	 *
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
	 * Memory Usage: 49.4 MB, less than 85.68% of Java online submissions for Product of Array Except Self.
	 */
	public int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];

		// 구간곱
		output[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			output[i] = output[i - 1] * nums[i - 1];
		}

		int prefixProductFromEnd = 1; // 마지막 인덱스로부터의 구간곱
		for (int i = nums.length - 1; i >= 0; i--) {
			output[i] *= prefixProductFromEnd;
			prefixProductFromEnd *= nums[i];
		}

		return output;
	}
}
