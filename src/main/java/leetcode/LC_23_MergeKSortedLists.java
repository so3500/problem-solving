package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * related topic: Linked List, Heap(Priority Queue), Merge Sort, Divide and Conquer
 */
public class LC_23_MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		return mergeKListsByQueue(lists);
	}

	/**
	 * Heap(Priority Queue)
	 * - N: total elements
	 * - K: size of list
	 *
	 * Time Complexity: O(NlogK)
	 * - logK : O(logK) for enqueue element in Priority Queue
	 * - N : invoke enqueue by N times
	 *
	 * Space Complexity: O(N)
	 * - N: create N nodes
	 */
	public ListNode mergeKListsByQueue(ListNode[] lists) {
		Queue<Integer> queue = createQueue(lists);
		return createMergedLists(queue);
	}

	private Queue<Integer> createQueue(ListNode[] lists) {
		Queue<Integer> queue = new PriorityQueue<>();

		for (ListNode node : lists) {
			while (node != null) {
				queue.add(node.val);
				node = node.next;
			}
		}

		return queue;
	}

	private ListNode createMergedLists(Queue<Integer> queue) {
		ListNode dummyHead = new ListNode();
		ListNode node = dummyHead;

		while (!queue.isEmpty()) {
			node.next = new ListNode(queue.poll());
			node = node.next;
		}

		return dummyHead.next;
	}
}