package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * related topic:
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_17_LetterCombinationsOfaPhoneNumber {
	Map<Character, List<Character>> mapping = Map.of(
		'2', List.of('a', 'b', 'c'),
		'3', List.of('d', 'e', 'f'),
		'4', List.of('g', 'h', 'i'),
		'5', List.of('j', 'k', 'l'),
		'6', List.of('m', 'n', 'o'),
		'7', List.of('p', 'q', 'r', 's'),
		'8', List.of('t', 'u', 'v'),
		'9', List.of('w', 'x', 'y', 'z')
	);

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

		List<Character> mappingLetters = mapping.get(digits.charAt(index));
		for (char mappingLetter : mappingLetters) {
			letterCombinations(digits, index + 1, answers, answer + mappingLetter);
		}
	}
}