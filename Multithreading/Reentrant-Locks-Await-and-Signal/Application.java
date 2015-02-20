//Using Reentrant Locks.
/*		lock.lock();
		increment();
		lock.unlock();*/ // This is not a good practice because if the increment method throws an exception,
        // The thread will never be able to unlock itself. Therefore, the unlock step always have to be executed.

//Reentrant Lock: Once the thread acquires the lock, it can lock or unlock it again.
//After thread is woken up, It has to be unlocked.

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Processors {
	
	private int count = 0; 
	private Lock lock = new ReentrantLock(); // Instantiating Reentrant Locks.
	Condition condition = lock.newCondition(); // Declaring a condition or
	      // Getting a condition object from the lock
	
	public void increment(){
		for(int i=0;i<10000;i++){
			count++;
		}
	}

	public void first_thread() throws InterruptedException{
		lock.lock(); // If other thread has to acquire the lock, it has to patiently wait.
		System.out.println("Waiting...");
		condition.await();
		Thread.sleep(5000);
		System.out.println("Processing Resumed...");
		try{
		increment();	
		}
		finally {
			lock.unlock();
		}
	}
	
	public void second_thread() throws InterruptedException{
		lock.lock(); // You have to lock before waiting.
		System.out.println("Notification is being processed");
		condition.signal();
		Thread.sleep(5000);
		System.out.println("Notification Completed");
		try{
		increment();	 // This is good Coding Practice.
		}
		finally {
			lock.unlock();
		}
	}

	public void end_method(){
		System.out.println("The value of count is: " + count);
	}
}

public class Application {
	public static void main(String[] args) throws InterruptedException {
		final Processors processor = new Processors();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.first_thread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.second_thread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		processor.end_method();
	}
}
