// Jason Aaron Escobar Escoto
// DateChanger.java was designed to change the date from mon/day/year to the European
// form, which is day.mon.year.

import java.util.*; 

public class DateChanger {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		String date, day, month, year; int posOfFir, posOfLast;
		
		System.out.println("Enter a date in the form mon/day/year:");
		date = kbd.nextLine();
		
		/*These two equations will get the position of the first and last '/'.*/
		posOfFir = date.indexOf('/');
		posOfLast = date.lastIndexOf('/');
		
		/*Using the position of the first and last '/', we can get the day, month, and 
		 * year from the date. */
		day = date.substring(posOfFir+1,posOfLast);
		month = date.substring(0,posOfFir);
		year = date.substring(posOfLast+1);
		
		/* This prints it out in the correct European form.*/
		System.out.println("\nYour date in European form is:");
		System.out.println(day + "." + month + "." + year);
		
		kbd.close();
					
	}

}
