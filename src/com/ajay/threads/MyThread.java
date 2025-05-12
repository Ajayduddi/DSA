package com.ajay.threads;

public class MyThread extends Thread {

	MyThread(String name) {
		super(name);
	}

	MyThread() {

	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " - priority : "
						+ Thread.currentThread().getPriority() + " values : " + i);
			}
		}
		catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		MyThread t1 = new MyThread("low-priority");
		MyThread t2 = new MyThread("normal-priority");
		MyThread t3 = new MyThread("high-priority");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}
