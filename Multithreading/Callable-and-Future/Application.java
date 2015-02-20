//Callable and Future is mainly used if you want to return a value such as duration of the thread sleeping.

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		/*
		 * executor.submit(new Runnable() { 
		 * public void run() { 
		 * try { 
		 * Random random = new Random (); 
		 * int duration = random.nextInt(4000);
		 * System.out.println("Starting Soon...");// This is the general method for handling thread pool Thread.sleep(duration); 
		 * } catch(InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); 
		 * } System.out.println("Process ended."); } 
		 * });
		/*
		 * executor.shutdown(); executor.awaitTermination(1, TimeUnit.DAYS);
		 */

		// Supposing we want to return the value of the duration,
		// we use something called as the callable and the future.
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);

				System.out.println("Starting Soon...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (duration > 2000) {                    
					throw new IOException("sleeping...");
				}
				System.out.println("Process ended");
				return duration;
			}
		});
		executor.shutdown();
		// executor.awaitTermination(1, TimeUnit.DAYS); No need to use this
		// statement here as future.get
		// blocks awaiting requests.
		
		try {
			System.out.println("The value of the duration is: " + future.get());
		} catch (ExecutionException e) {
			//e.printStackTrace(); // Prints IOException as Execution Exception..
			//System.out.println(e.getMessage()); //Prints the message along with the exception.
			
		//IOException io = (IOException) e.getCause();
			//System.out.println(io.getMessage()); // Throws only the message.
		}
		  catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
