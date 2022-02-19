package leetcode;

/**
 * related topic: Linked List, Math, Recursion
 * Time Complexity: O(max(M, N)) - M: l1 length, N: l2 length
 * Space Complexity: O(max(M, N)
 */
public class LC_2_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode node = head;

		int nextNum = 0;
		while (l1 != null && l2 != null) {
			node.next = new ListNode();
			node = node.next;

			int sum = l1.val + l2.val + nextNum;
			if (sum < 10) {
				node.val = sum;
				nextNum = 0;
			} else {
				node.val = sum % 10;
				nextNum = 1;
			}

			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1 != null) {
			addTwo(node, l1, nextNum);
		} else {
			addTwo(node, l2, nextNum);
		}

		return head.next;
	}

	private void addTwo(ListNode node, ListNode l, int nextNum) {

		while (l != null && nextNum == 1) {
			node.next = new ListNode();
			node = node.next;

			int sum = l.val + nextNum;

			if (sum < 10) {
				node.val = sum;
				nextNum = 0;
			} else {
				node.val = sum % 10;
				nextNum = 1;
			}

			l = l.next;
		}

		// 나머지 이어붙이기
		if (l != null) {
			node.next = l;
		}

		if (nextNum == 1) {
			node.next = new ListNode(1);
		}
	}
}