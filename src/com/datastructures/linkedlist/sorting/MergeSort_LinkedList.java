package com.datastructures.linkedlist.sorting;

import java.util.ArrayList;

public class MergeSort_LinkedList {
	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(0);
		node.next.next = new Node(2);
		node.next.next.next = new Node(1);
		node.next.next.next.next = new Node(6);
		node.next.next.next.next.next = new Node(5);
		
		Node tail = node.next.next.next.next.next;

		// before sorting
		BubbleSort_LinkedList.display(node);
		System.out.println(" ");

		mergeSort(node,tail);
		BubbleSort_LinkedList.display(node);
	}

	public static void mergeSort(Node head, Node tail) {
		Node node = head;
		if (node == null || node.next == null || node == tail) {
			return;
		}

		// find mid node
		Node mid = findMid(node,tail);
		mergeSort(head, mid);
		mergeSort(mid.next, tail);
		merge(head, mid, tail);
	}

	public static void merge(Node head, Node mid, Node tail) {
		Node i = head;
		Node j = mid.next;
		ArrayList<Integer> arr = new ArrayList<>();

		while (i != mid.next && j != tail.next) {
			if (i.val > j.val) {
				arr.add(j.val);
				j = j.next;
			}
			else {
				arr.add(i.val);
				i = i.next;
			}
		}

		while (i != mid.next) {
			arr.add(i.val);
			i = i.next;
		}
		
		while (j != tail.next) {
			arr.add(j.val);
			j = j.next;
		}

		i = head;
		for (int k = 0; k < arr.size(); k++) {
			i.val = arr.get(k);
			i = i.next;
		}
	}

	/*
	 * find mid node using fast and slow pointer
	 */
	public static Node findMid(Node head, Node tail) {
		
		// if two element are present
		if (head.next == tail) {
			return head;
		}

		Node slow = head;
		Node fast = head;

		while (fast != tail.next && fast.next != tail.next) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}
}


// class Node {
//     int val;
//     Node next;
//     Node(int x) {
//         val = x;
//         next = null;
//     }
// }
