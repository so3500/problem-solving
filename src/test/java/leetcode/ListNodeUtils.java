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

	public static ListNode[] convertToListNode(int[][] nums) {
		ListNode[] lists = new ListNode[nums.length];

		int i = 0;
		for (int[] num1d : nums) {
			ListNode node = convertToListNode(num1d);
			lists[i++] = node;
		}

		return lists;
	}

	public static boolean equals(ListNode l1, ListNode l2) {
		// TODO - check null, size, value
		return true;
	}
}