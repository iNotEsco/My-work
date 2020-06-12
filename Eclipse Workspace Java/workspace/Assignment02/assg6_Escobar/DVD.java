//Jason Aaron Escobar Escoto

package assg6_Escobar;

public class DVD /*implements Comparable<DVD>*/{
	
	private String title, category, time, year, price;
	
	/*
	 * Default constructor for a object of type DVD. Sets all values to null.
	 */
	
	public DVD(){
		title = null;
		category = null;
		time = null;
		year = null;
		price = null;
	}
	
	/*
	 * Constructor with all variables of DVD.
	 * 
	 * @param ti	title of the new DVD.
	 * @param c		category of the new DVD.
	 * @param time	run time of the new DVD.
	 * @param y		year of the new DVD.
	 * @param p		price of the new DVD.
	 */
	
	public DVD(String ti, String c, String time, String y, String p){
		title = ti;
		setCategory(c);
		setTime(time);
		setYear(y);
		setPrice(p);
	}
	
	/*
	 * returns the title of 'this' DVD.
	 * 
	 * @return		title of 'this' DVD.
	 */
	
	public String getTitle(){
		return title;
	}
	
	/*
	 * returns the category of 'this' DVD.
	 * 
	 * @return		the category of 'this' DVD.
	 */
	
	public String getCategory(){
		return category;
	}
	
	/*
	 * returns the time of 'this' DVD.
	 * 
	 * @return		the time of 'this' DVD.
	 */
	
	public String getTime(){
		return time;
	}
	
	/*
	 * returns the year of 'this' DVD.
	 * 
	 * @return		the year of 'this' DVD.
	 */
	
	public String getYear(){
		return year;
	}
	
	/*
	 * returns the price of 'this' DVD.
	 * 
	 * @return		the price of 'this' DVD.
	 */
	
	public String getPrice(){
		return price;
	}
	
	/*
	 * sets the category of 'this' equal to c.
	 *  
	 * @param c		what the category of 'this' will equal.
	 */
	
	public void setCategory(String c){
		category = c;
	}	
	
	/*
	 * sets the time of 'this' equal to t.
	 *  
	 * @param c		what the time of 'this' will equal.
	 */
	
	public void setTime(String t){
		time = t;
	}
	
	/*
	 * sets the year of 'this' equal to y.
	 *  
	 * @param y		what the year of 'this' will equal.
	 */
	
	public void setYear(String y){
		year = y;
	}
	
	/*
	 * sets the price of 'this' equal to p.
	 *  
	 * @param p		what the price of 'this' will equal.
	 */
	
	public void setPrice(String p){
		price = p;
	}
	
	/*
	 * provides the information of the DVD in a string and returns the string. the 
	 * information consists of the title, category, time, year, and price, each in a 
	 * new line.
	 * 
	 * return	the string with the information. 
	 */
	public String toString(){
		return "" + title + "\n" +
				category + "\n" +
				time + "\n" + 
				year + "\n" +
				price + "\n";
	}
	
	/*
	 * this method returns true if 'this' DVD equals x, otherwise returns false.
	 * 
	 *  returns		true if they are equal, false if they are not.
	 */
	public boolean equals(Object x){
		if (x == null){
			return false;
		}
		if (x instanceof DVD){
			DVD y = (DVD) x;
			return ( title.equals(y.getTitle()));
		}
		return false;
	}
	
	/*
	 * returns a negative integer if x comes before y, 0 if they are equal, positive
	 * if x comes after y.
	 * 
	 * @param y		the DVD's title that will be compared to the title of 'this'.
	 * @return
	 */
	public int compareTo(DVD y){
		return title.compareTo(y.title);
	}
}
