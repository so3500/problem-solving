package leetcode;

/**
 * <a href="https://leetcode.com/problems/build-array-from-permutation">link</a>
 * related topic: Array, Simulation, Bit, Euclidean Algorithm
 * Time Complexity: O(N)
 * Space Complexity: O(N) or O(1)
 */
public class LC_1920_BuildArrayFromPermutation {
	public int[] buildArray(int[] nums) {
		return buildArrayWithoutExtraSpaceByBit(nums);
	}

	private int[] buildArrayWithExtraSpace(int[] nums) {
		int[] ans = new int[nums.length];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = nums[nums[i]];
		}

		return ans;
	}

	/**
	 * nums[i] 값 범위가 0 부터 1000 까지이므로 최대 10개의 bit만 사용한다. (1111101000)
	 * 1. 32bit 인 int 형 변수가 있을 때 새 값을 11번째부터 20번째 bit에 저장함으로써 new value 와 old value 를 하나의 변수에 저장할 수 있다.
	 * 2.  bit 이동을 통해 old value 를 지우면서 new value 만 남긴다.
	 */
	private int[] buildArrayWithoutExtraSpaceByBit(int[] nums) {
		int mask = 1023; // 1111111111 10bit

		// store new value in one variable
		// new value bit(left 10bit) + old value bit(right 10bit)
		for (int i = 0; i < nums.length; i++) {
			int temp = (nums[nums[i]] & mask) << 10;
			nums[i] |= temp;
		}

		// remove old value by shift to right
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] >> 10;
		}

		return nums;
	}
}