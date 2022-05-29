package leetcode;

/**
 * https://leetcode.com/problems/partition-list/
 * related topic: Linked List, Two Pointers
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LC_86_PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode prevDummyNode = new ListNode();
		ListNode nextDummyNode = new ListNode();
		ListNode p1 = prevDummyNode;
		ListNode p2 = nextDummyNode;

		// make two list divide by x
		while (head != null) {
			if (head.val < x) {
				p1.next = new ListNode(head.val);
				p1 = p1.next;
			} else {
				p2.next = new ListNode(head.val);
				p2 = p2.next;
			}
			head = head.next;
		}

		// merge two list and return (or prev list)
		if (prevDummyNode == p1) {
			return nextDummyNode.next;
		} else {
			p1.next = nextDummyNode.next;
			return prevDummyNode.next;
		}
	}
}