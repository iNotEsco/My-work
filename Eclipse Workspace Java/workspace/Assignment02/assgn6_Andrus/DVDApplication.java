package assgn6_Andrus;

/**
 * @author Jameson Andrus
 */

import java.util.*;
import java.io.*;

public class DVDApplication 
{
	private static ArrayListDVDCollection shop = new ArrayListDVDCollection();
	private static File file = new File("DVDCollection.txt");
	public static void main(String[] args)
	{
		shop.loadData(file);
		alpha();
		menu();	
	}
	
	/**
	 * menu()
	 * Simply displays a menu for the user to perform operations.
	 * Other functions will end back to the menu until the user chooses exit.
	 */
	private static void menu()
	{
		Scanner kbd = new Scanner(System.in);
		int option;
		System.out.print(	"Please type a number from the menu to response:\n" +
							"	1. Add new DVD Entry\n" +
							"	2. Change Existing DVD Entry\n" +
							"	3. Look Up DVD Entry\n" +
							"	4. Display DVDs By Category\n" +
							"	5. Remove DVD Entry\n" +
							"	6. Save Data\n" +
							"	0. Exit\n");
		option = kbd.nextInt();
		while(option > 6 || option < 0)
		{
			System.out.println("Please enter a valid option.");
			option = kbd.nextInt();
		}
		kbd.close();
		
		if (option == 1)
			add();
		else if (option == 2)
			change();
		else if (option == 3)
			look();
		else if (option == 4)
			catDisplay();
		else if (option == 5)
			removeDVD();
		else if (option == 6)
			saveD();
		else
		{
			shop.Save();
			System.exit(0);
		}
	}
	
	/**
	 * add()
	 * Asks the user for a title,
	 * if title is not a DVD in the ArrayList,
	 * then it is added to the list,
	 * otherwise an error message is displayed.
	 */
	private static void add() 
	{
	Scanner kbd = new Scanner(System.in);
		String t, c, r, y, p;
		Integer A;
		
		System.out.println("DVD Title:	");
		t = kbd.nextLine();
		A = shop.lookupEntry(t);
		if(A == null)
		{
			System.out.println("DVD Category:	");
			c = kbd.nextLine();
			System.out.println("DVD Run-Time:	");
			r = kbd.nextLine();
			System.out.println("DVD Year:	");
			y = kbd.nextLine();
			System.out.println("DVD Price:	");
			p = kbd.nextLine();
			shop.addOrChangeDVD(t, c, r, y, p);
			kbd.close();
			alpha();
		}
		else
		{
			System.out.println("DVD already exists!\n");
			kbd.close();
		}
		menu();
	}
	
	/**
	 * change()
	 * Asks the user for a title,
	 * if title is in the ArrayList,
	 * then is sends the user to the change-menu,
	 * otherwise displays an error message.
	 */
	private static void change() 
	{
		Scanner kbd = new Scanner(System.in);
		String t;
		Integer A;
		
		System.out.println("DVD Title:	");
		t = kbd.nextLine();
		A = shop.lookupEntry(t);
		kbd.close();
		if(A == null)
			System.out.println("DVD doesn't exist!\n");
		else
		{
			changeMenu(A);
			alpha();
		}
		menu();
	}
	
