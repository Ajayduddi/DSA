package com.datastructures.linkedlist;

// single linked list
public class LL {

	private Node head; // this is the refereance variable which points to the starting point of the linkedList
	private Node tail; // this is the refereance variable which points to the ending of the linkedlist
	private int size;// this is the variable to know the size of the linkedlist

	// constructor to create new instance of the linkedlist. and initilize the size to 0;
	public LL() {
		this.size = 0;
	}

	// Get size of linked list
	public final int size() {
		return this.size;
	}

	// Get the first element of the linkedlist
	public final int getFirst() {
		return this.head == null ? 0 : this.head.val ;
	}

	// Get the last element of the linkedlist
	public final int getLast() {
		return this.tail == null ? 0 : this.tail.val;
	}

	// get next node
	public final Node next(Node node) {
		return node.next;
	}

	// get Head referance
	public final Node getHead() {
		return this.head;
	}

	// ger Tail referance
	public final Node getTail() {
		return this.tail;
	}

	// Insert the element as a first element in the linkedlist
	public final void insertFirst(int val) {
		Node node = new Node(val);

		// here we add the new node at the first
		// so, we update the node.next referance to the head
		// And update the head referance to te new node
		node.next = this.head;
		this.head = node;

		// if the new node is the first node then we update the tail referance to the new node
		if (this.tail == null) {
			this.tail = this.head;
		}

		// update size
		size += 1;
	}

	// insert element to the linkedlist
	public final void add(int val) {

		// if the new node is the first node than we insert it as the first node
		if (this.tail == null) {
			insertFirst(val); // call the insertFirst method to add first node
			return;
		}

		Node node = new Node(val);

		// here we add the new node at the last
		// so, we update the tail.next referance to the head
		// And update the tail referance to te new node
		this.tail.next = node;
		this.tail = node;

		// update size
		size += 1;
	}

	// Insert element at the specified position in the linkedlist
	public final void insert(int index, int val) {

		// check index out of bounds
		if (index >= this.size) {
			System.out.println("Invalid index");
			return;
		}

		// if we insert the first element to the linkedlist
		if (index == 0) {
			insertFirst(val);
			return;
		}
		
		// find the prevoius node according to the give specifed position
		Node temp = get(index - 1);

		// inserting the new node at the specified position
		// so, we update the node.next referance to the previous node.next
		// And update the previous node.next referance to the new node
		Node node = new Node(val, temp.next);
		temp.next = node;

		// update size
		size += 1;
	}
		
	// Replacing the element at the specified position in the linkedlist
	public final void relpace(int index, int val) {

		// check index out of bounds
		if (index >= this.size) {
			System.out.println("Invalid index");
			return;
		}
		
		// find the replacing node according to the specific position
		Node temp = get(index);

		// here we replace the node.val at the specified position
		temp.val = val;
	}
	
	// Remove the first element form the linkedlist
	public final void removeFirst() {

		Node temp = head;

		// if only one element is present in the linked list
		if (this.size == 1) {
			this.tail = temp.next;
		}

		// update the Head referance to the next node
		temp = temp.next;
		head = temp;

		// update size
		size -= 1;
	}
	
	// Remove the element from the linkedlist
	public final void remove() {

		// if only one element is present in the linked list
		if (this.size == 1) {
			removeFirst();
			return;
		}

		// find the last 2nd node
		Node temp = get(this.size - 2);
		// here we are removing the last node
		temp.next = this.tail.next;
		this.tail = temp;

		// update size
		size -= 1;
	}

	// Remove the element at specified position from the linkedlist
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

		// if we remove the last node
		if (index == (size - 1)) {
			remove();
			return;
		}

		// find the previous node according to the specific position
		Node temp = get(index - 1);
		// Removing node
		Node temp2 = temp.next;
		// here we remove the node at the specified position
		// so, we update the previous node.next referance to the specific position node.next
		temp.next = temp2.next;

		// updating the size
		size -= 1;
	}

	// Insert the element into the linkedlist using recursion
	public final void insertUsingRecursion(int index, int val) {
		head = helper(index, val, head);
	}

	// get node by index
	public final Node get(int index) {
		Node node = this.head;
		for (int i = 1; i <= index; i++) {
			node = node.next;
		}

		return node;
	}
	
	// Display the linkedlist
	public final void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
	}

	// find the node by the value
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

	// helper function to insert the element using recursion
	public final Node helper(int index, int val, Node prevNode) {
		// base condition
		if (index == 0) {
			Node node = new Node(val, prevNode);
			size += 1;
			return node;
		}

		prevNode.next = helper(index - 1, val, prevNode.next);
		return prevNode;
	}

	// this is the class Node represents a node in the linked list
	// In linkedlist each node has a value & pointer referance to the next node
	// In linkedlist each node is an object
	public class Node {
		private int val;
		private Node next;

		// constructor to create a node with a value
		public Node(int val) {
			this.val = val;
		}

		// constructor to create a node with a value and a pointer to the next node
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}
}