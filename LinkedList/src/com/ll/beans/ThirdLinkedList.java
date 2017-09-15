package com.ll.beans;

public class ThirdLinkedList {
	Node head;

	static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void printAll() {
		Node newNode = head;
		while (newNode != null) {
			System.out.print(newNode.data + " ");
			newNode = newNode.next;
		}
	}

	public void addNodeToHead(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void addNewNodeToBeforeANode(Node prevNode, int data) {
		Node newNode = new Node(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}

	public void travesrNode(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = new Node(data);
			return;
		}
		newNode.next = null;
		Node traverseNode = head;
		while (traverseNode.next != null) {
			traverseNode = traverseNode.next;
		}
		traverseNode.next = newNode;

	}

	public static void main(String[] args) {
		ThirdLinkedList tl = new ThirdLinkedList();
		tl.addNodeToHead(1);
		/*
		 * tl.travesrNode(5); tl.travesrNode(10); tl.addNodeToHead(3);
		 * tl.addNewNodeToBeforeANode(tl.head.next, 4);
		 */
		tl.printAll();
	}
}
