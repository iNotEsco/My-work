package assgn6_Andrus;

/**
 * @author Jameosn Andrus
 */

import java.io.*;
import java.util.ArrayList;

public interface DVDCollectionINterface 
{
	/**
	 * loadData()
	 * Please read "ArrayListDVDCollection"
	 */
	void loadData(File name);
	
	/**
	 * lookupEntry()
	 * Please read "ArrayListDVDCollection"
	 */
	Integer lookupEntry(String t);
	
	/**
	 * addOrChangeDVD()
	 * Please read "ArrayListDVDCollection"
	 */
	Integer addOrChangeDVD(String t, String c, String r, String y, String p);
	
	/**
	 * removeDVD()
	 * Please read "ArrayListDVDCollection"
	 */
	Integer removeDVD(String t);
	
	/**
	 * getDVDInCategory()
	 * Please read "ArrayListDVDCollection"
	 */
	ArrayList<DVD> getDVDInCategory(String c);
	
	/**
	 * Save()
	 * Please read "ArrayListDVDCollection"
	 */
	void Save();	
}
