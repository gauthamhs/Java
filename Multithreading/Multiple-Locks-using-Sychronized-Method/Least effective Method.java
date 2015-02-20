//This Implementation Will cause an Error Index OUT of Bounds Exception because lot of things are going around. 
//Two threads accessing the same resource will make the list go crazy. We don't get 2000 items in each list. 
//Because they are sharing the same data. This causes thread interleaving.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
	
public class Element1 {
	
	class Runner implements Runnable{

		@Override
		public void run() {
			processing();
		}
	}
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	Random random = new Random();
	
	public void first_Stage(){ // Adding numbers to list 1, with a sleep of 1 ms.
		try {
			Thread.sleep(1);  // Time given to add some numbers.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list1.add(random.nextInt(100)); //Adding random numbers to the list.
	}
	
	public void second_Stage(){ // Adding numbers to list 2, with a sleep of 1 ms.
		
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


