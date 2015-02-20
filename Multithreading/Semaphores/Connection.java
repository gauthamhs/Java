//Semaphores ....

import java.util.concurrent.Semaphore;

public class Connection {

	private Semaphore sem = new Semaphore(10, true); // Defining the semaphores, Permits = 10.
	// True states that the first thread that calls for the resource acquires the resource. FIFO.

	private static Connection instance = new Connection(); // Creating a new instance of Connections class
	private int connections = 0;

	public static Connection getInstance() { // way to access the instance class.
	return instance;
	}

	public void connect() { // This is a good coding practice. First, you acquire the semaphore, then implement
		                      // a method and then you release a semaphore.

		try {
			sem.acquire(); // This acquires a permit from the semaphore andtherefore decreases the count.
			               // If 0, wait for release.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			do_Connect();  // Implementing the do_Connect method, such as incrementing and decrementing connections, and
			               // implementing the thread sleep
		} finally {            // Using the finally still releases the permit if the method throws an exception.
			sem.release(); // This releases the permit activating waiting threads to use and therefore increase count.
		}
	}

	public void do_Connect() {
		synchronized (this) { // First block in do_Connect method where you increase the connections.
			connections++;
			System.out.println("Current connections (max 10 allowed): "
					+ connections);
		}

		System.out.println("Working on connections "
				+ Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { // Causes the program to slow down for a certain amount of time.
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {
			connections--; // decreasing the amount of connections.
			// System.out.println("I'm done " + Thread.currentThread().getName()
			// + " Connection is released , connection count: " + connections);
		}
	}
}
