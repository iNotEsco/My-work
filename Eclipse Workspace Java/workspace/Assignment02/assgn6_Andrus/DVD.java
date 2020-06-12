package assgn6_Andrus;

/**
 * @author Jameson Andrus
 */

public class DVD implements Comparable<DVD>
{
	private String title;
	private String category;
	private String runTime;
	private String year;
	private String price;
	
	/**
	 * DVD constructor for making a DVD
	 * @param t is the title of the DVD
	 * @param c is the category of the DVD
	 * @param r is the run-time of the DVD
	 * @param y is the year of the DVD
	 * @param p is the price of the DVD
	 */
	public DVD(String t, String c, String r, String y, String p)
	{
		this.title = t;
		this.category = c;
		this.runTime = r;
		this.year = y;
		this.price = p;
	}
	
	/**
	 * getTitle()
	 * @returns the title of the current DVD
	 */
	public String getTitle()		{return this.title;}
	
	/**
	 * getCAtegory()
	 * @returns the category of the current DVD
	 */
	public String getCategory()	{return this.category;}
	
	/**
	 * getRunTime()
	 * @returns the run-time of the current DVD
	 */
	public String getRunTime()		{return this.runTime;}
	
	/**
	 * getYear()
	 * @returns the year of the current DVD
	 */
	public String getYear()			{return this.year;}
	
	/**
	 * getPrice()
	 * @returns the price of the current DVD
	 */
	public String getPrice()		{return this.price;}
	
	/**
	 * setCategory()
	 * @param c is a category for a DVD
	 * This method changes the current DVD's category to c.
	 */
	public void setCategory(String c)	{this.category = c;}
	
	/**
	 * SetRunTime()
	 * @param r is a run-time for a DVD
	 * This method changes the current DVD's run-time to r.
	 */
	public void setRunTime(String r)		{this.runTime = r;}
	
	/**
	 * setYear()
	 * @param y is a year for a DVD
	 * This method changes the current DVD's year to y.
	 */
	public void setYear(String y)			{this.year = y;}
	
	/**
	 * setPrice()
	 * @param p is a price for a DVD
	 * This method changes the current DVD's price to y.
	 */
	public void setPrice(String p)			{this.price = p;}
	
	/**
	 * toString()
	 * @returns a string of info about a DVD in a readable format. 
	 */
	public String toString()
	{
		String text;
		text =	"Title:	" + this.title +
				"\nCategory:	" + this.category +
				"\nRun-Time:	" + this.runTime +
				"\nYear:	" + this.year +
				"\nPrice:	" + this.price + "\n";
		return text;
	}
	
	/**
	 * equals()
	 * @param B is a DVD
	 * @return a boolean value that is true,
	 * if the current DVD has the same title as B,
	 * and false otherwise.
	 */
	public boolean equals(DVD B)
	{
		if(this.getTitle().equals(B.getTitle()))
			return true;
		else
			return false;
	}
	
	/**
	 * compareTo()
	 * @param B is a DVD
	 * @returns an integer based on the current DVD's title and B's title.
	 * If the current DVD's title comes before B alphabetically,
	 * then it returns a negative 1,
	 * if the current DVD's title and B's title are equal, then it returns 0,
	 * else it returns -1. 
	 */
	public int compareTo(DVD B)
	{
		if(this.getTitle().compareTo(B.getTitle()) < 0)
			return -1;
		else if(this.getTitle().compareTo(B.getTitle()) == 0)
			return 0;
		else
			return 1;
	}
}
