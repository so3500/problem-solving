package leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC_136_SingleNumberTest {

	LC_136_SingleNumber tc = new LC_136_SingleNumber();

	@Test
	void singleNumber() {
		assertThat(tc.singleNumber(new int[] {2, 2, 1})).isEqualTo(1);
		assertThat(tc.singleNumber(new int[] {2, 1, 2})).isEqualTo(1);
		assertThat(tc.singleNumber(new int[] {1, 2, 2})).isEqualTo(1);
		assertThat(tc.singleNumber(new int[] {4, 1, 2, 1, 2})).isEqualTo(4);
		assertThat(tc.singleNumber(new int[] {2})).isEqualTo(2);
		assertThat(tc.singleNumber(new int[] {-1})).isEqualTo(-1);
		assertThat(tc.singleNumber(new int[] {-1, -999, -999, -1, 33, 33, -5})).isEqualTo(-5);
	}
}