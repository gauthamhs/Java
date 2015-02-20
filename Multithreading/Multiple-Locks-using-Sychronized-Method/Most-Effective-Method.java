//This is the most efficient way. Two threads used different methods more effectively.
//Two threads can run two methods at the same time. However, the intrinsic log rule still applies for independent methods.

package third;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
	
public class Element3 {
	
	class Runner implements Runnable{
		@Override
		public void run() {
			processing();
		}
	}
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	Random random = new Random();
	Object Lock1 = new Object();// Using Objects is always better, instead of lists, Otherwise things get complicated.
	Object Lock2 = new Object();// Locking on actual numbers can be troublesome. Locking on objects is good practice.
	
	
	public void first_Stage(){ // Adding numbers to list 1, with a sleep of 1 ms.
		synchronized(Lock1){
			try {
				Thread.sleep(1);            //Saying that adding no's take some time.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			list1.add(random.nextInt(100)); //Adding random numbers to the list.
			
		}
	}
	
	public synchronized void second_Stage(){ // Adding numbers to list 2, with a sleep of 1 ms.
		synchronized(Lock2){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			list2.add(random.nextInt(100));
		}
	}
	
	public void processing(){ // Calls the two stages in a loop, Depending on how many numbers you need.
		for( int i =0; i<1000;i++){
			first_Stage();
			second_Stage();
		}
		
	}
	public void main(){
		
		System.out.println("Count Starting, Please wait... ");
		long start = System.currentTimeMillis(); //Start time
		
		Runner runner = new Runner();
		Thread t1 = new Thread(runner); 
		Thread t2 = new Thread(runner);
		
		t1.start();
		t2.start();  // Run thread
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {     // Using threads, Removes a huge load of the computer.
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//processing(); //Without running threads, Slows down the process.

		long end = System.currentTimeMillis(); //End time
		System.out.println("Time Taken: " + (end - start) ); // Calculation of time
		System.out.println("List1: " + list1.size() + ", List2: " + list2.size()); // Calculates the no. of elements in the list.

	}
}

