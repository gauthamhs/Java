// A simple implementation of using the toString() Method.

//First you use a constructor to set an id and a name
//Then you use the toString() method to display those values.

// The default toString() returns classname@hashcodevalue

class Stringing {
	private String name;
	private int id;

	public Stringing(int id, String name) { // Develop a constructor with String name and Integer id.
		this.name = name;
		this.id = id;
	}

	/*
	 * public String toString() { // Inefficient as it converts primitive id to
	 * non-primitive and adds strings that uses up a lot of memory. return id +
	 * ": " + name; }
	 */

	// 1st Efficient Method

/*	public String toString() {
		return String.format("%d: %s", id, name);
	}*/

	// 2nd Efficient Method

	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append(id).append(": ").append(name);
		return text.toString();
	}
}

public class Application {
	public static void main(String[] args) {
		Stringing Stringing1 = new Stringing(5, "Bunny");
		Stringing Stringing2 = new Stringing(10, "Biggy");

		System.out.println(Stringing1.toString());
		System.out.println(Stringing2.toString());
	}
}
