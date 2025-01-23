package com.datastructures.stack;

public class Main {
	public static void main(String[] args) throws StackException {
		// static stack
		Custom_stack<Integer> static_stack = new Custom_stack<>(5);
		static_stack.push(20);
		static_stack.push(23);
		static_stack.push(24);
		static_stack.push(25);
		static_stack.push(27);
		static_stack.push(30); // stack is full
		static_stack.display();

		System.out.println("top of the stack : " + static_stack.peek());
		System.out.println(static_stack.pop());
		System.out.println(static_stack.pop());
		System.out.println(static_stack.pop());
		System.out.println(static_stack.pop());
		// System.out.println(static_stack.pop());
		// System.out.println(static_stack.pop()); // throw exception
		static_stack.display();


		// Dynamic Stack
		Dynamic_stack<Integer> dynamic_stack = new Dynamic_stack<>(5);
		dynamic_stack.push(20);
		dynamic_stack.push(23);
		dynamic_stack.push(24);
		dynamic_stack.push(33);
		dynamic_stack.push(35);
		dynamic_stack.push(40);

		System.out.println();
		dynamic_stack.display();
		
		System.out.println("top of the stack : " + dynamic_stack.peek());
		System.out.println(dynamic_stack.pop());
		System.out.println(dynamic_stack.pop());
		System.out.println(dynamic_stack.pop());
		System.out.println(dynamic_stack.pop());
		dynamic_stack.display();

	}
}
