//Using the Synchronized keyword for Basic Thread Synchronization.

// Notes: 

//Without join, Count is 0; because start spawns a new thread. Thread 1 executes, in the main thread Thread 2
//Executes and then sysout executes and then the loops run, so count is 0.

//So we have to wait until loops finish running. SO we use join() to wait until threads are finished.

// If you don't do synchronize the threads, This will cause thread interleaving. 
//Even volatile wont help, because the main problem doesn't deal with data caching.

// Adding the synchronized keyword : Every object has an intrinsic log. If you call synchronized method,
//you have to acquire intrinsic log before you call it. and only one thread can acquire it. THe second thread 
//have to wait until the first thread releases it after it's done. So using the synchronized keyword fixes it.

// Use this when you have multiple threads accessing the same resource.

public class Application {
	class Runner implements Runnable{
		@Override
		public void run() {
			increment();
		}
	}
	
	private int count = 0;
	
	public synchronized void increment(){
		for(int i =0; i<100000;i++){ // i needs to be large to display the synchronization problem.
			count++;
		}
	}
	
	public void do_all_work() { 
/*		Thread t1 = new Thread(new Runnable(){ // First method : Implementing Runnable interface using anonymous class.
			@Override
			public void run() {
				for(int i=0;i<10000;i++){
				count++;
				}
				increment();
			}	
		});*/
		
/*		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i = 0;i<10000;i++){
					count++;
				}
				increment();
			}	
		});*/
		Runner runner = new Runner();
		
		Thread t1 = new Thread(runner); // Second Method using the runnable interface.
		Thread t2 = new Thread(runner);
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); // Waits for the threads to finish looping.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count is: " + count);
	}
	
	public static void main(String[] args) {
		Application application = new Application();
		application.do_all_work();
	}
}
