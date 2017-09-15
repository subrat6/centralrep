package com.ll.beans;

public class DeleteSearchNode {
	Node head;
	static class Node{
		public int data;
		public Node next;
		public Node(int data){
			this.data=data;
			next=null;
		}
	}
	public void printList(){
		Node startNode=head;
		while(startNode !=null){
			System.out.println(startNode.data+" ");
			startNode=startNode.next;
		}
	}
	public void push(int data){
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;
	}
	public void DeleteData(int data){
	Node prev,temp;
	temp=head;
	prev=null;
	if (temp !=null && temp.data==data) {
		head=temp.next;
		return;
	}
	while(temp !=null && temp.data !=data){
		prev=temp;
		temp=temp.next;
	}
	
	prev.next=temp.next;
		
	}
	public static void main(String[] args) {
		DeleteSearchNode dsn=new DeleteSearchNode();
		dsn.push(12);
		dsn.push(14);
		dsn.push(16);
		System.out.println("\n elements are");
		dsn.printList();
		dsn.DeleteData(16);
		System.out.println(" elements are");
		dsn.printList();
	}

}
