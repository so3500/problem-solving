package leetcode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Follow up: Could you do this in one pass? -> delay n steps
 * related topic: Two Pointers, Linked List
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_19_RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode();
		dummyHead.next = head;

		int delayCount = n;
		ListNode pointer = head;
		ListNode removePrevPointer = dummyHead;

		while (pointer != null) {
			if (delayCount-- <= 0) {
				removePrevPointer = removePrevPointer.next;
			}
			pointer = pointer.next;
		}

		if (dummyHead != removePrevPointer) {
			// remove target is not head
			removePrevPointer.next = removePrevPointer.next.next;
		} else {
			// remove target is head
			head = head.next;
		}

		return head;
	}
}