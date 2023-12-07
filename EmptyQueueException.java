/**
 * 
 */

/**
 * @author Ferdinand K. Yeke
 *
 */
public class EmptyQueueException extends Exception {
	
	public EmptyQueueException()
	{
		super("The Queue list is empty! Cannot operate on "
				+ "empty list!");
	}
	
	public EmptyQueueException(String message)
	{
		super(message);
	}

}
