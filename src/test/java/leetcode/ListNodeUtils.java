package leetcode;

import java.util.LinkedList;
import java.util.List;

public final class ListNodeUtils {

	private ListNodeUtils() {
	}

	public static int[] convertToIntArray(ListNode l) {
		List<Integer> nums = new LinkedList<>();

		while (l != null) {
			nums.add(l.val);
			l = l.next;
		}

		return nums.stream().mapToInt(Integer::intValue).toArray();
	}

	public static ListNode convertToListNode(int[] nums) {
		ListNode dummyHead = new ListNode();
		ListNode current = dummyHead;

		for (int num : nums) {
			current.next = new ListNode(num);
			current = current.next;
		}

		return dummyHead.next;
	}

	public static boolean equals(ListNode l1, ListNode l2) {
		// TODO - check null, size, value
		return true;
	}
}