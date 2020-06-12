// Jason Aaron Escobar Escoto
/*
 * an exception class for BookNotFoundException. if the id being searched isn't
 * found, this exception will be thrown.
 */
package assg4_Escobar;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {

	/*
	 * throws the book not found exception 
	 */
	public BookNotFoundException()
	{
		super("Error: can't open book for reading. ");
	}

	/*
	 * throws the book not found exception with a custom message.
	 */
	public BookNotFoundException(String message)
	{
		super(message);
	}

}
