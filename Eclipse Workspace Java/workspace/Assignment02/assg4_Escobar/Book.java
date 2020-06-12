// Jason Aaron Escobar Escoto
/*
 * a class of books. The information that is stored of the books
 * is; the id, title, ISBN, author and type of the book. Book also
 * keeps track of how many books were made.
 * 
 */
package assg4_Escobar;


public class Book {

	private int bookID;
	private String title, ISBN, author;
	private char type;
	private static int counter = 0;

	/* 
	 * This constructor makes a new book with the given variables
	 * and adds one to the counter of books
	 *  
	 * @param	id		will be set as the bookID
	 * @param	ti		will be set as the title
	 * @param	isbn	will be set as the ISBN
	 * @param	a		will be set as the author
	 * @param	ty		will be set as the type
	 */

	public Book(int id, String ti, String isbn, String a, char ty) {

		bookID = id;
		title = ti;
		ISBN = isbn;
		author = a;
		type = ty;
		counter++;
	}	

	/* 
	 * returns the amount of books created
	 *  
	 * @param
	 * @param	
	 * @return	
	 */

	public static int getCounter(){
		return counter;
	}	
	/* 
	 * returns the title of the book
	 *  	
	 * @return	the title of the book
	 */
	public String getTitle()
	{
		return title;
	}
	
	/* 
	 * returns the ISBN of the book
	 *	
	 * @return	the ISBN of the book.
	 */

	public String getISBN()
	{
		return ISBN;
	}
	
	/* 
	 * returns the id of the book
	 * 	
	 * @return	the id of the book
	 */

	public int getBookID(){
		return bookID;
	}	
	
	/* 
	 * returns the author of the book
	 *  
	 * @return	the author of the book
	 */


	public String getAuthor(){
		return author;
	}
	
	/* 
	 * returns the type of the book
	 * 
	 * @return	the type of the book
	 */

	public char getType(){
		return type;
	}	
	
	/* 
	 * returns a string containing the book id, title, ISBN, author and genre.
	 * 	
	 * @return	string containing the information.
	 */

	public String toString(){
		String temp =  "Book id: " + bookID +
				", Title: " + title +
				", ISBN: " + ISBN +
				", Author: "  + author;
		return type == 'N'
				? temp + ", Non-Fiction\n"
						: temp + ", Fiction\n";
	}

	/* 
	 * This method will search through the catalog of books and return
	 * the index of the book that has the same id as the one that is 
	 * being searched for.
	 *  
	 * @param	books		the array of Book containing the catalog of books.
	 * @param	numOfBooks	the number of books in the catalog.
	 * @param	id			the id of the book that is trying to be found.
	 * @return				the index where the book was found.
	 */

	public static int bookSearch(Book books[], int numOfBooks, int id){
		for(int i = 0; i < numOfBooks; i++){
			if(books[i].getBookID() == id){
				return i;
			}
		}
		throw new BookNotFoundException("Book with id " + id + " was not found");
	}
}
