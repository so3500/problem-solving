package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/5264d2b162488dc400000001/train/java
 */
public class SpinWords {
	private static final String WORD_DELIMITER = " ";

	public String spinWords(String sentence) {
		return Arrays.stream(sentence.split(WORD_DELIMITER))
			.map(SpinWords::spinIfNecessary)
			.collect(Collectors.joining(WORD_DELIMITER));
	}

	private static String spinIfNecessary(String word) {
		return isSpinAble(word) ? new StringBuilder(word).reverse().toString() : word;
	}

	private static boolean isSpinAble(String word) {
		return word.length() >= 5;
	}
}