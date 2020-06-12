//Jason Aaron Escobar Escoto
/*
 * Queue Exception that extends runTime. It is an exception that is thrown when the queue is empty and 
 * the program tries to either peek or dequeue.
 */
package assg8_Escobar;

public class QueueException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4386166490386550362L;

	public QueueException(String s) {
		super(s);
	}  // end constructor
}  // end QueueException
