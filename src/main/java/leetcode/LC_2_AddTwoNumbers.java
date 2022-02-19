package leetcode;

/**
 * related topic: Linked List, Math, Recursion
 * Time Complexity: O(max(M, N)) - M: l1 length, N: l2 length
 * Space Complexity: O(max(M, N)
 */
public class LC_2_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode current = head;
		ListNode p1 = l1;
		ListNode p2 = l2;

		int carry = 0; // 올림
		while (p1 != null || p2 != null) {
			current.next = new ListNode();
			current = current.next;

			int sum = carry;
			sum += p1 != null ? p1.val : 0;
			sum += p2 != null ? p2.val : 0;

			current.val = sum % 10;
			carry = sum / 10;

			p1 = p1 != null ? p1.next : null;
			p2 = p2 != null ? p2.next : null;
		}

		// 올림수가 있을 때
		if (carry == 1) {
			current.next = new ListNode(1);
		}

		return head.next;
	}
}