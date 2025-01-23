package com.datastructures.stack;

public class Dynamic_stack<E> extends Custom_stack<E> {
	
	public Dynamic_stack() {
		super(); // call Custom_stack() constructor 
	}

	public Dynamic_stack(int size) {
		super(size); // call Custom_stack(size) constructor 
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean push(E ele){
		if (isFull()) {
			E[] temp = (E[]) java.lang.reflect.Array.newInstance(data.getClass().getComponentType(), data.length * 2);

			for (int i = 0; i < data.length; i++) {
				temp[i] = data[i];
			}

			data = temp;
		}

		return super.push(ele);
	}
}
