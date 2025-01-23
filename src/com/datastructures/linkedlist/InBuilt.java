package com.datastructures.linkedlist;

import java.util.LinkedList;

/*
 * LinkedList is a class implemented with List<> interface & Deque<> interface
 * that Deque<> interface is implemented with Queue<> inerface
 * 
 * LinkedList is also used in queue implementation
 */
public class InBuilt {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(23);
		list.add(24);
		list.add(25);
		list.add(26);
		list.add(30);
		list.add(35);

		System.out.println("current size of linkedlist : " + list.size());
		System.out.println(list);
		System.out.println("head of the linkedlist : " + list.peek());
		System.out.println("tail of the linkedList : " + list.peekLast());

		// some operations on linkedlist
		System.out.println("List contains 24 : " +list.contains(24));
	}
}
