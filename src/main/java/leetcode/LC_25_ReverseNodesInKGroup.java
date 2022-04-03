package leetcode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * related topic: Linked List, Recursion
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_25_ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		return reverseKGroupRecursive(head, k);
	}

	private ListNode reverseKGroupRecursive(ListNode head, int k) {
		ListNode current = head;
		int count = 0;

		while (current != null && count != k) {
			current = current.next;
			count++;
		}

		if (count == k) {
			current = reverseKGroupRecursive(current, k);
			current = reverseCurrentGroup(head, current, count);
			head = current;
		}

		return head;
	}

	private ListNode reverseCurrentGroup(ListNode head, ListNode current, int count) {
		while (count-- > 0) {
			ListNode tmp = head.next;
			head.next = current;
			current = head;
			head = tmp;
		}
		return current;
	}

}