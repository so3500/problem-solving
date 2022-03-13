package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 * related topic: Hash Table, Linked List, Design, Doubly-Linked List
 * Time Complexity: get O(1) / put O(1) average time
 * Space Complexity: O(c) c is capacity
 */
public class LC_146_LRUCache {
	class LRUCache {
		int capacity = 0;
		Map<Integer, Node> container;
		Node head;
		Node tail;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			container = new HashMap<>(capacity);
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
		}

		public int get(int key) {
			if (container.containsKey(key)) {
				Node node = container.get(key);
				processNodeUsed(node);
				return node.value;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (container.containsKey(key)) {
				Node node = container.get(key);
				node.value = value;
				processNodeUsed(node);
			} else {
				if (hasNoMoreCapacity()) {
					removeLeastRecentlyUsedNode();
				}
				addNewNode(key, value);
			}
		}

		private boolean hasNoMoreCapacity() {
			return container.size() == capacity;
		}

		/**
		 * node 사용처리
		 * 리스트에서 node 의 참조를 제거하고 head 에 추가
		 * tail 에서 멀수록 가장 최근에 사용함
		 */
		private void processNodeUsed(Node node) {
			deleteNode(node);
			addToHead(node);
		}

		/**
		 * 사용한지 가장 오래된 node 제거
		 * tail 에 가까울 수록 사용한지 오래됨
		 */
		private void removeLeastRecentlyUsedNode() {
			Node removeTarget = tail.prev;
			deleteNode(removeTarget);
			container.remove(removeTarget.key);
		}

		private void addNewNode(int key, int value) {
			Node node = new Node(key, value);
			addToHead(node);
			container.put(key, node);
		}

		private void deleteNode(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		private void addToHead(Node node) {
			node.next = head.next;
			node.prev = head;
			head.next.prev = node;
			head.next = node;
		}

		private class Node {
			int key;
			int value;
			Node prev;
			Node next;

			Node(int key, int value) {
				this.key = key;
				this.value = value;
			}

			Node() {
			}
		}
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}