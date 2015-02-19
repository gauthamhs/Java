// Second Method of Starting a class- Implementing the runnable interface.

class Running implements Runnable {
	public void run() { // Our Own Run method for our own thread
		for (int i = 0; i < 8; i++) {
			System.out.println("Thread Running: " + i);
			try {
				Thread.sleep(500); // Pauses the run method for 500 ms.. The value inside the bracket is 500ms.
			} catch (InterruptedException e) { // Interrupted exception usually occurs due to lack of resources.
				e.printStackTrace();
			}
		}
	}
}

public class Application2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Running()); // Way to implement a class by implementing runnable interface
		                                       // by passing it to the constructor.
		t1.start();

		Thread t2 = new Thread(new Running());
		t2.start();
	}
}
