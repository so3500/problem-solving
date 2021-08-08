package leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC_22_GenerateParenthesesTest {

	private final LC_22_GenerateParentheses lc22 = new LC_22_GenerateParentheses();

	@Test
	void generateParenthesis() {
		assertThat(lc22.generateParenthesis(1)).containsExactlyInAnyOrder("()");
		assertThat(lc22.generateParenthesis(2)).containsExactlyInAnyOrder("(())", "()()");
		assertThat(lc22.generateParenthesis(3)).containsExactlyInAnyOrder("((()))", "(()())", "(())()", "()(())", "()()()");
	}
}