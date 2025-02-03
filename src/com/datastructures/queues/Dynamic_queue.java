package com.datastructures.queues;

public class Dynamic_queue<E> extends Circular_queue<E> {
	
	public Dynamic_queue() {
		super(); // call Circular_queue() constructor
	}

	public Dynamic_queue(int size) {
		super(size); // call Circular_queue(size) constructor
	}

	// O(n)
	@Override
	@SuppressWarnings("unchecked")
	public boolean insert(E ele) {
		if (isFull()) {
			E[] temp = (E[]) java.lang.reflect.Array.newInstance(Object.class, data.length * 2);

			// copy the all elements from the data
			for (int i = 0; i < data.length; i++) {
				temp[i] = data[first + i % data.length];
			}

			// update first and end
			first = 0;
			end = data.length;
			data = temp;
		}
		
		return super.insert(ele);
	}

	
}
