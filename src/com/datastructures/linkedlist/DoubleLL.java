package com.datastructures.linkedlist;

// double linkedlist
public class DoubleLL {

	Node head;
	Node tail;
	int size;

	// method to get the size of the linkedlist
	public final int size() {
		return size;
	}

	// get the first element in the linkedlist
	public final int getFirst() {
		return head.val;
	}

	// get the last element in the linkedlist
	public final int getLast() {
		return tail.val;
	}

	// get the head node
	public final Node head() {
		return head;
	}

	// get the tail node
	public final Node tail() {
		return tail;
	}

	// insert the element at first position of the linkedlist
	public final void insertFirst(int val) {
		Node node = new Node(val);

		// here we add the new node at the first
		// so, we update the node.next referance to the head & node.previous referance to null
		// And update the head referance to te new node
		node.next = head;
		head = node;

		// if we insert the first element to the linkedlist
		if (this.tail == null) {
			tail = head;
		}

		// update size
		size += 1;
	}

	// insert element at last of the linked list
	public final void add(int val) {

		// if we insert the first element to the linkedlist
		if (this.tail == null) {
			insertFirst(val);
			return;
		}

		Node node = new Node(val);
		// here we add the new node at the last
		// so, we update the node.next referance to null & node.previous referance to the tail
		// And update the tail.next referance to te new node & tail referance to the new node
		node.previous = tail;
		tail.next = node;
		tail = node;

		// update size
		size += 1;
	}

	// insert the element at the given position
	public final void insert(int index, int val) {

		// check the index is out of range or not
		if (index >= this.size) {
			System.out.println("invalid index");
			return;
		}

		// if we insert the first element to the linkedlist
		if (index == 0) {
			insertFirst(val);
			return;
		}

		// find the previous node according to the given position
		Node temp = get(index - 1);
		// here we add the new node at specified position
		// so, we update the node.next referance to the previous node.next & node.previous referance to the previous node
		// And update the previous node.next referance to the new node
		Node node = new Node(val, temp.next, temp);
		temp.next.previous = node;
		temp.next = node;

		// update size
		size += 1;
	}

	// Replace the element at the given position
	public final void replace(int index, int val) {

		// check the index is out of range or not
		if (index >= this.size) {
			System.out.println("invalid index");
			return;
		}

		// find the replacing node according to the given position
		Node temp = get(index);

		// here we replace the node.val at the specified position
		temp.val = val;

	}

	// remove the first element from the linkedlist
	public final void removeFirst() {
		// if only one element is present in the linked list
		if (size == 1) {
			tail = null;
			head = head.next;
			size -= 1;
			return;
		}

		head = head.next;
		head.previous = null;
		size -= 1;
	}

	// remove the last element from the linkedlist
	public final void remove() {
		// if only one element is present in the linked list
		if (size == 1) {
			removeFirst();
			return;
		}

		tail = tail.previous;
		tail.next = null;
		size -= 1;
	}

	// remove the element at the given position
	public final void remove(int index) {
		// check index out of bounds
		if (index >= this.size) {
			System.out.println("Invalid index");
			return;
		}

		// if we remove the first node
		if (index == 0) {
			removeFirst();
			return;
		}

		// if remove the last node
		if (index == (size - 1)) {
			remove();
			return;
		}

		// find previous node according to the given position
		Node temp = get(index - 1);
		// removing node
		Node temp2 = temp.next;
		// here we remove the node at the specified position
		// so, we update the previous node.next referance to the specific position node.next
		// And update the specific position node.next.previous referance to the previous node
		temp.next = temp2.next;
		temp2.next.previous = temp;

		// update size
		size -= 1;
	}

	// get the node at the given position
	public final Node get(int index) {
		Node node = head;
		for (int i = 1; i <= index; i++) {
			node = node.next;
		}

		return node;
	}

	// find the Node by value
	public final Node find(int val) {
		Node node = head;
		while (node != null) {
			if (node.val == val) {
				break;
			}
			node = node.next;
		}

		return node;
	}

	// display the linkedlist
	public final void display() {
		Node node = head;
		while (node != null) {
			System.out.print(node.val + " <-> ");
			node = node.next;
		}
		System.out.println("END");
	}

	// this is the class Node represents a node in the linked list
	// In linkedlist each node has a value, pointer referance to the next node & pointer referance to previous node
	// In linkedlist each node is an object
	private class Node {
		int val;
		Node next;
		Node previous;

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node next, Node previous) {
			this.val = val;
			this.next = next;
			this.previous = previous;
		}
	}
}
