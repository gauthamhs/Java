package org.beginner.application;

//Switch Statement
//Switch( as the name suggests) is used to switch between choices.
//The switch statement will execute the case based on the argument or input provided.
//Otherwise, the default case will be executed.

import java.util.Scanner;

public class Switch {
	
	private static Scanner input;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		System.out.println("Please enter any of the following commands - 1, 2 :");
		Integer intVal = input.nextInt();
		switch (intVal) {

		case 1:
			System.out.println("Rebooting the PC");
			break;

		case 2:
			System.out.println("Shutting down");
			break;

		default:
			System.out.println("Command not recognized");
		}
	}
}

