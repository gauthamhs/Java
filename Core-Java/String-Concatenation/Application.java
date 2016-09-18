//String Concatenation in Java !

public class Application {
	public static void main(String[] args) {

		String text_1 = "Hello Sir,";
		String text_2 = "How have you been ?.";
		String text_3 = "I will get the car,";
		String text_4 = "Please wait downstairs.";

		String complete_text = text_1 + " " + text_2 + " " + text_3 + " " + text_4; // Concatenating strings.
		
		// However this is an inefficient method since new strings are created and aren't added to existing string 
		// consuming lot of memory and causing memory overhead. 
		// However for this program, it should be fine since few variables are used.
		
		System.out.println(complete_text); // Printing the concatenated string.

		// You can add another string just by using the '+' sign.
		String greet = "Thank you !!";
		System.out.println(complete_text + greet);
	}
}
