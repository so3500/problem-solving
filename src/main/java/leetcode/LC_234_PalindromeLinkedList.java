package leetcode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * related topic: Linked List, Two Pointers, Stack, Recursion
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_234_PalindromeLinkedList {
	private Boolean palindrom;

	public boolean isPalindrome(ListNode head) {
		palindrom = null;

		checkIsPalindrome(head, head);

		return palindrom;
	}

	/**
	 * 1. tail 까지 들어간 뒤
	 * 2. head - tail 비교
	 * 3. 비교가 끝나면 head.next 와 tail.prev 비교 (tail.prev 는 이전 스택에서 접근가능)
	 */
	private ListNode checkIsPalindrome(ListNode left, ListNode right) {
		if (right == null) {
			return left;
		}

		left = checkIsPalindrome(left, right.next);

		// 판단이 끝나면 재귀 종료
		if (palindrom != null) {
			return null;
		}
		// 같은 객체이거나 엇갈리면 재귀 종료 - 팰린드롬 O
		if (left == right || right.next == left) {
			palindrom = true;
			return null;
		}
		// 값이 같으면 계속 조사
		if (left.val == right.val) {
			return left.next;
		}

		// 같이 다르므로 재귀 종료 - 팰린드롬 X
		palindrom = false;
		return null;
	}
}