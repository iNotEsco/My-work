//Jason Aaron Escobar Escoto

package assg6_Escobar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ArrayListDVDCollection {

	public static ArrayList<DVD> dvds;
	public static boolean mod = false;
	
	/*
	 * default constructor to create an object of type ArrayListDVDCollection.
	 */
	
	public ArrayListDVDCollection(){
		dvds = new ArrayList<DVD>();
	}

	public void loadData(String filename){
		Scanner file = null;
		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Can not open " + filename + " for reading.");
			System.exit(1);
		}
		while(file.hasNextLine()){
			dvds.add(new DVD(file.nextLine(), file.nextLine(), 
					file.nextLine(), file.nextLine(), file.nextLine()));
		}
		file.close();
	}

	public DVD lookupEntry(String ti){
		Iterator<DVD> iter = dvds.iterator();
		while(iter.hasNext()){
			DVD temp = iter.next();
			if(temp.getTitle().equals(ti)){
				return temp;
			}
		}
		return null;
	}

	public DVD addOrChangeDVD(String tt, String c, String tm, String y, String p){
		DVD temp = lookupEntry(tt);
		mod = true;
		if( temp != null){
			temp.setCategory(c);
			temp.setTime(tm);
			temp.setYear(y);
			temp.setPrice(p);
			return temp;
		}
		else{
			dvds.add(new DVD( tt, c, tm, y, p));
			return null;
		}

	}

	public DVD removeDVD(String ti){
		Iterator<DVD> iter = dvds.iterator();
		mod = true;
		while(iter.hasNext()){
			DVD temp = iter.next();
			if (temp.getTitle().equals(ti)){
				iter.remove();
				return temp;
			}
		}
		return null;
	}

	public ArrayList<DVD> getDVDsInCategory(String cat){
		Iterator<DVD> iter = dvds.iterator();
		ArrayList<DVD> tempC = new ArrayList<DVD>();
		DVD tempD;
		while (iter.hasNext()){
			tempD = iter.next();
			if(tempD.getCategory().equals(cat)){
			tempC.add(tempD);
			}
		}
		return tempC;
	}

	public void save(){
		if(mod){
			Iterator<DVD> iter = dvds.iterator();
			PrintWriter output = null;
			try {
				output = new PrintWriter(new FileWriter("DVDCollection.txt"));
			} catch (IOException e) {
				System.out.println("ERROR: Can not open DVDCollection.txt");
				System.exit(1);
			}
			while(iter.hasNext()){
				output.print(iter.next());
			}
			output.close();
		}
	}
}
