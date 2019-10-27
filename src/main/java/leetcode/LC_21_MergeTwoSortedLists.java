package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class LC_21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        int minValue = 0;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                minValue = l1.val;
                l1 = l1.next;
            } else {
                minValue = l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode(minValue);
            tail = tail.next;
        }

        // merge remained node at tail
        while (l1 != null) {
            tail.next = new ListNode(l1.val);
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = new ListNode(l2.val);
            tail = tail.next;
            l2 = l2.next;
        }

        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
