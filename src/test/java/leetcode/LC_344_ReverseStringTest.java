package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC_344_ReverseStringTest {

    private LC_344_ReverseString lc344;

    @BeforeEach
    void setUp() {
        lc344 = new LC_344_ReverseString();
    }

    @Test
    void reverseString() {
        // given
        char[] tc1 = "hello".toCharArray();
        char[] tc1Reverse = "olleh".toCharArray();
        char[] tc2 = "Hannah".toCharArray();
        char[] tc2Reverse = "hannaH".toCharArray();

        // when
        lc344.reverseString(tc1);
        lc344.reverseString(tc2);

        // then
        assertThat(tc1).isEqualTo(tc1Reverse);
        assertThat(tc2).isEqualTo(tc2Reverse);
    }
}
