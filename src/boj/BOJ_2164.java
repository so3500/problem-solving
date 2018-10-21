/* 2164 카드
 * https://www.acmicpc.net/problem/2164
 * 시뮬레이션 
 * */

package boj;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class BOJ_2164 {

	private static class DoublyLinkedList<T> {

		Node head, tail;
		int size;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
			size = 0;
		}

		class Node {
			T data;
			Node prev, next;

			Node(T data) {
				this.prev = null;
				this.next = null;
				this.data = data;
			}
		}

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			if (this.size == 0) {
				return false;
			}
			return true;
		}

		public boolean contains(T o) {
			return false;
		}

		// tail에 추가
		public boolean add(T e) {
			Node node = new Node(e);

			if (this.size == 0) {
				this.head = node;
				this.tail = node;
				this.size++;
				return true;
			}

			node.prev = this.tail;
			this.tail.next = node;
			this.tail = node;
			this.size++;
			return true;
		}

		public boolean remove(T o) {
			return false;
		}

		public boolean containsAll(Collection c) {
			return false;
		}

		public boolean addAll(Collection c) {
			return false;
		}

		public boolean addAll(int index, Collection c) {
			return false;
		}

		public boolean removeAll(Collection c) {
			return false;
		}

		public boolean retainAll(Collection c) {
			return false;
		}

		public void clear() {

		}

		public T get(int index) {
			Node node = getNode(index);
			return node.data;
		}

		public T set(int index, T element) {
			return null;
		}

		public void add(int index, T element) {

		}

		public T remove(int index) {
			Node node = getNode(index);
			T data = node.data;
			if (index == 0) {
				// h0 1 2
				this.head = node.next;
				// 0 h1 2
				this.head.prev = null;
				node = null;
			} else if (0 < index && index < size - 1) {
				// 0 1 2
				node.prev = node.next.prev;
				node.next = node.prev.next;
				node = null;
				// 0 2
			} else if (index == size - 1) {
				// 0 1 h2
				this.tail = node.prev;
				// 0 h1 2
				this.tail.next = null;
				node = null;
			}
			size--;
			return data;
		}

		public int indexOf(T o) {
			return 0;
		}

		public List subList(int fromIndex, int toIndex) {
			return null;
		}

		private Node getNode(int idx) {
			int curIdx = 0;
			Node node = this.head;
			while (curIdx < idx) {
				node = node.next;
			}
			return node;
		}

	}

//	private static List<Integer> cards;
	private static DoublyLinkedList<Integer> cards;
	private static int N;

	public static void main(String[] args) {
		init();
		int ans = solve();
		System.out.println(ans);
	}

	private static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();

//		cards = new LinkedList<>();
		cards = new DoublyLinkedList<>();
		for (int cardNo = 1; cardNo <= N; cardNo++) {
			cards.add(cardNo);
		}
	}

	private static int solve() {
		if (cards.size() == 1) {
			return 1;
		}

		while (cards.size() > 1) {
			cards.remove(0);
			cards.add(cards.remove(0));
		}

		return cards.get(0);
	}

}
