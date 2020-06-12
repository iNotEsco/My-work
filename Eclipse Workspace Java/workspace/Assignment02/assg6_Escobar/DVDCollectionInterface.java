//Jason Aaron Escobar Escoto

package assg6_Escobar;

import java.util.*;

public interface DVDCollectionInterface {

	/*
	 * This method loads the data containing the DVD collection entries 
	 * from a given file.
	 * 
	 */
	public void loadData(String filename);

	/*
	 * This method returns the DVD entry if found in the collection, or 
	 * null if not found
	 * 
	 * @return		the DVD entry if found, otherwise null
	 */

	public DVD lookupEntry(String ti);

	/* 	 
	 * This method is used to add a new DVD or change the information of an 
	 * existing DVD entry. If the title 'tt' isn't in the DVD collection, then this
	 * method will add the DVD entry to the collection. Otherwise, it will modify
	 * the information of the existing DVD entry accordingly.
	 * 
	 * @param tt	the title of the new or existing DVD
	 * @param c		the category of the new or existing DVD
	 * @param tm	the run time of the new or existing DVD
	 * @param y		the year of the new or existing DVD
	 * @param p		the price of the new or existing DVD
	 * @return		The DVD entry if it is changed, null if a new DVD was added.
	 */
	
	public DVD addOrChangeDVD(String tt, String c, String tm, String y, String p);
	
	/*
	 * This method will remove the DVD  with the title 'ti' from the collection if
	 * found in the collection and then return that DVD entry, if it isn't found, then
	 * it will return null.
	 * 
	 * @param ti
	 * @return 
	 */
	
	public DVD removeDVD(String ti);

	/* This method will return an arrayList object with all the DVDs in the specified
	 * category. If there is no DVD in the given category, the size of the array will
	 * be 0.
	 * 
	 * @param cat
	 * @return
	 */
	
	public ArrayList<DVD> getDVDsInCategory(String cat);

	/*
	 * This method will save the DVD collection back to the file only if the DVD 
	 * collection has been modified.
	 */
	
	public void save();

}
