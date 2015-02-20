//Thread Pool is a way of managing different threads at the same time so that the program can work efficiently.
//Its analogous to workers in a factory. There are say 5 tasks and each worker is given a specific task.

//In this method. when one worker is done with a task or say that a task is completed, the idle worker is 
//assigned a new task.

//The first three output statements run at the same time.When a thread has completed a task, the same thread
//is assigned another task.

//Executor provides methods to manage termination and methods to keep tracking progress of one
//or more asynchronous tasks.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Worker implements Runnable{

	private int id;
	
	public Worker(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Task Running: " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		 // Once the task is running, it has to wait 5 seconds to display 
		// The task completed.
			e.printStackTrace();
		}
		System.out.println("Task completed: " + id) ;
	}
}
public class Application {
	public static void main(String[] args) {
		
        // Worker worker = new Worker();
		/*worker.run();
		Thread t1 = new Thread(worker);
		t1.start();*/
		
		ExecutorService executor = Executors.newFixedThreadPool(3); // Setting up the no. of threads assigned
		 // for a task using the executor service. In this code, three threads from the thread pool are assigned
		
		for(int i=0;i<10;i++){              // i pertains to the no. of tasks the thread has to perform
			executor.submit(new Worker(i)); // All the tasks has been submitted.
		}
		executor.shutdown(); //The shutdown() method will allow previously submitted tasks to execute before terminating
		
		System.out.println("All tasks submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS); //Tells the executor how much time it should wait
			                                // until all tasks have completed execution.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All Tasks Completed"); // Says when a task is completed.
	}
}
