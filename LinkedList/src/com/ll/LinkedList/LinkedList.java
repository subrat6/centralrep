package com.ll.LinkedList;

public class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void swap(int x, int y) {
		if (x == y) {
			return;
		}
		Node prevx, currx;
		prevx = null;
		currx = head;
		while (currx != null && currx.data != x) {
			prevx = currx;
			currx = currx.next;
		}
		Node prevy, curry;
		prevy = null;
		curry = head;
		while (curry != null && curry.data != y) {
			prevy = curry;
			curry = curry.next;
		}

		if (currx == null || curry == null) {
			return;
		}

		if (prevx != null) {
			System.out.println("prevx=" + prevx.data);
			prevx.next = curry;
			System.out.println("curry =" + prevx.next.data);
		} else // make y the new head
			System.out.println("curry head=" + curry.data);
			head = curry;
		System.out.println("curry head=" + curry.data);

		// If y is not head of linked list
		if (prevy != null) {
			System.out.println("prevx=" + prevy.data);
			prevy.next = currx;
			System.out.println("currx =" + prevy.next.data);
		} else // make x the new head
			head = currx;
		Node temp = currx.next;
		currx.next = curry.next;
		curry.next = temp;

	}

	public void push(int data) {
		Node firstNode = new Node(data);
		firstNode.next = head;
		head = firstNode;
	}

	public void beforeFirst(Node prevNode, int data) {
		Node newNode = new Node(data);
		if (prevNode == null) {
			System.out.println("previous node can't be null");
		}
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}

	public void addLastNode(int data) {
		Node lastNode = new Node(data);
		lastNode = null;
		Node prevNode = head;
		if (head == null) {
			head = new Node(data);
			return;
		}
		while (prevNode.next != null) {
			prevNode = prevNode.next;
		}

		prevNode.next = lastNode;
	}

	public void deleteData(int data) {
		Node temp, prevNode;
		temp = head;
		prevNode = null;
		if (temp.data == data) {
			head = head.next;
		}
		while (temp.data != data) {
			prevNode = temp;
			temp = temp.next;
		}
		prevNode.next = temp.next;
	}

	public void deletePosition(int position) {
		Node prevNode = head;
		if (prevNode == null) {
			return;
		}
		if (position == 0) {
			head = head.next;
		}
		for (int i = 0; i < position - 1; i++) {
			prevNode = prevNode.next;
		}
		if (prevNode.next == null || prevNode == null) {
			return;
		}
		Node next = prevNode.next.next;
		prevNode.next = next;
	}

	public void printAll() {
		Node firstNode = head;
		while (firstNode != null) {
			System.out.print(firstNode.data + " ");
			firstNode = firstNode.next;
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.push(5);
		ll.push(10);
		ll.push(15);
		ll.push(16);
		ll.beforeFirst(ll.head, 7);
		ll.addLastNode(20);
		ll.printAll();
		// System.out.println("\n after delete");
		// ll.deleteData(7);
		// ll.printAll();
		// System.out.println("\n after delete");
		// ll.deletePosition(0);
		// ll.printAll();
		ll.swap(16, 10);
		System.out.println("\n after swap");
		ll.printAll();

	}
}
