package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_49_GroupAnagrams {

	/**
	 * Related Topics: Hash Table, String, Sorting
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> ret = new HashMap<>();

		for (String str : strs) {
			String sortedString = getSortedString(str);

			ret.computeIfAbsent(sortedString, key -> new ArrayList<>());
			ret.get(sortedString).add(str);
		}

		return new ArrayList<>(ret.values());
	}

	private String getSortedString(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}