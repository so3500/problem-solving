package leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class LC_206_ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		//		return reverseListWithIteratively(head);
		return reverseListWithRecursively(head);
	}

	private ListNode reverseListWithIteratively(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	private ListNode reverseListWithRecursively(ListNode cur) {
		if (cur == null || cur.next == null) {
			return cur;
		}

		ListNode p = reverseListWithRecursively(cur.next);
		cur.next.next = cur;
		cur.next = null;
		return p;
	}
}