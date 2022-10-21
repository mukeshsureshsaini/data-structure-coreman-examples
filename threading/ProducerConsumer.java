package com.alpha.threading;

public class ProducerConsumer {

	public static void main(String[] args) {

		Printer p = new Printer();

		Producer producer = new Producer(p);
		Consumer consumer = new Consumer(p);

		producer.start();
		consumer.startConsumer();

	}

}

class Printer {

	private volatile boolean isfull = false;

	private int data;

	synchronized public void put(int i) {
		while (isfull) {
			try {
				wait();
			} catch (InterruptedException r) {

				System.out.println("Suprious wake up occured");
			}
		}
		data = i;
		isfull = true;
		notify();

	}

	synchronized public int get() {

		while (!isfull) {

			try {
				wait();
			} catch (InterruptedException r) {

				System.out.println("Suprious wake up occured");
			}
		}

		isfull = false;
		notify();
		return data;
	}
}

class Producer implements Runnable {

	private Printer p;
	private Thread t;

	public Producer(Printer p) {
		t = new Thread(this);
		this.p = p;
	}

	@Override
	public void run() {

		for (int i = 1; i < 10; i++) {

			try {
			//	System.out.println("...............Producer Sleeping.............");
				Thread.sleep(2200L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
			p.put(i);
			System.out.println("Producing :" + i);
			System.out.println();
		}

	}

	public void start() {
		t.start();
	}

}

class Consumer implements Runnable {

	private Printer p;
	private Thread t;

	public Consumer(Printer p) {
		t = new Thread(this);
		this.p = p;
	}

	@Override
	public void run() {

		for (int i = 1; i < 10; i++) {

			try {
				//System.out.println("...............Consumer Sleeping.............");
				Thread.sleep(2500L);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Consuming :" + p.get());
			System.out.println();

		}

	}

	public void startConsumer() {
		// to make sure escape of this context is not happening
		t.start();
	}

}