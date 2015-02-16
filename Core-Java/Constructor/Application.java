//Constructors: They are mainly used to initialize the state of the variable.

class Constr {
	String Name;
	int Age;

	public Constr() { // A constructor with no Parameters;
		this(45, "Ronnie"); // Calling a constructor inside a constructor using "this" keyword.
		                    // Note: Invoking a constructor from another has to be on the first line.
		System.out.println("Initiazing 2nd constructor !"); // All Constructors must have same name
		                                                    // Only Parameter changes.
		Name = "Bernadette";
		Age = 45;
	}
	
	public Constr(int Age){
		//this(); //Using this will invoke the no-argument constructor,which will in turn invoke the two argument
		          //contructor inside that contructor.
		System.out.println("Initializing Third Constructor!"); // A constructor with one parameter 
		this.Age = Age;
	}
	
	public Constr(int Age, String Name){ // A constructor with two parameters
		System.out.println("Initializing First Constructor!");
		this.Name = Name;
		this.Age = Age;
	}
	
}

public class Application {
	public static void main(String[] args) {
		Constr Constr_1 = new Constr(); // Creates a new constructor object using Constructor class, invokes constructor
		new Constr(); // invokes Constructor class when an object is created.
		Constr Constr_2 = new Constr(44); //Invokes the one argument constructor.
		Constr Constr_3 = new Constr(56, "clyde"); //Invokes the two argument constructor.
	}
}
