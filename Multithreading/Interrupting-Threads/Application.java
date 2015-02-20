import java.util.Random;

//Interrupting threads.

//Interrupting threads wouldn't stop the program in general, but would interrupt it for a certain amount
//of time after which the program resumes.
 
//Also adding a Thread.sleep(1) for 1ms in the loop for each calculation will interrupt the thread which
//could be verified using the sysout function.

public class Application {
public static void main(String[] args) throws InterruptedException {
	Thread t1 = new Thread(new Runnable() {
		public void run(){
			
			System.out.println("Thread Starting... ");
			Random random = new Random();
			for(int i =0;i<1E8;i++){
				if(Thread.currentThread().isInterrupted()){
					System.out.println("Thread has been interrupted. ");
					break;
				}
				Math.sin(random.nextDouble());
			}
			System.out.println("Thread Stopped...");
		}
	});
	t1.start();
	t1.interrupt();
	t1.join(); // Mainly used in Looping
	
}


}
