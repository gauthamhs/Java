//Array of Strings

public class Application {
	public static void main(String[] args) {
		// Declare array of (references to) strings.
		String[] words = new String[3]; // Syntax: String[] variable_name = new String[size];
		
		// Set the array elements (point the references at strings)
		words[0] = "Apple";
		words[1] = "Mango";
		words[2] = "Guava";

		// Access an array element and print it.
		System.out.println(words[2]);

		// Simultaneously declare and initialize an array of strings
		String[] fruits = { "apple", "banana", "pear", "kiwi" };

		// Iterate through an array: Also called For..each : 1st method 
		for (String fruit : fruits) {
			System.out.println(fruit);
		}

		// Iterate through an array: Standard for loop : 2nd Method
		for (int i = 0; i < fruits.length; i++) {
			System.out.println(fruits[i]);
		}

		// "Default" value for an integer
		int value = 0;

		// Default value for a reference is "null"
		String text = null;

		System.out.println(text); // Prints null value

		// Declare an array of strings
		String[] texts = new String[2];

		// The references to strings in the array
		// are initialized to null.
		System.out.println(texts[0]); // When you create a new array object, it
					      // is always initialized to null;

		// But of course we can set them to actual strings.
		texts[0] = "one";
		System.out.println(texts[0]);
		}
}
