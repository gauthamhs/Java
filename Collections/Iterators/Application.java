//Using Iteration operator for LinkedLists.

import java.util.Iterator;
import java.util.LinkedList;

public class Application {
	public static void main(String[] args) {
		LinkedList<String> cars = new LinkedList<String>();
		
		cars.add("Subaru");
		cars.add("Audi");
		cars.add("BMW");
		cars.add("Acura");
		cars.add("Infiniti");
		
		System.out.println(cars);
		
		//Iterators.
		
		Iterator<String> car_iterator = cars.iterator(); //Syntax and defining an Iterator.
		//System.out.println(car_iterator.next()); // Prints ony first element.
		
		while(car_iterator.hasNext()){ // You can remove or add elements when using the iterator functions.
			String val = car_iterator.next();
			
			if(val.equals("Audi")){ // Audi Can be seen because we are outputting before removing it
				car_iterator.remove();
			}
			System.out.println(val); // Looks at the next item in the list.
		}
		
		//Modern way of printing through iteration... But cannot remove while looping.
		
		System.out.println();
		for ( String car: cars){
			System.out.println(car);
		}
		}		
	}

