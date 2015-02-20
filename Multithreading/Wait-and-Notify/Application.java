import java.util.Scanner;

//Wait and notify Functions in Multithreading.
//Wait and notify can only be called within the synchronized code block
//wait() - > waits. Doesn't consume loads of system. This doesn't allow the thread to resume until
//it has received the intrinsic log or has been notified.

//Notify will notify the other thread that if its waiting it can wake up, 
//but doesn't relinquish control and still runs in that code block.

//As soon as notify is run, wait wakes up and the remaining statements are executed.

class Processors {
	public void produce() throws InterruptedException {
		synchronized (this) {  //Synchronizing on the processor itself, 
			                   //using the intrinsic log of the processor.
			System.out.println("Running System, Please wait...");
			wait();
			System.out.println("System has been Resumed after notification");
		}
	}

	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting for return key: ");
			scanner.nextLine();
			System.out.println("Return key Pressed...");
			System.out.println("Resuming Notification ");
			notify();
			Thread.sleep(5000);

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
