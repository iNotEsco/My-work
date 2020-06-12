// Jason Aaron Escobar Escoto
// AverageGrade.java will get a list of grades from the user, display the
// average, then display the grades above average with a count at the end.

import java.util.*;

public class AverageGrade {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		int numOfGrades, count = 0;
		double total = 0, avg;
		
		System.out.print("Please enter the number of grades: ");
		numOfGrades = kbd.nextInt();
		
		System.out.print("\n");
		
		/*This if statement will check if the user provided a positive
		 * number, if the user didn't provide a positive number, then the
		 * program will display an error message and terminate the program.*/
		if(numOfGrades < 1){
			System.out.print("MUST ENTER A POSTIVE INTEGER");
			System.exit(0);
		}
		
		int[] grades = new int[numOfGrades];
		
		for(int i = 0; i < numOfGrades; i++){
			System.out.print("Enter a grade: ");
			total += grades[i] = kbd.nextInt();
		}
		
		/* The next two statements calculate the average and display it.*/
		avg = total / numOfGrades;
		System.out.println("\nThe average grade is: " + avg);
		
		System.out.println("\nThe grades above the average grade are: ");
		
		/*The next loop will print the grades that are greater than the
		 * average.*/
		for(int i = 0; i < numOfGrades; i++){
			if (grades [i] > avg){
				System.out.println(grades[i]);
				count++;
			}
		}
		
		System.out.print("for a total of " + count + " grades");
		
		kbd.close();
	}

}
