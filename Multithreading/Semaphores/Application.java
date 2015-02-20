//Semaphores are something that maintains count and provides controlled access to resources in a multithreaded environment.
// The acquire() function acquires permit and decreases count.
//The release() function releases permit and increases count.
//sem.availablePermits counts the no. of current available permits.

//Semaphores are mainly used to limit the number of simultaneous threads that
//can access a resources.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Application {
	public static void main(String[] args) throws InterruptedException {
	
/*	Semaphore sem = new Semaphore(1);
	System.out.println("The no. of initial available permits is: " + sem.availablePermits());
	sem.acquire();
	System.out.println("The no. of available permits after acquire is: " + sem.availablePermits());
	sem.release();
	System.out.println("The no. of available permits after release is: " + sem.availablePermits());*/
	
	ExecutorService executor = Executors.newCachedThreadPool();
	for(int i = 0;i<200;i++){
		executor.submit(new Runnable(){
			public void run(){
				Connection.getInstance().do_Connect();
				}
			});	
	}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}
}
