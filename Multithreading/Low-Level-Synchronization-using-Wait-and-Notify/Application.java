//Low level Producer-Consumer Multithreading Programming.

//Wait and notify Functions in Multithreading.
//Wait and notify can only be called within the synchronized code block
//wait() - > waits. Doesn't consume resources of system. This doesn't allow the thread to resume until
//it has received the intrinsic log or has been notified.

//Notify will notify the other thread that if its waiting it can wake up, 
//but doesn't relinquish control and still run.

//As soon as notify is run, wait wakes up and the remaining statements are executed.

//You have to wait and notify on the object you are locking on, Here it is lock.

import java.util.LinkedList;
import java.util.Random;

class Processors {
	LinkedList<Integer> list = new LinkedList<Integer>();
	Object lock = new Object();
	private final int LIMIT = 10;

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock) {
				while (list.size() == LIMIT) { // Only add items to a certain limit.
					lock.wait();
				}
				list.add(value++); // Adding Values to the list
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {

		while (true) {
			Random random = new Random();
			synchronized (lock) {
				while (list.size() == 0) {
					lock.wait();
				}
				int value = list.removeFirst(); // Remove the first item, FIFO
												// technique
				System.out.print("List Size: " + list.size());
				System.out.println(", Value: " + value);
				lock.notify();

			}
			Thread.sleep(random.nextInt(100)); // The consumer runs slower so that elements are removed
											   // slowly from the list.
		}
	}
}

public class Application {
	public static void main(String[] args) throws InterruptedException {
		final Processors processor = new Processors();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
