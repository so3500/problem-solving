package examples;

import java.util.LinkedList;

class DoublyLinkedList<T> {

	private Node head;
	private Node tail;
	private int size;

	class Node {
		Node prev;
		Node next;
		T data;

		public Node(T data) {
			this.prev = null;
			this.next = null;
			this.data = data;
		}

	}

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	Node node(int index) {
		Node x;
		if (index < size / 2) {
			x = head;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
		} else if (index >= size / 2 && index < size) {
			x = tail;
			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
		} else {
			x = tail;
		}
		return x;
	}

	public void addFirst(T data) {
		Node node = new Node(data);

		if (size > 0) {
			node.next = head;
			head.prev = node;
			head = node;
		} else if (size == 0) {
			head = node;
			tail = node;
		}
		size++;
	}

	public void addLast(T data) {
		Node node = new Node(data);

		if (size > 0) {
			node.prev = tail;
			tail.next = node;
			tail = node;
			size++;
		} else if (size == 0) {
			addFirst(data);
		}
	}

	public void add(int index, T data) {
		if (index > 0) {
			Node nextNode = node(index);
			Node prevNode = nextNode.prev;

			Node node = new Node(data);
			node.next = nextNode;
			node.prev = prevNode;
			size++;

			if (node.next == null) {
				tail = node;
			}
		} else if (index == 0) {
			addFirst(data);
		}
	}

	// TODO
	public T get(int index) {
		return null;
	}

	// TODO
	public T remove(int index) {
		if (size == 1) {
			return removeFirst();
		}

		return null;
	}

	public T remove(T data) {

		return null;
	}

	public T removeFirst() {
		Node temp = head;
		head = temp.next;
		head.prev = null;
		T data = temp.data;
		temp = null;
		size--;
		return data;
	}

	public T removeLast() {
		Node temp = tail;
		tail = temp.prev;
		tail.next = null;
		T data = temp.data;
		temp = null;
		size--;
		return data;
	}

	public String toString() {
		if (head == null) {
			return "[]";
		}

		Node tmp = head;
		String str = "[";

		while (tmp.next != null) {
			str += tmp.data + ", ";
			tmp = tmp.next;
		}
		str += tmp.data;
		return str + "]";
	}

	public Iterator iterator() {
		return new Iterator();
	}

	class Iterator {
		private Node next;
		private Node lastReturned;
		private int nextIndex;

		Iterator() {
			next = head;
			nextIndex = 0;
		}

		public T next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}

		public boolean hasNext() {
			if (nextIndex < size) {
				return true;
			} else {
				return false;
			}
		}
	}

}

class HashMap {

	DoublyLinkedList<Obj>[] data;

	class Obj {
		String key;
		String value;

		public Obj(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		public String toString() {
			return String.format("{key: %s value: %s}", this.key, this.value);
		}
	}

	HashMap(int size) {
		this.data = new DoublyLinkedList[size];
	}

	int getHashCode(String key) {
		int hashCode = 0;
		for (char c : key.toCharArray()) {
			hashCode += (int) c;
		}
		return hashCode;
	}

	int getIndex(int hashCode) {
		return hashCode % data.length;
	}

	Obj searchKey(DoublyLinkedList<Obj> list, String key) {
		if (list == null) {
			return null;
		}
//		for (Obj node : list) {
//			if (node.key.equals(key)) {
//				return node;
//			}
//		}
		return null;
	}

	Obj removeKey(DoublyLinkedList<Obj> list, String key) {
		if (list == null) {
			return null;
		}

		DoublyLinkedList.Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Obj obj = (Obj) itr.next();
			if (obj.key.equals(key)) {
				list.remove(obj);
				return obj;
			}
		}
		return null;
	}

	void put(String key, String value) {
		int hashCode = getHashCode(key);
		int index = getIndex(hashCode);
		DoublyLinkedList<Obj> list = data[index];

		printState(key, hashCode, index);

		if (list == null) {
			list = new DoublyLinkedList<Obj>();
			data[index] = list;
		}
		Obj node = searchKey(list, key);
		if (node == null) {
			list.addLast(new Obj(key, value));
		} else {
			node.setValue(value);
		}
	}

	String get(String key) {
		int hashCode = getHashCode(key);
		int index = getIndex(hashCode);
		DoublyLinkedList<Obj> list = data[index];
		Obj node = searchKey(list, key);
		if (node != null) {
			return node.getValue();
		} else {
			return null;
		}
	}

	String remove(String key) {
		int hashCode = getHashCode(key);
		int index = getIndex(hashCode);
		DoublyLinkedList<Obj> list = data[index];
		Obj node = removeKey(list, key);
		if (node != null) {
			return node.getValue();
		} else {
			return null;
		}
	}

	void printState(String key, int hashCode, int index) {
		System.out.println(String.format("%s, hashCode(%d), index(%d)", key, hashCode, index));
	}

}

public class HashMapTest {
	public static void main(String[] args) {
		HashMap h = new HashMap(100);
		h.put("sddung", "she is pretty");
		h.put("ledde", "she is model");
		h.put("on", "she is pretty");
		h.put("you", "she is sdfsdfssd");
		System.out.println(h.get("sung"));
		System.out.println(h.get("lee"));
		System.out.println(h.get("on"));
		System.out.println(h.get("you"));
		System.out.println(h.get("sddung"));
		System.out.println();
		h.remove("sddung");
		System.out.println(h.get("sddung"));
	}
}
