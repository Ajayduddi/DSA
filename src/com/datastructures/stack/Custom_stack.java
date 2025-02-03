package com.datastructures.stack;

public class Custom_stack<E> {
	protected E[] data; // static array to store the stack elements
	private static final int DEFAULT_SIZE = 10;
	int ptr = -1;

	public Custom_stack() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public Custom_stack(int size) {
		this.data = (E[]) java.lang.reflect.Array.newInstance(Object.class, size);
	}

	//O(1)
	public boolean push(E ele) {
		if (isFull()) {
			System.out.println("Stack is Full :  Element is not inserted " + ele + "\n");
			return false;
		}

		ptr++;
		data[ptr] = ele;
		return true;
	}

	//O(1)
	public final E pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is Empty");
		}

		return data[ptr--];
	}
	
	// O(1)
	public final E peek() throws StackException {
		if (isEmpty()) {
			throw new StackException("No element is present in the stack : Stack is empty");
		}

		return data[ptr];
	}
	
	// O(n)
	public final void display() {
		System.out.print("[");
		for (int i = 0; i <= ptr; i++) {
			System.out.print(data[i]+",");
		}
		System.out.println("]");
	}
	
	public final boolean isFull(){
		return ptr == data.length - 1; // chcek array is full or not
	}

	public final boolean isEmpty(){
		return ptr == -1; // check array is empty or not;
	}
}
