//Sorting Lists.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", name: " + name;
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

}

class Sorting_by_Length implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 > len2) {
			return 1;
		} else if (len1 < len2) {
			return -1;
		}
		return 0;
	}

}

class Alphabetical_Sorting implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return -s1.compareTo(s2); // Displays, reverse alphabetical order
				          // Use (+) if you want natural alphabetical order
	}
}

class Integer_Sorting implements Comparator<Integer> {

	@Override
	public int compare(Integer i1, Integer i2) {
		return i1.compareTo(i2); // Second way of sorting integer in natural order.
	}
}

		//////////////////////// Sorting Lists //////////////////////////////////////////

public class Application {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		Alphabetical_Sorting alpha = new Alphabetical_Sorting();

		list.add("America");
		list.add("India");
		list.add("France");
		list.add("Yugoslavia");
		list.add("Brazil");
		list.add("Japan");

		// Without sorting Strings

		System.out.println(list); // For printing everything in a list

		for (String lists : list) {
			System.out.println(lists); // Printing it one by one.
		}
		System.out.println();

		// Sorting Strings in natural order( Alphabetical Order) #1

		Collections.sort(list); // Sorts in natural order(Alphabetical Order)
		System.out.println(list);

		for (String lists : list) {
			System.out.println(lists); // Printing it one by one.
		}
		System.out.println();

		// Sorting Strings in Reverse natural order( Alphabetical Order) #2

		Collections.sort(list, alpha); // Sorts in natural order(Alphabetical Order)
		System.out.println(list);

		for (String lists : list) {
			System.out.println(lists); // Printing it one by one.
		}
		System.out.println();

		// Sorting Strings based on Length.

		Collections.sort(list, new Sorting_by_Length()); // Sorts based on length
		System.out.println(list);

		for (String lists : list) {
			System.out.println(lists); // Printing it one by one.
		}
		System.out.println();

		///////////////////// Sorting Numbers //////////////////////////////////////////

		List<Integer> list1 = new ArrayList<Integer>();
		Integer_Sorting beta = new Integer_Sorting();

		list1.add(88);
		list1.add(43);
		list1.add(22);
		list1.add(67);
		list1.add(59);
		list1.add(03);

		// Without sorting Numbers

		System.out.println(list1); // For printing everything in a list

		for (Integer lists : list1) {
			System.out.println(lists); // Printing it one by one.
		}
		System.out.println();

		// Sorting Numbers in Natural order #1

		Collections.sort(list1);// Sorts in natural order
		System.out.println(list1);

		for (Integer lists : list1) {
			System.out.println(lists); // Printing it one by one.
		}
		System.out.println();

		// Sorting Numbers in Natural order #2

		Collections.sort(list1, beta);// Sorts in natural order
		System.out.println(list1);

		for (Integer lists : list1) {
			System.out.println(lists); // Printing it one by one.
		}
		System.out.println();

		///////////////////////// Sorting Objects //////////////////////////////////

		List<Person> list2 = new ArrayList<Person>();

		Person p1 = new Person(45, "Beth");
		Person p2 = new Person(31, "Rogen");
		Person p3 = new Person(87, "Halley");
		Person p4 = new Person(03, "Jeremy");
		Person p5 = new Person(11, "Venkatesh");
		Person p6 = new Person(90, "Courtney");

		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		list2.add(p4);
		list2.add(p5);
		list2.add(p6);

		// Unsorted Objects.

		/* Collections.sort(list2); */// Wont work because the Collections cannot go inside an object.
					     //and because Objects don't follow a natural order.

		System.out.println(list2);
		System.out.println();

		for (Person lists : list2) {
			System.out.println(lists); // Printing it one by one.
		}

		// Sorting Based on ID.

		Collections.sort(list2, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				if (p1.getId() > p2.getId()) { //Sorting earlier in the list
					return 1;
				} else if (p1.getId() < p2.getId()) { // Sorting later in the list
					return -1;
				}
				return 0;
			}
		});
		System.out.println();
		System.out.println(list2);

		for (Person lists : list2) {
			System.out.println(lists); // Printing it one by one.
		}
		System.out.println();

		// Sorting Based on Name

		Collections.sort(list2, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return (p1.getName()).compareTo(p2.getName()); //Anonymous Class
			}
		});

		System.out.println();
		System.out.println(list2);

		for (Person lists : list2) {
			System.out.println(lists); // Printing it one by one.
		}
		System.out.println();
	}
}
