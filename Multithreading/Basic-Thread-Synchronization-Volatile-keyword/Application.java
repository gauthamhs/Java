import java.util.Scanner;

//Using the volatile keyword to prevent Data caching(i.e., the same variable or resource used by  different threads.

class Running extends Thread {
	private volatile boolean running = true; //Volatile keyword prevents data caching. 
	//That is if two threads are accessing the same variable at the same time, It allows for modifying those variables. 
	//Volatile keyword states that variable values will be modified by different threads

	public void run() {
		while (running) { // Some systems and Java Implementations might cache the running the running variable as always true 
		//and therefore it will never be able to execute the Shutdown method which flags the variable as false.
			System.out.println("Hello Sir");
			try {
				Thread.sleep(500); // Slows down the program for 500 ms .
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown(){
		 running = false;
	}
}

public class Application {
	public static void main(String[] args) {
		Running running1 = new Running();
		System.out.println("Please enter a return key to stop: ");
		System.out.println();
		running1.start();
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine(); // Here we are gracefully stopping the thread by hovering over to the next line which executes the shutdown method and stops the thread.
		running1.shutdown();
		System.out.println("Exited Successfully ...");
	}
}

