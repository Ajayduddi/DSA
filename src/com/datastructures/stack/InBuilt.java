package com.datastructures.stack;

import java.util.Stack;

/*
 * In java stack is a class implemented with vectors ( dynammic array )
 * that vector calss is implemented with List<> interface
 */
public class InBuilt {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(12);
		stack.push(13);
		stack.push(14);
		stack.push(21);
		stack.push(24);
		stack.push(34);
		stack.push(44);

		System.out.println("Initial capacity of stack : "+stack.capacity());
		System.out.println("Current size of stack : " + stack.size());
		System.out.println("Top of the stack : " + stack.peek());
		System.out.println(stack + "\n");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
