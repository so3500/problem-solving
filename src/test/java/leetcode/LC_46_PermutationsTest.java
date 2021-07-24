package leetcode;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LC_46_PermutationsTest {

	LC_46_Permutations lc46 = new LC_46_Permutations();

	@Test
	void permute() {
		assertThat(lc46.permute(new int[] {1, 2})).containsExactlyInAnyOrder(list(1, 2), list(2, 1));

		assertThat(lc46.permute(new int[] {1, 2, 3})).containsExactlyInAnyOrder(
			list(1, 2, 3), list(1, 3, 2), list(2, 1, 3), list(2, 3, 1), list(3, 1, 2), list(3, 2, 1)
		);
	}

	private static List<Integer> list(Integer... args) {
		return Arrays.asList(args);
	}
}