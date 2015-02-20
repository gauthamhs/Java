// Synchronizing the method will successfully run the program with both lists having equal no. of items.
//But takes a lot of time, since one thread has to wait for the other thread to finish using the intrinsic log. 
//Also synchronizing the methods will not cause the idle thread to access the second stage. So, it takes
//double the time.

package second;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
	
public class Element2 {
	class Runner implements Runnable{
		@Override
		public void run() {
			processing();
		}
	}
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	Random random = new Random();
	
	public synchronized void first_Stage(){ // Adding numbers to list 1, with a sleep of 1 ms.
		try {
			Thread.sleep(1); // Time given to add more numbers.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list1.add(random.nextInt(100)); //Adding random numbers to the list.
	}
	
	public synchronized void second_Stage(){ // Adding numbers to list 2, with a sleep of 1 ms.
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list2.add(random.nextInt(100));
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


