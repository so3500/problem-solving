package leetcode

/**
 * related topic: Array, Prefix Sum
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class LC_1480_RunningSumOf1DArray {
    fun runningSum(nums: IntArray): IntArray {
        for (i in 1 until nums.size) {
            nums[i] += nums[i - 1]
        }
        return nums
    }
}