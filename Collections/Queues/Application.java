
//An ArrayBlockingQueue follows a FIFO(First in, First out) Method where the first one that enters the queue
//will be the first one that exits from the queue. Also the start of the queue is called the head and the 
//end of the queue is called the tail. Elements are added at the end of the queue and exits from the head.
//Array Blocking Queues have a fixed size.

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Application {
public static void main(String[] args) {
	
	
/////////////////////////////// Add, Remove and Examine //////////////////////////////////////
	                       // (Throws Exceptions) //
	
Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(3); //Syntax for Array Blocking Queue of Size 3
//Specified inside the brackets.


//System.out.println(q1.element()); // No Such element exception
//Adding items to the Queue
	
	q1.add(55); //Since three elements are added, the head of the queue is usually the element that is added first.
	q1.add(23);
	q1.add(41);
	/*try {
		q1.add(12); // Cannot add 4th element because size is 3.
	} catch (Exception e) {
		System.out.println(e + " - Size is full, can't add any more items into the Queue"); // Illegal State Exception
	}*/
	
	System.out.println("The head of the queue is: " + q1.element()); // Gives the value of the head in the queue.
	//System.out.println();
	//System.out.println(q1);
	System.out.println();
	for(Integer values:q1){
		System.out.println("Value Added:  " + values);
	}
	System.out.println();
	
	
	
	System.out.println("Value Removed: " + q1.remove());
	System.out.println("Value Removed: " + q1.remove());
	System.out.println("Value Removed: " + q1.remove());
	
	System.out.println();
	/*try {
		System.out.println("value removed: " + q1.remove());
	} catch (Exception e) {
		System.out.println(e +  "Size is empty, Unable to remove further element"); // NoSuchElementException exception
	}*/
	
	/////////////////////////////// Offer, Peek, and Poll(Doesn't throw exceptions, shows null values) //////////////////////////////////////
	Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(3);
	
	// Peeking at values- Gives the value of the header
	
	//Offering Values - Adds Items.
	System.out.println(q2.peek()); // Returns a null value
	q2.offer(33);
	q2.offer(44);
	q2.offer(55);
	
	/*System.out.println("Peeking values: " + q2.peek());*/
	System.out.println("Peeking values: " + q2.peek()); //Gives the Head Value.

	if(q2.offer(66)==false){
		System.out.println("Queue is full, This value cannot be offered");
	}; // Will return False and therefore will not be added
	
	for(Integer values:q2){
		System.out.println("Value Offered:  " + values);
	}
	
	// Polling Values - Removes items.
	
	System.out.println("Values Polled: " + q2.poll());
	System.out.println("Values Polled: " + q2.poll());
	System.out.println("Values Polled: " + q2.poll());
	System.out.println("Values Polled: " + q2.poll()); //Can't poll 4th element, since size is 3,
	//But doesn't throw an exception.

}
}


