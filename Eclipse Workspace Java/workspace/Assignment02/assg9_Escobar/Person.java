//Jason Aaron Escobar Escoto
/*
 * Person class. Creates and manages objects of type Person. Consists of two strings, name and number.
 */

package assg9_Escobar;

public class Person extends KeyedItem<String>{

	private String number;

	/*
	 * Default constructor for Person. Sets name and number equal to null. 
	 */

	public Person(){
		super(null);
		number = null;
	}

	/**
	 * Two parameter constructor for Person. Sets name equal to n and number equal to p.
	 * 	
	 * @param n	the name of Person
	 * @param p	the number of Person
	 */

	public Person(String n, String p){
		super(n);
		number = p;
	}

	/**
	 * getter method for number of Person
	 * 
	 * @return	the number of person.
	 */

	public String getNum(){
		return number;
	}

	/**
	 * setter method for number of Person.
	 * 
	 * @param p	the number of Person.
	 */

	public void setNum(String p){
		number = p;
	}
	/**
	 * returns a string with the information of Person. name on one line and number on the next
	 * 
	 * @return
	 */

	public String toString(){
		//		return name + "\n" + number + "\n";
		return getKey() + "\t" + number;
	}


}
