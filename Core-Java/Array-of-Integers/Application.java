// Defining an array of integers.

package org.beginner.application.arrays;

public class ArrayIntegers {

		public static void main(String[] args) {
			
			int[] values = new int[3]; // Defining a array. 
			                           // Syntax - > int[] variable_name = new int[size]
			                           // Creating array objects of size 3
			
			System.out.println(values[0]); //All the array values are initialized to zero
			System.out.println(values[1]);
			System.out.println(values[2]);
			
			values[0] = 20; // Assigning values to the variables.
			values[1] = 40;
			values[2] = 60;

			System.out.println(values[0]); // Printing out the array values. 
			System.out.println(values[1]);
			System.out.println(values[2]);
			
			// for (int i=0;i<values.length;i++) 
			//{ System.out.println(values[i]); } //Printing out each array values by using for loop.
		
			int[] numbers = {3, 4, 5};
			for (int i = 0; i < numbers.length; i++) {
				System.out.println(numbers[i]);
			}
		}
	}
