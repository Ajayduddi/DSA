package com.datastructures.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Deque ( double ended queue ) is an interface not a class. its is a linear
 * collection that supports element insertion and removal at both ends. it was a
 * extention of queue
 * 
 * Deque is implemented with ArrayDeque Resizable-array implementation of the {@link Deque} interface. which have no capacity restrictions,
 * not thread-safe, and null elements are not allowed.
 * 
 * This {@link ArrayDeque} is likely to be faster than {@link Stack} when used as a stack, 
 * and faster than {@link LinkedList} when used as a queue.
 * 
 */

public class Deque_InBuilt {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(1);
		deque.add(11);
		deque.add(12);
		deque.addLast(15); // same as add
		deque.addFirst(20);

		System.out.println("current size : " + deque.size());
		System.out.println("Top of the queue :" + deque.peek()); // same as peekFirst()
		System.out.println("Top of the queue from last :" + deque.peekLast());
		System.out.println(deque);
		System.out.println();

		System.out.println(deque.remove());
		System.out.println(deque.remove());  // same as removrFirst()
		System.out.println(deque.removeLast());
	}	
}
