package leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC_206_ReverseLinkedListTest {

	private final LC_206_ReverseLinkedList lc206 = new LC_206_ReverseLinkedList();

	@Test
	void reverseList() {
		assertThat(print(lc206.reverseList(makeNode()))).isEmpty();
		assertThat(print(lc206.reverseList(makeNode(1, 2)))).isEqualTo("21");
		assertThat(print(lc206.reverseList(makeNode(1, 2, 3, 4, 5)))).isEqualTo("54321");
	}

	private static ListNode makeNode(int... args) {
		ListNode tempHead = new ListNode();
		ListNode cur = tempHead;

		for (int arg : args) {
			ListNode next = new ListNode(arg);
			cur.next = next;
			cur = next;
		}

		return tempHead.next;
	}

	private static String print(ListNode head) {
		StringBuilder out = new StringBuilder();

		ListNode cur = head;
		while (cur != null) {
			out.append(cur.val);
			cur = cur.next;
		}

		return out.toString();
	}
}