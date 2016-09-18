//Using String Builder and String Formatting options

public class Application {
	public static void main(String[] args) {
		
		 // Inefficient Method of Concatenating Strings.
		 
/*		 String Text = ""; 
		 Text += " How are you sir ?"; 
		 Text += ". Would you like some tea"; 
		 System.out.println(Text);*/
		 
/*		 Strings are immutable objects. Once you create a string object, its values cannot be modified.
                 Because the original string is "" and you don't modify it, since you just keep
		 adding new Strings to it. This could take a lot of memory and is therefore
		 undesirable.*/

		// Efficient Method
		//Doesn't Create new string, Modifies existing string using the StringBuilder Method.
		
		//////////////////////////// String Builder /////////////////////////////////////
		
		// 1st Method of Appending Strings using StringBuilder
		
		StringBuilder Text = new StringBuilder();
		Text.append("");                     
		Text.append("How you doing ?");
		System.out.println(Text.toString());
		
		// 2nd method of appending( Method Chaining using StringBuilder)
		
		StringBuilder Text1 = new StringBuilder();
		Text1.append("Hey Man ?.") .append(" What's the time") .append(". I need to know"); 
		System.out.println(Text1.toString());
		
		/////////////////////////// String Formatting  ////////////////////////////////
		
		//Newline and Tabs;
		
		System.out.println("Hi, I am good. \t What about you \nOk");// \t tab \n newline
		
		// Formatting integers
		// %-10d means: output an integer in a space ten characters wide,
		// padding with space and left-aligning (%10d would right-align)
		System.out.printf("The cost of two pens is %d %f", 25, 4.77 );
		System.out.println("\n");
		// Demo-ing integer and string formatting control sequences
        for(int i=0; i<20; i++) {
            System.out.printf("%2d %s\n", i, "here is some text"); //Providing width of 2 so that all numbers
                                                                   //are equally aligned.
        }
        
        // Formatting floating point value
         
        // Two decimal places:
        System.out.printf("Total value: %.2f\n", 5.6874); // Put how many decimal places you need between % and f
         
        // One decimal place, left-aligned in 6-character field:
        System.out.printf("Total value: %-6.1f\n", 343.23423);
         
        // You can also use the String.format() method if you want to retrieve
        // a formatted string.
        String formatted = String.format("This is a floating-point value: %.3f", 5.12345);
        System.out.println(formatted);
         
        // Use double %% for outputting a % sign.
        System.out.printf("Giving it %d%% is physically impossible.", 100);
	}
}
