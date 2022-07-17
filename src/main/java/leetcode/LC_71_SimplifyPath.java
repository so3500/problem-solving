package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import org.jetbrains.annotations.NotNull;

/**
 * https://leetcode.com/problems/simplify-path/
 * related topic: String, Stack
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LC_71_SimplifyPath {
	/**
	 * The path starts with a single slash '/'.
	 * Any two directories are separated by a single slash '/'.
	 * The path does not end with a trailing '/'.
	 * The path only contains the directories on the path from the root directory to the target file or directory(i.e., no period '.' or double period '..')
	 */
	public String simplifyPath(String path) {
		String[] splitPaths = splitPath(path);
		Deque<String> deque = new ArrayDeque<>(splitPaths.length);

		createPathDeque(splitPaths, deque);
		return getCanonicalPath(deque);
	}

	/**
	 * @param path /abc/./b23/../../c/
	 * @return 'abc' '.' 'b23' '..' '..' 'c' ''
	 */
	private String[] splitPath(String path) {
		return path.split("/");
	}

	private void createPathDeque(String[] splitPaths, Deque<String> deque) {
		for (String splitPath : splitPaths) {
			if (splitPath.equals("..")) {
				if (!deque.isEmpty()) {
					deque.pollLast();
				}
			} else if (!splitPath.isEmpty() && !splitPath.equals(".")) {
				deque.add(splitPath);
			}
		}
	}

	private String getCanonicalPath(Deque<String> deque) {
		if (deque.isEmpty()) {
			return "/";
		}

		StringBuilder canonicalPath = new StringBuilder(deque.size());
		while (!deque.isEmpty()) {
			String p = deque.poll();
			canonicalPath.append("/").append(p);
		}
		return canonicalPath.toString();
	}
}