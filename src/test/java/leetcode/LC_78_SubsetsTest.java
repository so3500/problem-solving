package leetcode;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class LC_78_SubsetsTest {

	private final LC_78_Subsets lc78 = new LC_78_Subsets();

	@Test
	void subsets() {
		assertThat(lc78.subsets(new int[] {})).containsExactlyInAnyOrder(Collections.emptyList());
		assertThat(lc78.subsets(new int[] {0})).containsExactlyInAnyOrder(Collections.emptyList(), Collections.singletonList(0));
		assertThat(lc78.subsets(new int[] {1, 2, 3})).containsExactlyInAnyOrder(
			Collections.emptyList(), Collections.singletonList(1), Collections.singletonList(2), Collections.singletonList(3),
			Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(2, 3), Arrays.asList(1, 2, 3));
	}
}