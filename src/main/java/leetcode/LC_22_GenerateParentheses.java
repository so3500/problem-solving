package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class LC_22_GenerateParentheses {

	List<String> ret;
	StringBuilder out;

	public List<String> generateParenthesis(int n) {
		ret = new ArrayList<>();
		out = new StringBuilder(n * 2);

		generateParenthesisWithBackTracking(0, 0, n);

		return ret;
	}

	private void generateParenthesisWithBackTracking(int openCnt, int closeCnt, int maxCnt) {
		if (out.length() == maxCnt * 2) {
			ret.add(out.toString());
			return;
		}

		if (openCnt < maxCnt) {
			out.append('(');
			generateParenthesisWithBackTracking(openCnt + 1, closeCnt, maxCnt);
			out.deleteCharAt(out.length() - 1);
		}
		if (closeCnt < openCnt) {
			out.append(')');
			generateParenthesisWithBackTracking(openCnt, closeCnt + 1, maxCnt);
			out.deleteCharAt(out.length() - 1);
		}
	}
}