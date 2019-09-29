package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LC_1_TwoSumTest {

	private LC_1_TwoSum lc1;

	@BeforeEach
	void beforeEach() {
		lc1 = new LC_1_TwoSum();

	}

	@Test
	void twoSum() {
		assertThat(lc1.twoSum(new int[]{2, 7, 11, 15}, 9)).isEqualTo(new int[]{0, 1});
		assertThat(lc1.twoSum(new int[]{2, 7, 11, 15}, 13)).isEqualTo(new int[]{0, 2});
		assertThat(lc1.twoSum(new int[]{2, 7, 11, 15}, 26)).isEqualTo(new int[]{2, 3});
	}
}
