/**
 * 
 * @author Ferdinand K. Yeke
 *
 */
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
public class TrainClass implements TrainInterface {

	Queue<String> trainCarQueue = new LinkedList(); //Uses the Queue class while implementing a Linked List data structure for train cars based on capacity.
	Random rand = new Random();
	
	private String ID;
	private int routes = 0;
	private int capacity = 0;
	private String carCarry;
	private int capacityCount = 0;
	
	/*
	 * Is used to make the ID of the train.
	 */
	private String[] IDgen = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S"
			,"T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
	
	//Default Constructor
	public TrainClass()
	{
		this.ID = "";
		this.routes = 0;
		this.capacity = 0;
		this.carCarry = "";
		this.capacityCount = 0;
	}
	
	//Preferred Constructor
	public TrainClass(String model, int routes, int capacity, String carCarry, int capacityCount)
	{
		this.ID = model;
		this.routes = routes;
		this.capacity = capacity;
		this.carCarry = carCarry;
		this.capacityCount = capacityCount;
	}
	
	@Override
	/*
	 * setID sets and generates the ID based on idGen, index values. It then gets continuously added to
	 * the ID variable till the loop ends in 4 reps, which is the length of the ID.
	 */
	public void setID() {
		// TODO Auto-generated method stub
		int IDgenIndex;
		
		/*
		 * Creates a new ID if it is empty.
		 */
		if(ID.isEmpty())
		{
			for(int i = 0; i < 4; i++)
			{
				IDgenIndex = rand.nextInt(0,4);
				ID = ID +""+IDgen[IDgenIndex];
			}
		}
		
		/*
		 * If the ID is not empty (THIS IS USED TO ALSO REWRITE ID FOR GENERATED TRAINS
		 * TO MAKE SURE EACH TRAIN HAS A UNIQUE ID!) it clears it, and calls the set ID method, and goes to the if statment to
		 * make the new ID for a newly generated train.
		 */
		else if (!ID.isEmpty() && ID.length() == 4)
		{
			ID = "";
			setID();
		}
	
	}

	@Override
	/**
	 * @param routes sets the routes for the train.
	 */
	public void setAmountOfRoutes(int routes) {
		// TODO Auto-generated method stub
		this.routes = routes;
	}

	@Override
	/**
	 * @param capacity sets the capacity of a train car.
	 */
	public void setPassengerCapacity(int capacity) {
		// TODO Auto-generated method stub
		this.capacity = capacity;
	}

	@Override
	//enqueues a passenger to a train car
	/**
	 * @param carCarry is just a train car carrying other things like cargo.
	 * It also enqueues the entity/entities IF the capacityCount amount is less than
	 * the capacity. Otherwise, a new train car gets created, and the same process gets repeated.
	 */
	public void setToTrainCar(String carCarry) {
		// TODO Auto-generated method stub
		this.carCarry = carCarry;
		if(capacityCount < capacity)
		{
			//this.capacity = capacity;
			trainCarQueue.add(carCarry);
			capacityCount++;
		}
		
		else
		{
			//Creates a new train car if the capacity has been exceeded.
			trainCarQueue = new LinkedList();
			trainCarQueue.add(carCarry);
		}
		
	}
	
	/**
	 * 
	 * @return routes of the train.
	 */
	public int getRoutes() {
		return routes;
	}

	/**
	 * 
	 * @param routes sets the amount of routes a train has to take.
	 */
	public void setRoutes(int routes) {
		this.routes = routes;
	}

	/**
	 * 
	 * @return ID of the train.
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * 
	 * @return trainCarQueue's element/value/Passenger's name up on top the passengerQueue.
	 * @throws EmptyQueueException if trainCarQueue has no capacity set. That is if the capacity
	 * is null.
	 */
	public String getTrainCar() throws EmptyQueueException
	{	
		return trainCarQueue.element();
	}

}//Class ends here
