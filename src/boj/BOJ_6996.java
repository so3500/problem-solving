/*
* 문제: 6996 애너그램
* problem-link: https://www.acmicpc.net/problem/6996
* solution-link: 
*/

package boj;

import java.util.Scanner;

public class BOJ_6996 {

	static class Solution {

		public void solve() {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			sc.nextLine();
			for (int tc = 0; tc < T; tc++) {
				String[] input = sc.nextLine().split(" ");
				String A = input[0];
				String B = input[1];
				if (isAnagram(A, B)) {
					System.out.println(String.format("%s & %s are anagrams.", A, B));
				} else {
					System.out.println(String.format("%s & %s are NOT anagrams.", A, B));
				}
			}
			sc.close();

		}

		private boolean isAnagram(String A, String B) {
			boolean ret = true;
			if (A.length() == B.length()) {
				int[] aChars = new int[26];
				int[] bChars = new int[26];
				int len = A.length();
				for (int idx = 0; idx < len; idx++) {
					aChars[A.charAt(idx) - 'a']++;
					bChars[B.charAt(idx) - 'a']++;
				}

				for (int idx = 0; idx < 26; idx++) {
					if (aChars[idx] != bChars[idx]) {
						ret = false;
						break;
					}
				}
			} else {
				ret = false;
			}
			return ret;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

}
