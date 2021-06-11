package leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LC_7_ReverseIntegerTest {

    private LC_7_ReverseInteger lc7;

    @BeforeEach
    void setUp() {
        lc7 = new LC_7_ReverseInteger();
    }

    @Test
    void reverse() {
        assertThat(lc7.reverse(123)).isEqualTo(321);
        assertThat(lc7.reverse(-123)).isEqualTo(-321);
        assertThat(lc7.reverse(120)).isEqualTo(21);
        assertThat(lc7.reverse(1201)).isEqualTo(1021);

        assertThat(lc7.reverse(1)).isEqualTo(1);
        assertThat(lc7.reverse(-1)).isEqualTo(-1);

        assertThat(lc7.reverse(0)).isZero();
        assertThat(lc7.reverse(Integer.MIN_VALUE)).isZero();
        assertThat(lc7.reverse(Integer.MAX_VALUE)).isZero();
        assertThat(lc7.reverse(1234789999)).isZero();
        assertThat(lc7.reverse(-1234789999)).isZero();
    }
}
