// Jason Aaron Escobar Escoto
/*
 * a class made to test the class Book
 */
package assg4_Escobar;
import java.util.*;
import java.io.*;
public class BookDemo{

	/*	
	 * This method fills the array of books with the book information from
	 * a text file.
	 * 
	 * @param	b	the empty array of books to be filled
	 * @param	fn	the name of the found that contains the book info
	 * @return		the array of books filled with the books from the catalog	
	 */

	public static Book[] makeArrayOfBooks(Book []b, String fn)
	{
		Scanner input;
		String line;
		try {
			input = new Scanner(new File(fn));
		} catch (FileNotFoundException e) {
			return null;
		}
		for(int i = 0; input.hasNextLine(); i++){
			line = input.nextLine();
			String[] parts = line.split("\\s+");
			int id = Integer.parseInt(parts[0]);
			char t = parts[4].charAt(0);
			b[i] = new Book(id, parts[1], parts[2], parts[3], t);
		}
		input.close();
		return b;
	}

	/*
	 * Asks the user to enter a book id and will return the information of the book found.
	 */

	public static void main(String[] args){
		Scanner kbd = new Scanner(System.in);
		Book []b = new Book[100];
		b = makeArrayOfBooks(b,"catalog.txt");

		while(true){
			System.out.print("Enter book id: ");
			int k = kbd.nextInt();
			if(k == 0)
			{
				break;
			}
			System.out.print(b[Book.bookSearch(b , Book.getCounter(), k)]);
		}	
		kbd.close();

	}

}
