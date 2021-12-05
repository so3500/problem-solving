package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * related topic: Hash Table, String, Backtracking
 * Time Complexity: O(N * 4^N) TODO
 * Space Complexity: O(1)
 */
public class LC_17_LetterCombinationsOfaPhoneNumber {
	String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return Collections.emptyList();
		}

		List<String> letters = new ArrayList<>();
		letterCombinations(digits, 0, letters, "");
		return letters;
	}

	private void letterCombinations(String digits, int index, List<String> answers, String answer) {
		if (index == digits.length()) {
			answers.add(answer);
			return;
		}

		String mappingLetters = mapping[digits.charAt(index) - '0'];
		for (int i = 0; i < mappingLetters.length(); i++) {
			char mappingLetter = mappingLetters.charAt(i);
			letterCombinations(digits, index + 1, answers, answer + mappingLetter);
		}
	}
}