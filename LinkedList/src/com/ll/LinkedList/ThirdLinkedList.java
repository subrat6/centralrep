package com.ll.LinkedList;

public class ThirdLinkedList {
	static Node head;

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

	public void addBeforeFirstElement(Node prev, int data) {
		Node newNode = new Node(data);
		if (prev == null) {
			System.out.println("prev node cannot be null");
		}
		newNode.next = prev.next;
		prev.next = newNode;
	}

	public void addLast(int data) {
		Node lastNode = new Node(data);
		lastNode.next = null;
		Node traversealNode = head;
		if (head == null) {
			head = new Node(data);
			return;
		}
		while (traversealNode.next != null) {
			traversealNode = traversealNode.next;
		}
		traversealNode.next = lastNode;
	}

	public void deleteData(int data) {
		Node prevNode, tempNode;
		tempNode = head;
		prevNode = null;
		if (tempNode.data == data) {
			head = head.next;
			return;
		}
		while (tempNode.data != data) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}
		prevNode.next = tempNode.next;

	}

	public void deleteNode(int deleteIndex) {
		Node traverseNode = head;
		if (deleteIndex == 0) {
			head = head.next;
			return;
		}
		for (int i = 0; i < deleteIndex - 1; i++) {
			traverseNode = traverseNode.next;
		}
		if (traverseNode == null || traverseNode.next == null) {
			return;
		}
		Node next = traverseNode.next.next;
		traverseNode.next = next;
	}

	public void printAll() {
		Node startNode = head;
		while (startNode != null) {
			System.out.print(startNode.data + " ");
			startNode = startNode.next;
		}

	}
	public int count(Node newNode){
		if (newNode==null) {
			return 0;
		}
		return 1+count(newNode.next);
	}
	public int addCount(){
		return count(head);
	}
	public void swap(int x,int y){
		if(x==y){
			return;
		}
		Node prevx,currx;
		prevx=null;
		currx=head;
		while(currx !=null &&currx.data!=x){
			prevx=currx;
			currx=currx.next;
		}
		Node prevy,curry;
		prevy=null;
		curry=head;
		while(curry !=null && curry.data!=y){
			prevy=curry;
			curry=curry.next;
		}
		if (prevx !=null) {
			prevx.next=curry;
		}
		else {
			head=curry;
		}
		if(prevy!=null){
			prevy.next=currx;
		}
		else{
			head=currx;
		}
		Node temp=curry.next;
		curry.next=currx.next;
		currx.next=temp;
	}
	public Node reverse(Node newNode){
		Node next=null;
		Node prev=null;
		Node current=newNode;
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		newNode=prev;
		return newNode;
	}
	public void printNodes(Node node){
		while(node!=null){
			System.out.print(node.data+" ");
			node=node.next;
		}
	}

	public static void main(String[] args) {
		ThirdLinkedList tll = new ThirdLinkedList();
		tll.push(5);
		tll.addLast(6);
		tll.push(4);
		tll.printAll();
		/*System.out.println("\n after delete");
		tll.deleteNode(2);
		tll.printAll();
		System.out.println("\n after delete");
		tll.deleteData(4);
*/		//tll.printAll();
        System.out.println("count = "+tll.addCount());
        System.out.println("\n after swap");
        tll.swap(4, 6);
        tll.printAll();
        Node newHead=tll.reverse(head);
        System.out.println("\n");
        tll.printNodes(newHead);
	}
}