	/**
	 * changeMenu()
	 * @param A is the location of the DVD in the ArrayList to be changed
	 * This is a helper method for change and is used to change aspects of a DVD,
	 * except for the DVD's title.
	 * The user will continue to make changes until they choose to exit the menu.
	 * Exiting will return to original menu.
	 */
	private static void changeMenu(Integer A)
	{
		Scanner kbd = new Scanner(System.in);
		DVD movie = shop.list.get(A);
		String item;
		int option = 6;
		
		while(option != 0)
		{
			System.out.print(	"Please type a number from the menu to response:\n" +
								"	1. Title:	" + movie.getTitle() + "\n" +
								"	2. Category:	" + movie.getCategory() + "\n" +
								"	3. Run-Time:	" + movie.getRunTime() + "\n" +
								"	4. Year of Release:	" + movie.getYear() + "\n" +
								"	5. Price:	" + movie.getPrice() + "\n" +
								"	0. Return to main menu\n");
			option = kbd.nextInt();
			while(option > 5 || option < 0)
			{
				System.out.println("Please enter a valid option.");
				option = kbd.nextInt();
			}
			kbd.close();
			if (option == 1)
				System.out.println("Title cannot be changed!\n");
			else if (option == 2)
			{
				item = kbd.nextLine();
				movie.setCategory(item);
			}
			else if (option == 3)
			{
				item = kbd.nextLine();
				movie.setRunTime(item);
			}
			else if (option == 4)
			{
				item = kbd.nextLine();
				movie.setYear(item);
			}
			else if (option == 5)
			{
				item = kbd.nextLine();
				movie.setPrice(item);
			}
		}
		kbd.close();
		shop.list.set(A, movie);
	}
	
	/**
	 * look()
	 * Asks the user for a title,
	 * if title is in the ArrayList,
	 * then it displays the info about the DVD,
	 * otherwise an error message is displayed.
	 */
	private static void look() 
	{
		Scanner kbd = new Scanner(System.in);
		String t;
		Integer A;
		
		System.out.println("Title search:	");
		t = kbd.nextLine();
		A = shop.lookupEntry(t);
		if(A == null)
			System.out.println("DVD is not in collection!\n");
		else
		{
			DVD movie = shop.list.get(A);
			System.out.println(movie.toString());
		}
		kbd.close();
		menu();
	}
	
	/**
	 * catDisplay()
	 * Asks the user for a category.
	 * Then it searches the ArrayList for DVD's with the specified category,
	 * all DVD with the category are put into another ArrayList.
	 * All DVD's in the new ArrayList will be displayed to the user.
	 * NOTE: Only the titles of the DVD's will be displayed to the user.
	 * If no DVD's are found, then an error message is displayed.
	 */
	private static void catDisplay()
	{
		Scanner kbd = new Scanner(System.in);
		String c;
		
		System.out.println("Category search:	");
		c = kbd.nextLine();
		ArrayList<DVD> search = shop.getDVDInCategory(c);
		if(search.size() == 0)
			System.out.println("No DVD's in category search!\n");
		else
		{
			for(int i = 0; i < search.size(); i++)
			{
				System.out.println(search.get(i).getTitle());
			}
		}
		kbd.close();
		menu();
	}
	
	/**
	 * removeDVD()
	 * Asks the user for a title,
	 * if a DVD exists in the ArrayList with the same title,
	 * then it is removed from the ArrayList and its info is displayed to the user.
	 * If no DVD is found in the ArrayList, then an error message is displayed.
	 */
	private static void removeDVD() 
	{
		Scanner kbd = new Scanner(System.in);
		String t;
		Integer A;
		
		System.out.println("Title to be removed:	");
		t = kbd.nextLine();
		A = shop.lookupEntry(t);
		if(A == null)
			System.out.println("DVD not in collection!\n");
		else
		{
			DVD movie = shop.list.get(A);
			shop.list.remove(A);
			System.out.println(movie.toString() + "This move has been removed from the collection!");
			alpha();
		}
		kbd.close();
		menu();
	}
	
	/**
	 * saveD()
	 * If the ArrayList has been modified from the original,
	 * then the ArrayList is saved to the original file.
	 */
	private static void saveD()
	{
		ArrayListDVDCollection original = new ArrayListDVDCollection();
		original.loadData(file);
		if(!shop.equals(original)) 
			shop.Save();
		menu();
	}
	
	/**
	 * alpha()
	 * Used to sort the ArrayList list into alphabetical order.
	 */
	private static void alpha()
	{
		ArrayList<DVD> sort = new ArrayList<DVD>();
		while(shop.list.size() != 0)
		{
			DVD A = shop.list.get(0);
			for(int i = 1; i < shop.list.size(); i++)
			{
				if(A.compareTo(shop.list.get(i)) > 0)
					A = shop.list.get(i);
			}
			sort.add(A);
			shop.list.remove(A);
		}
		shop.list = sort;
	}
}
