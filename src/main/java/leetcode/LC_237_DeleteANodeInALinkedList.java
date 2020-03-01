package leetcode;

/*
 * Note:
 * 1. The linked list will have at least two elements.
 * 2. All of the nodes' values will be unique.
 * 3. The given node will not be the tail and it will always be a valid node of the linked list.
 * 4. Do not return anything from your function.
 * */
public class LC_237_DeleteANodeInALinkedList {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
