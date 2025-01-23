package com.datastructures.queues;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue is an interface not a class it was presented in Java Collection
 * framework.
 * 
 * its is a linear collection that supports element insertion at first and removal at
 * end. FIFO (first-in-first-out) manner
 * 
 * generally queues are implemented with linkedlist
 */
public class InBuilt {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(22);
		queue.add(23);
		queue.add(24);
		queue.add(30);
		queue.add(32);

		System.out.println("current size of queue : " + queue.size());
		System.out.println("Top of the queue : " + queue.peek());
		System.out.println(queue + "\n");

		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
}
