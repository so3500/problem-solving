package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LC_13_RomanToIntegerTest {

    private val romanToInteger: LC_13_RomanToInteger = LC_13_RomanToInteger()

    @Test
    fun romanToIntTest() {
        assertThat(romanToInteger.romanToInt("I")).isEqualTo(1)
        assertThat(romanToInteger.romanToInt("III")).isEqualTo(3)
        assertThat(romanToInteger.romanToInt("IV")).isEqualTo(4)
        assertThat(romanToInteger.romanToInt("VI")).isEqualTo(6)
        assertThat(romanToInteger.romanToInt("IX")).isEqualTo(9)
        assertThat(romanToInteger.romanToInt("XI")).isEqualTo(11)
        assertThat(romanToInteger.romanToInt("LVIII")).isEqualTo(58)
        assertThat(romanToInteger.romanToInt("XCIX")).isEqualTo(99)
        assertThat(romanToInteger.romanToInt("MMM")).isEqualTo(3000)
        assertThat(romanToInteger.romanToInt("MMMCMXCIX")).isEqualTo(3999)
    }
}