package com.ajay.threads;

public class RunnableInterfaceThread implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	// The JVM automatically creates one main thread to execute the main() method
	public static void main(String[] args) {
		RunnableInterfaceThread obj = new RunnableInterfaceThread(); // insance created

		/*
		 * the Runnable interface don't have start method to start the thread. so we create a new instance of the thread and pass the obj refer through it.
		 */
		Thread t1 = new Thread(obj); // Thread is created and present at the new state. 
		t1.start(); // thred is started and go to runnable state when we call the start() method

		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}
