/**
 * 
 */

/**
 * @author Ferdinand K. Yeke
 *
 *
 *This interface is the setup for passengers. This class will 
 *inherit a queue data/priority queue data structure. addPassenger
 *(enqueue), removePassenger(dequeue), 
 */
public interface PassengerInterface {
	
	
	public void addPassenger(String Name);
	
	public void removePassenger() throws EmptyQueueException;
	
	public String getAllPassengers() throws EmptyQueueException;
	
	public void addTicket(String ticket);
	
	//public void removeTicket();
	
	public String getTickets();

}
