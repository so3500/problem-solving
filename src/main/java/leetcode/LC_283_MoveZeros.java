package leetcode;

import java.util.Arrays;

public class LC_283_MoveZeros {

    public void moveZeroes(int[] nums) {
        int position = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[position] = num;
                position++;
            }
        }

        Arrays.fill(nums, position, nums.length, 0);
    }
}
