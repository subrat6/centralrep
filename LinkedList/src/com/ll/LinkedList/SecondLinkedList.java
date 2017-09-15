package com.ll.LinkedList;

public class SecondLinkedList {
	Node head;

	static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void push(int data) {
		Node firstNode = new Node(data);
		if (head == null) {
			head = new Node(data);
			return;
		}
		firstNode.next = head;
		head = firstNode;
	}

	public void addBeforeFirst(int data, Node prevNode) {
		Node newNode = new Node(data);
		if (prevNode == null) {
			System.out.println("prev node can't be null");
		}
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}

	public void addLast(int data) {
		Node lastNode = new Node(data);
		Node traverseNode = head;
		lastNode.next = null;
		if (head == null) {
			head = new Node(data);
			return;
		}
		while (traverseNode.next != null) {
			traverseNode = traverseNode.next;
		}
		traverseNode.next = lastNode;
	}

	public void deleteData(int data) {
		Node temp, prevNode;
		temp = head;
		prevNode = null;
		if (head.data == data) {
			head = head.next;
			return;
		}
		while (temp.data != data) {
			prevNode = temp;
			temp = temp.next;
		}
		prevNode.next = temp.next;
	}

	public void deletePosition(int position) {
		Node traverseNode = head;
		if (traverseNode == null) {
			return;
		}
		if (position == 0) {
			head = head.next;
			return;
		}
		for (int i = 0; i < position - 1; i++) {
			traverseNode = traverseNode.next;
		}
		if (traverseNode.next == null || traverseNode == null) {
			return;
		}
		Node next = traverseNode.next.next;
		traverseNode.next = next;
	}

	public void printAll() {
		Node firstNode = head;
		while (firstNode != null) {
			System.out.print(firstNode.data + " ");
			firstNode = firstNode.next;
		}
	}

	public int count() {
		Node start = head;
		int count = 0;
		while (start != null) {
			start = start.next;
			count++;
		}
		return count;
	}

	public int countNode(Node countnode) {
		if (countnode == null) {
			return 0;
		}
		return 1 + countNode(countnode.next);
	}

	public int nodes() {
		return countNode(head);
	}

	public static void main(String[] args) {
		SecondLinkedList sll = new SecondLinkedList();
		sll.push(5);
		sll.printAll();
		sll.push(4);
		System.out.println("\n after print");
		sll.printAll();
		sll.addLast(6);
		System.out.println("\n after print");
		sll.printAll();
		sll.deleteData(5);
		System.out.println("\n after print");
		sll.printAll();

		sll.addBeforeFirst(5, sll.head);
		System.out.println("\n after print");
		sll.printAll();

		sll.deletePosition(0);
		System.out.println("\n after print");
		sll.printAll();
		System.out.println("count= " + sll.count());
		System.out.println("countNode= " + sll.nodes());
	}
}
