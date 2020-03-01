package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LC_455_AssignCookiesTest {

    LC_455_AssignCookies lc455;

    @BeforeEach
    void setUp() {
        lc455 = new LC_455_AssignCookies();
    }

    @Test
    void findContentChildren() {
        assertThat(lc455.findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 })).isEqualTo(1);
        assertThat(lc455.findContentChildren(new int[] { 3, 2, 1 }, new int[] { 1, 1 })).isEqualTo(1);

        assertThat(lc455.findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 })).isEqualTo(2);
        assertThat(lc455.findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 })).isEqualTo(2);

        assertThat(lc455.findContentChildren(new int[] { 1, 2 }, new int[] { 0, 0 })).isEqualTo(0);

        assertThat(lc455.findContentChildren(new int[] { 1, 100 }, new int[] { 2, 99 })).isEqualTo(1);
        assertThat(lc455.findContentChildren(new int[] { 100, 1 }, new int[] { 99, 2 })).isEqualTo(1);

        assertThat(lc455.findContentChildren(new int[] { 10, 9, 8, 7 }, new int[] { 5, 6, 7, 8 })).isEqualTo(2);
        assertThat(lc455.findContentChildren(new int[] { 7, 8, 9, 10 }, new int[] { 5, 6, 7, 8 })).isEqualTo(2);
    }
}
