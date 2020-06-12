package assgn6_Andrus;

/** 
 * @author Jameson Andrus
 */

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class ArrayListDVDCollection implements DVDCollectionINterface
{
	ArrayList<DVD> list = new ArrayList<DVD>();
	String title, category, runtime, year, price;
	private File document;
	
	/**
	 * loadData()
	 * @param name is the name of the file used for reading
	 * reads the data from the file and loads it into the ArrayList list
	 */
	public void loadData(File name)
	{
		document = name;
		try
		{
			Scanner collection = new Scanner(document);
	        while(collection.hasNextLine())
	        	{
	        		title	= collection.nextLine();
	        		category	= collection.nextLine();
	        		runtime	= collection.nextLine();
	        		year		= collection.nextLine();
	        		price	= collection.nextLine();
	        		list.add(new DVD(title, category, runtime, year, price));
	        	}
			collection.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace(); 
		}
	}
	
	/**
	 * lookupEntry()
	 * @param t is a title of a DVD
	 * this method searches for arrayList list for a DVD with title t
	 * @returns an integer which is the location in the ArrayList list that has the title t
	 */
	public Integer lookupEntry(String t)
	{
		for(int i = 0; i < list.size(); i++)
		{
	        if(list.get(i).getTitle().equals(t))
	        {
	            return i;
	        }
		}
		return null;
	}
	
	/**
	 * addOrChange()
	 * @param t is the title of a DVD
	 * @param c is the category of a DVD
	 * @param r is the run-time of a DVD
	 * @param y is the year of a DVD
	 * @param p is the price of a DVD
	 * if there exists a DVD in the ArrayList list with the same title as t
	 * then the DVD's category, run-time, year, and price are changed.
	 * Otherwise a new DVD is created in the ArrayList list with the new info.
	 * @returns an integer of the DVD's location in the ArrayList list that was changed,
	 * if the DVD didn't exist in the list, then it returns null.
	 */
	public Integer addOrChangeDVD(String t, String c, String r, String y, String p)
	{
		Integer A = lookupEntry(t);
		if(A == null)
		{
			list.add(new DVD(t, c, r, y, p));
			return null;
		}
		else
		{
			list.set(A, new DVD(t, c, r, y, p));
			return A;
		}
	}
	
	/**
	 * removeDVD()
	 * @param t is a title of a DVD
	 * if there exists a DVD in the ArrayList list with the same title as t,
	 * then is is removed from the list.
	 * @returns an integer of the location in the list, that the DVD was removed,
	 * returns null if DVD doesn't exist.
	 */
	public Integer removeDVD(String t)
	{
		Integer A = lookupEntry(t);
		if(A == null)
			return null;
		else
		{
			list.remove(A);
			return A;
		}
	}
	
	/**
	 * getDVDInCategory()
	 * @param c is a category of a DVD
	 * Finds all DVD's in the ArrayList with category c,
	 * and puts them into a separate list.
	 * @returns an ArrayList of DVD's that have category c.
	 */
	public ArrayList<DVD> getDVDInCategory(String c)
	{
		ArrayList<DVD> cat = new ArrayList<DVD>();
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getCategory().equals(c))
				cat.add(list.get(i));
		}
		return cat;
	}
	
	/**
	 * Save()
	 * Writes all the DVD's in the ArrayList list to the file,
	 * that was used to load the original list.
	 */
	public void Save()
	{
		try 
		{
			PrintWriter writer = new PrintWriter(document);
			for(int i = 0; i < list.size(); i++)
			{
				writer.println(list.get(i).getTitle());
				writer.println(list.get(i).getCategory());
				writer.println(list.get(i).getRunTime());
				writer.println(list.get(i).getYear());
				writer.println(list.get(i).getPrice());
			}
			writer.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace(); 
		}
	}
}
