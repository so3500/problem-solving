package leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LC_189_RotateArrayTest {

	private LC_189_RotateArray lc189;

	@BeforeEach
	void setUp() {
		lc189 = new LC_189_RotateArray();
	}

	@Test
	void rotate_1_1() {

		// given
		int[] actual = {1, 2, 3, 4, 5, 6, 7};
		int[] expected = {5, 6, 7, 1, 2, 3, 4};

		// when
		lc189.rotate(actual, 3);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void rotate_1_2() {

		// given
		int[] actual = {1, 2, 3, 4, 5, 6, 7};
		int[] expected = {5, 6, 7, 1, 2, 3, 4};

		// when
		lc189.rotate(actual, 10);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void rotate_2() {

		// given
		int[] actual = {-1, -100, 3, 99};
		int[] expected = {3, 99, -1, -100};

		// when
		lc189.rotate(actual, 2);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void rotate_3() {

		// given
		int[] actual = {1};
		int[] expected = {1};

		// when
		lc189.rotate(actual, 2);

		// then
		assertThat(actual).isEqualTo(expected);
	}

}
