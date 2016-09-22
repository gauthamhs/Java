
//Unlike a while loop, in a for loop, the initialization, expression and incrementing the values
//are all done inside a single bracket.

public class ForLoop {
	public static void main(String[] args) {

		// A simple For Loop.

		// Initialization(executes before the loop),
		// Condition(check for executing the loop, else break),
		// Incrementing(done after the loop is executed).

		for (int i = 0; i < 10; i++) {
			System.out.println("Count: " + i);
		}
		
		// For Each Loop.
		
		// A for-each loop is used if you want to iterate over an array or an iterable.
		// A for each loop is must faster than for loop
		

		String[] names = { "Joey", "Richard", "Blanchett", "Madison", "Patrick", "Nicole" };
		for (String name : names) {
			if (name.equals(names[(names.length)-1])) {
				System.out.println(name);
			} else {
				System.out.print(name + ", ");
			}
		}
	}
}
