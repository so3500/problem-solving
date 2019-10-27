package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LC_345_ReverseVowelsOfAStringTest {

    private LC_345_ReverseVowelsOfAString lc345;

    @BeforeEach
    void setUp() {
        lc345 = new LC_345_ReverseVowelsOfAString();
    }

    @Test
    void reverseVowels() {
        assertThat(lc345.reverseVowels("hello")).isEqualTo("holle");
        assertThat(lc345.reverseVowels("leetcode")).isEqualTo("leotcede");
        assertThat(lc345.reverseVowels("aA")).isEqualTo("Aa");
    }
}
