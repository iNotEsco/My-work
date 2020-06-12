// Jason Aaron Escobar Escoto
// ReverseNumber.java will get an integer from the keyboard. Then, it
// will print them to the screen in reverse order, with each digit appearing
// on a separate line. 

import java.util.*;

public class ReverseNumber {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		int num;
		
		System.out.print("Please enter an integer: ");
		num = kbd.nextInt();
		
		System.out.println("\nYour number printed in reverse order is:");
		
		/*This loop will print out the last number of the integer, then
		 * remove that number from the integer and loop till it's removed all
		 * numbers from the integer.*/
		do{
			System.out.println(num % 10);
			num = num / 10;
		}while(num != 0);
		
		kbd.close();
	}

}
