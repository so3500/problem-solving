package leetcode;

/**
 * https://leetcode.com/problems/rotate-list/
 *
 * related topic: Linked List, Tow Pointers
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_61_RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}

		ListNode oldHead;
		ListNode oldTail;

		int size = getListLength(head);
		oldHead = head;
		oldTail = getTailPointer(head);

		int count = size - (k % size);
		if (count == size) {
			return head;
		}

		ListNode newHead;
		ListNode newTail = head;
		for (int i = 0; i < count; i++) {
			newTail = head;
			head = head.next;
		}

		newHead = newTail.next;
		newTail.next = null;
		oldTail.next = oldHead;

		return newHead;
	}

	private ListNode getTailPointer(ListNode head) {
		ListNode tailPointer = head;
		while (head != null) {
			tailPointer = head;
			head = head.next;
		}
		return tailPointer;
	}

	private int getListLength(ListNode head) {
		int size = 0;
		while (head != null) {
			head = head.next;
			size++;
		}
		return size;
	}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */