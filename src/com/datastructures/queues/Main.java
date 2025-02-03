package com.datastructures.queues;

public class Main {
	public static void main(String[] args) throws Queue_exceptions {
		// custom queue
		System.out.println("Custom queue");
		Custom_queue<Integer> queue = new Custom_queue<>(5);
		queue.insert(22);
		queue.insert(33);
		queue.insert(41);
		queue.insert(52);
		queue.insert(58);
		queue.insert(67); // raise an error queue is full

		queue.display();
		System.out.println("Queue first element : " + queue.front()+"\n");

		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println();
		queue.display();
		System.out.println();

		// Circular queue
		System.out.println("Circular Queue");
		Circular_queue<Integer> circular_queue = new Circular_queue<>(5);
		circular_queue.insert(22);
		circular_queue.insert(33);
		circular_queue.insert(41);
		circular_queue.insert(52);
		circular_queue.insert(55);
		circular_queue.insert(67); // raise an error queue is full

		circular_queue.display();
		System.out.println("Circular Queue first element : " + circular_queue.front() + "\n");
		
		System.out.println(circular_queue.remove());
		System.out.println(circular_queue.remove()+"\nAfter Removing : ");
		circular_queue.display();

		circular_queue.insert(2);
		circular_queue.insert(7);
		System.out.println("\nAfter Inserting : ");
		circular_queue.display();
		System.out.println();

		// Dynamic Queue
		System.out.println("Dynamic Queue : ");
		Dynamic_queue<Integer> dynamic_queue = new Dynamic_queue<>(5);
		dynamic_queue.insert(22);
		dynamic_queue.insert(33);
		dynamic_queue.insert(41);
		dynamic_queue.insert(52);
		dynamic_queue.insert(55);
		dynamic_queue.insert(67); // here the dynamic queue expand their size

		dynamic_queue.display();
		System.out.println("Dynamic Queue first element : " + dynamic_queue.front() + "\n");

		System.out.println(dynamic_queue.remove());
		System.out.println(dynamic_queue.remove()+"\nAfter Removing : ");
		dynamic_queue.display();

		dynamic_queue.insert(2);
		dynamic_queue.insert(7);
		System.out.println("\nAfter Inserting : ");
		dynamic_queue.display();
		System.out.println();
	}
}
