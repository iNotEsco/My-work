package assg9_Escobar;

import java.util.Scanner;

public class Menu {

	public static void menu(){
		System.out.print("What would you like to do?\n"
				+ "(Enter a number from 0 to 4)\n"
				+ "(1)add\n"
				+ "(2)delete\n"
				+ "(3)change\n"
				+ "(4)find\n"
				+ "(0)quit and save\n");
	}
	public static void add(PhoneBook b, Scanner kbd){
		System.out.println("\nEnter the new person's first and last name seperated by a space.");
		String name = kbd.nextLine();
		System.out.println("Enter the person's number(do not include non-digit characters)");

		b.insert(new Person(name, kbd.nextLine()));
	}

	public static void delete(PhoneBook b, Scanner kbd){
		System.out.println("\nWho would you like to delete?\n"
				+ "(Enter first and last name separated by a space)");
		b.delete(kbd.nextLine());
	}
	public static void find(PhoneBook b, Scanner kbd){
		System.out.println("\nWho would you like to find?\n"
				+ "(Enter first and last name separated by a space)");
		Person temp = b.find(kbd.nextLine());
		System.out.println("");
		if (temp != null ){
		System.out.println(temp);
		}
		else{
			System.out.println("Could not find the person.\n");
		}
		System.out.println("");
	}
	public static void change(PhoneBook b, Scanner kbd){
		System.out.println("\nWho would you like to change?\n"
				+ "(Enter first and last name separated by a space)");
		String name = kbd.nextLine();
		System.out.println("Enter new number:");
		b.change(name, kbd.nextLine());
//		b.printBook();
	}
	public static void quit(PhoneBook b, Scanner kbd){
		b.saveFile();
		kbd.close();
		System.exit(0);
	}
	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();
		book.loadBook();
		System.out.print("Phone Book read and uploaded. ");
		Scanner kbd = new Scanner(System.in);
		int input;
		while(true){
			menu();
			input = kbd.nextInt();
			kbd.nextLine();
			switch(input){
			case 1: 
				add(book, kbd);
				break;
			case 2:
				delete(book, kbd);
				break;
			case 3:
				change(book, kbd);
				break;
			case 4:
				find(book, kbd);
				break;
			case 0:
				quit(book, kbd);
			}
		}
	}
}
