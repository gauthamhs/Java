//Complex Data Structures. 

// In this method we pick drivers pertaining to their vehicles.

// For Example: ambulance : {"Fred,"Sue,"Pete"}
//              helicopter: {"Sue", "Richard", "Bob", "Fred" }
//              lifeboat  : { "Pete", "Mary", "Bob" }

//Here, We use a mapping method that consists of Keys and Values, where we use the vehicles as keys 
// and the drivers as the values pertaining to those keys.

//SO the syntax is a Map(String(i.e., Vehicles),Set<String>(Drivers) ). Further Details are explained in the program.

import java.util.HashMap; // Importing all the Java Collections Required for this Program.
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Application {

	public static String[] vehicles = { "ambulance", "helicopter", "lifeboat" }; // Data

	public static String[][] drivers = { { "Fred", "Sue", "Pete" },
			                             { "Sue", "Richard", "Bob", "Fred" }, 
			                             { "Pete", "Mary", "Bob" }, 
			                             }; // Data

	public static void main(String[] args) { // Main Program
		Map<String, Set<String>> Personnel = new HashMap<String, Set<String>>(); // Defining the syntax.
		// Herewe use Hashmap, not a treemap(sorts in natural order) because we want the keys as it is and unchanged.
		for (int i = 0; i < vehicles.length; i++) {
			String Vehicle = vehicles[i]; // Defining out first parameter String where we will load out keys
			// System.out.println(Vehicle);
			String[] DriverListing = drivers[i]; // Storing values in a DriverListing Array

			Set<String> Drive = new LinkedHashSet<String>(); // We are using a LinkedHashset because we want the 
			                                                 // set names to be in the same order

			// System.out.println(Drive);

			for (String values : DriverListing) {
				Drive.add(values); // Adding Driver values pertaining to certain key into the empty set.
				// System.out.println(values);
				// System.out.println(Drive);
			}

			Personnel.put(Vehicle, Drive); // Assigning the key to the pertaining values
			                               // ( Eg: Ambulance = {Fred,Sue,Pete})
			// System.out.println(Personnel);
		}

		// If you need values of just one key

		{
			Set<String> Values_in_a_key = Personnel.get("lifeboat"); // lifeboat is the key and 
			                   // Personnel.getkey() gets all the values pertaining to that key.

			// System.out.println(Values_in_a_key); // Printing the values in the form of set.
			for (String values : Values_in_a_key) {
				// System.out.println(values); // Printing the values one by one.
			}
		}
		// Iterating the whole thing.

		for (String Values1 : Personnel.keySet()) { // Personnel.keySet() contains all the key values.
			System.out.print(Values1);
			System.out.print(": ");
			Set<String> Values_in_a_key = Personnel.get(Values1); // Gets all values pertaining to the key.

			//System.out.print(Values_in_a_key);

			for (String Vals : Values_in_a_key) {
				System.out.print(Vals);
				System.out.print(" ");

			}
			System.out.println();
		}
	}

}
