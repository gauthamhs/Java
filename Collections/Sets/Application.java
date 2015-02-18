//Using Sets.

import java.util.HashSet;
import java.util.Set;

public class Application {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>(); // Syntax for Set.
		Set<String> set2 = new HashSet<String>();

		// Checks if a given set is empty.

		/*
		 * if(set1.isEmpty()){
		 * //System.out.println("Set 1 is empty. Please add Elements.");
		 * System.out.println(); }
		 */

		set1.add("Lampard");
		set1.add("Ezio");
		set1.add("Altair");
		set1.add("Connor");
		set1.add("Kenway");
		set1.add("Haytham");
		set1.add("Leonardo");
		set1.add("Mario");

		// set1.add("Altair"); // Duplicate Values have no effect.

		if (set1.isEmpty()) {
			System.out.println("Set 1 is empty. Please add Elements.");
		}

		System.out.println(set1); // Displaying set 1 in the form of SET.

		set2.add("Cristiano Ronaldo");
		set2.add("Lampard");
		set2.add("Drogba");
		set2.add("Diego Costa");
		set2.add("Hazard");
		set2.add("Oscar");
		set2.add("Neymar");

		System.out.println(set2); // Displaying set 2 in the form of SET.

		System.out.println();
		for (String elements : set1) {
			System.out.println(elements); // Displays one by one.
		}
		System.out.println();

		// Next, we can check if a set contains a given item.

		if (set1.contains("Kenway")) {
			System.out.println("Element found !");
		} else {
			System.out.println("Element not found");
		}

		// Intersection of a set.

		Set<String> intersection = new HashSet<>(set1);
		//System.out.println(intersection);
		intersection.retainAll(set2); // Retains the elements that are common to both sets(Intersection)
		System.out.println(intersection);

		// Difference of a set.

		Set<String> difference = new HashSet<>(set2);
		difference.removeAll(set1); // Removes the elements that are common to both the sets(and set1 here) 
		                            // and displays the created set(Difference).
		System.out.println(difference);
	}
}
