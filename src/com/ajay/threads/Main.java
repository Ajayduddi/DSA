package com.ajay.threads;

public class Main extends Thread {
	
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	// The JVM automatically creates one main thread to execute the main() method
	public static void main(String[] args) {
		Main obj = new Main(); // thread is created and presented at new state
		obj.start(); // thred is started and go to runnable state when we call the start() method

		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
