// First Method of Starting a Thread - Extending Thread Class.

class Running extends Thread{
	
	public void run(){ // Our Own Run method for our own thread
		for(int i =0;i<8;i++){
			System.out.println("Thread Running: " + i);
			try {
				Thread.sleep(500); // Pauses the run method for 500 ms. The value inside the bracket is 500ms.
			} catch (InterruptedException e) { // Interrupted exception usually occurs due to lack of resources.
				e.printStackTrace();
			}
		}
	}
}

public class Application1 {
	public static void main(String[] args) {
		Running running1 = new Running();
		running1.start(); //Always use the start method because the run() method will run the main thread method
		                 // but start() will look for the run() method defined in our own thread class.
		
		//Two threads can run concurrently at the same time. For Example:
		
		Running running2 = new Running();
		running2.start(); // When you run the program, you see that the threads run at the same time.
			
	}
}
