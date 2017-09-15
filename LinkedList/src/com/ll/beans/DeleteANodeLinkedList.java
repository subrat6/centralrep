package com.ll.beans;

public class DeleteANodeLinkedList {
	Node head;

	static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void DeleteNode(int deletedData) {
		/*Node prevnode, temp;
		temp = head;
		prevnode = null;
		if (temp != null && temp.data == deletedData) {
			head = temp.next;
			return;
		}
		while (temp != null && temp.data != deletedData) {
			prevnode = temp;
			temp = temp.next;
		}
		if (temp == null) {
			return;
		}
		prevnode.next = temp.next;
	*/
		//delete 1st data
		Node prev,temporary;
		prev=head;
		temporary=null;
		if (prev !=null && prev.data==deletedData) {
			head=prev.next;
			return;
		}
		//search middle of record
		while(prev !=null && prev.data !=deletedData){
			temporary=prev;
			prev=prev.next;
		}
		if (prev ==null) {
			return;
		}
		temporary.next=prev.next;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void printList() {
		Node firstNode = head;
		while (firstNode != null) {
			System.out.print(firstNode.data + " ");
			firstNode = firstNode.next;
		}
	}
	public static void main(String[] args) {
		DeleteANodeLinkedList dal=new DeleteANodeLinkedList();
		dal.push(14);
		dal.push(15);
		System.out.println("printlist");
		dal.printList();
		dal.DeleteNode(14);
		System.out.println("\ndelete printlist");
		dal.printList();
	}
	
}
