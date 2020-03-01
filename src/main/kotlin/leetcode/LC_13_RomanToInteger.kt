package leetcode

class LC_13_RomanToInteger {

    private val romanMap = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
    )

    fun romanToInt(s: String): Int {
        var left = s[0]
        var sum = 0
        var idx = 1

        while (idx < s.length) {
            val right = s[idx]
            val leftNum = romanMap.getValue(left)
            val rightNum = romanMap.getValue(right)

            if (leftNum >= rightNum) {
                sum += leftNum
            } else {
                /**
                 * case like "IX"
                 * 1) sum -= 1
                 * 2) sum += 9
                 * 3) result: sum == 9
                 * */
                sum -= leftNum
            }

            left = right
            idx++
        }

        sum += romanMap.getValue(left)
        return sum
    }
}
