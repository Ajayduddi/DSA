package com.datastructures.queues;

public class Circular_queue<E> extends Custom_queue<E> {
	/*
	 * if we use normal queue we can perform all operations with end pointer
	 * 
	 * if we use circular queue the we first,end pointer and size ( to know the size of the queue )
	 */
	protected int first = 0;
	private int size = 0;

	public Circular_queue() {
		super(); // call Custom_queue() constructor
	}

	public Circular_queue(int size) {
		super(size); // call Custom_queue(size) constructor
	}

	// O(1)
	@Override
	public boolean insert(E ele) {
		if (isFull()) {
			System.out.println("Queue is Full :  Element is not inserted " + ele + "\n");
			return false;
		}

		data[end++] = ele;
		end = end % data.length;
		size++;
		return true;
	}

	// O(1)
	@Override
	public E remove() throws Queue_exceptions {
		if (isEmpty()) {
			throw new Queue_exceptions("Queue is Empty");
		}

		E num = data[first++];
		first = first % data.length;
		size--;
		return num;
	}

	// O(n)
	@Override
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is Empty\n");
			return;
		}

		int i = first;
		do {
			System.out.print(data[i] + " <- ");
			i++;
			i = i % data.length;
		} while (i != end);
		System.out.println("END");
	}

	// O(1)
	@Override
	public E front() throws Queue_exceptions {
		if (isEmpty()) {
			throw new Queue_exceptions("No element is present in the Queue : Queue is empty");
		}
		return data[first];
	}

	// O(1)
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// O(1)
	@Override
	public boolean isFull() {
		return size == data.length;
	}

	
}
