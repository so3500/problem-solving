package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/group-anagrams/
 * related topic: Hash Table, String, Sorting
 *
 * N : number of str
 * Time Complexity: O(N) - loop N str O(N) + map put O(1) + map get O(1)
 * Space Complexity: O(N) - store N str in map value O(N)
 */
public class LC_49_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			String key = sort(str);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(str);
		}

		return new ArrayList<>(map.values());
	}

	/**
	 * runtime: 10~20ms
	 */
	private String sort(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	/**
	 * runtime: 108ms
	 */
	private String sortByStream(String str) {
		return Stream.of(str.split(""))
			.sorted()
			.collect(Collectors.joining());
	}

}