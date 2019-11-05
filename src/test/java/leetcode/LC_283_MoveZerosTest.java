package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LC_283_MoveZerosTest {
    private LC_283_MoveZeros lc283;

    @BeforeEach
    void setUp() {
        lc283 = new LC_283_MoveZeros();
    }

    @Test
    void moveZeros() {
        final int[] tc1 = { 0, 1, 0, 3, 12 };
        lc283.moveZeroes(tc1);
        assertThat(tc1).isEqualTo(new int[] { 1, 3, 12, 0, 0 });

        final int[] tc2 = { 0, 0, 0, 3, 12, 123 };
        lc283.moveZeroes(tc2);
        assertThat(tc2).isEqualTo(new int[] { 3, 12, 123, 0, 0, 0 });
    }
}
