package com.datastructures.linkedlist.reverse;

public class ReverseList {

	private Node head;
	private Node tail;
	private int size;

	public ReverseList() {
		this.size = 0;
	}

	public void add(int val) {
		if (head == null) {
			Node node = new Node(val);
			this.head = node;
			this.tail = node;
			this.size += 1;
			return;
		}

		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size += 1;
	}

	public void display() {
		Node node = head;
		while (node != null) {
			System.out.print(node.val + "-->");
			node = node.next;
		}
		System.out.print("End\n");
	}
	
	// reverse the linkedlist uding iteration
	public void iteration_reverse() {
		if (head == null) {
			return;
		}

		Node prev = null;
		Node current = head;
		Node next = head.next;
		this.tail = head;

		while (current != null) {
			current.next = prev; // reverse the pointer
			prev = current; // prev points to the current pointer
			current = next; // current points to the next poiner
			if (next != null) {
				next = next.next; // next points to the next node;
			}
		}
		this.head = prev;
	}

	// reverse the linkedlist using recursion
	public void recursive_Reverse() {
		recursion_helper(head);
	}

	// this is the helper function of the recursive_reverse
	public void recursion_helper(Node start) {
		// base condition
		if (start == tail || start == null) {
			this.head = start;
			return;
		}

		recursion_helper(start.next);
		this.tail.next = start;
		this.tail = start;
		this.tail.next = null;
	}

	class Node {
		int val;
		Node next;

		public Node() {}

		public Node(int val) {
			this.val = val;
		}

		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ReverseList list = new ReverseList();
		list.add(0);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(34);
		list.display();
		list.recursive_Reverse(); // reverse the list usinf recursion
		System.out.println("After reverse the list using recursion ");
		list.display();
		
		System.out.println();
		list.iteration_reverse();
		System.out.println("Again reverse the list to previous position ");
		list.display();
	}
}
