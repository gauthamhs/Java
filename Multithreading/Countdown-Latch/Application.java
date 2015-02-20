// Using the Countdown Latch.
// A synchronization aid that allows one or more threads to wait 
// until a set of operations being performed in other threads completes. 
// Suppose, if three threads are working on 3 different tasks, 
// they don't start a new task until a certain task has been completed.

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

	class Runner implements Runnable {
		private CountDownLatch latch;
		public Runner(CountDownLatch latch) {
			this.latch = latch;
		}

		public void run() {
			System.out.println("Starting Tasks...");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Tasks Completed.");
			System.out.println(latch.getCount());
			latch.countDown(); // Decrements the count of the latch, releasing all waiting threads 
			                   // if the count reaches zero.
		}
	}

public class Application {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(6); // Latch count
		ExecutorService executor = Executors.newFixedThreadPool(3); // No. of threads working on the task.
		for (int i = 0; i < 6; i++) {
			executor.submit(new Runner(latch));
		}
		try {
			latch.await(); //  The await methods block until the current count reaches zero due to 
			//invocations of the countDown() method after which all waiting threads are released.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
