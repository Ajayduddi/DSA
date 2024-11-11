package com.datastructures.linkedlist.sorting;

public class BubbleSort_LinkedList {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(5);
		node.next.next = new Node(2);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(6);
		node.next.next.next.next.next = new Node(0);

		// before sorting
		display(node);

		// bubbleSort(node);
		bubbleSort_loop(node);
		System.out.println(" ");
		display(node); // after sorting
	}
	
	public static void bubbleSort(Node head) {
		int length = 0;
		Node temp = head;

		// find the length of the linkedlist
		while (temp != null) {
			length++;
			temp = temp.next;
		}

		// run steps n-1 times
		for (int i = 0; i < length - 1; i++) {
			temp = head;
			boolean swapped = false;
			for (int j = 0; j < length - i - 1; j++) {
				// swap val
				if (temp.val > temp.next.val) {
					swapped = true;
					int k = temp.next.val;
					temp.next.val = temp.val;
					temp.val = k;
				}
				// next node
				temp = temp.next;
				temp.next = temp.next.next;
			}

			if (!swapped) {
				break;
			}
		}
	}

	// bubble sort using do-while
	public static void bubbleSort_loop(Node head) {
		Node node;
		boolean swapped = false;

		do{
			swapped = false;
			node = head;
			while(node.next != null){
				if (node.val > node.next.val) {
					int temp = node.val;
					node.val = node.next.val;
					node.next.val = temp;
					swapped = true;
				}

				node = node.next;
			}
		} while(swapped);
	}
	
	public static void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
	}
}

class Node {
    int val;
    Node next;
    Node(int x) {
        val = x;
        next = null;
    }
}