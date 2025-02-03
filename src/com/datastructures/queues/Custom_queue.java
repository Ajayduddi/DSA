package com.datastructures.queues;

public class Custom_queue<E> {
	protected E[] data; // static array to store the queue elements
	private static final int DEFAULT_SIZE = 10;
	protected int end = 0;

	public Custom_queue() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public Custom_queue(int size) {
		this.data = (E[]) java.lang.reflect.Array.newInstance(Object.class, size);
	}

	// O(1)
	public boolean insert(E ele) {
		if (isFull()) {
			System.out.println("Queue is Full :  Element is not inserted " + ele + "\n");
			return false;
		}

		data[end] = ele;
		end++;
		return true;
	}

	// O(n)
	public E remove() throws Queue_exceptions {
		if (isEmpty()) {
			throw new Queue_exceptions("Queue is Empty");
		}

		E num = data[0];
		end--;
		
		// shift all elements to the left
		for (int i = 1; i <= end; i++) {
			data[i - 1] = data[i];
		}

		return num;
	}

	// O(n)
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is Empty\n");
			return;
		}
		
		for (int i = 0; i < end; i++) {
			System.out.print(data[i] + " <- ");
		}
		System.out.println("END");
	}

	// O(1)
	public E front() throws Queue_exceptions{
		if (isEmpty()) {
			throw new Queue_exceptions("No element is present in the Queue : Queue is empty");
		}
		return data[0];
	}

	public boolean isFull(){
		return end == data.length; // chcek array is full or not
	}

	public boolean isEmpty(){
		return end == 0; // check array is empty or not;
	}
}