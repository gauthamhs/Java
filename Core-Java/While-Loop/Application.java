//Simple While loop
//Here, we will print a statement until its true. When the statement is false, it exits out of the loop.

public class Application {
	public static void main(String[] args) {
		int value = 0; // Initializing the value to 0, which however is not required as Java automatically 
		               // initializes a variable to zero. 
		
		while(value<10){ // While(true) execute statements inside the code-block, else exit.
			System.out.println("Count: " + value);
			value++; // Increments the value in the loop, which would otherwise lead to infinite looping
		}
	}
}
