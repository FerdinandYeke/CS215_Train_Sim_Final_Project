/**
 * @author Ferdinand K. Yeke
 *
 *11/20/2023 class w.i.p. docs
 *This class sets up the passenger and the train, while also 
 *building a train station. This class could also make 2D graphics 
 *for the train station, but could be made in another class. This class
 *could also let you ask a train conductor if your ID is unique.
 *
 *This class will also try to implement the a* algorithm for the train's travel path
 *from the first to last destination.
 */

/*
 * This class or the TrainClass will have some sort of "priority" (That is, using the 
 * priority queue data structure/class) which will enqueue and/or dequeue passengers based
 * on certain locations, and arrival time.
 * 
 * This class can also mainly focus on which location the passengers can go to: A Store, A house, A destination spot in a city a 
 * passenger can enjoy (Like a Museum or Music Concert) Or another city (Which we can say "follows/repeats this same location options").
 * And these choices can be randomly generated for each passenger.
 */
import java.util.Random;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
public class TrainStation

{
	private String trainName;
	private int capacity;
	private String location;
	private int hours;
	private int minutes;
	private int seconds;
	private String From;
	private String To;
	private int randomFrom;
	private int randomTo;
	private int genHours;
	private int genSeconds;
	private int genMinutes;
	//private T train;
	private String TrainStationName;
	
	/*An Array of Train Station locations across the U.S. This
	 * will have a train have randomly generated locations for the
	 * variable "To", but for the main train station, it must be one
	 * of these train stations, but there can be trains coming from a 
	 * station outside of the main train station.
	 *  
	 */
	
	/*
	 * This also could use ArrayList, but for now sticking to a 
	 * primitive String array to get the concept working in the 
	 * main class.
	 */
	private String[] trainStationLocations = {"Grand Central Terminal, NY", "30th Street Station, Philadelphia",
			"The Cincinnati Union Terminal, Ohio","Union Station, Washington D.C.","Santa Fe"
					+ "Depot, San Diego", "Union Station, Los Angeles","Main Street Station, Richmond",
					"Union Station, Kansas City","South Station, Boston","Union Station, Denver"};
	
	
	PriorityQueue<String> pQ = new PriorityQueue<String>();
	Random rand = new Random();
	
	//Default constructor
	
	public TrainStation()
	{
		this.TrainStationName = "";
		this.trainName ="";
		this.capacity = 0;
		this.location = "";
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
		this.From = "";
		this.To = "";
	}
	
	//Preferred Constructor
	public TrainStation(String trainName, int capacity, String location,
						int hours, int minutes, int seconds, String From,
						String To, String tsName )
	{
		this.TrainStationName  = tsName;
		this.trainName = trainName;
		this.capacity = capacity;
		this.location = location;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.From = From;
		this.To = To;
	}
	
	/*
	public void addPriority(int capacity, String location)
	{
		//pQ.add(trainName);
	
	}
	*/
	
	/**
	 * 
	 * @return trainStationName
	 */
	public String getTrainStationName() {
		return TrainStationName;
	}

	/**
	 * 
	 * @param trainStationName sets the train station name.
	 */
	
	public void setTrainStationName(String trainStationName) {
		TrainStationName = trainStationName;
	}

	/**
	 * 
	 * @param trainName sets the trainName.
	 */
	public void setTrainName(String trainName)
	{
		this.trainName = trainName;
	}
	
	/**
	 * 
	 * @return trainName
	 */
	public String getTrainName()
	{
		return trainName;
	}
	
	/*
	 * If the preferred method addTime is not called, this method gets called & generates the time
	 * by hours, minutes, & seconds for a ONCOMING train & departing train.
	 */
	public void addTime()
	{
		
		genHours = rand.nextInt(5,25);
		genMinutes = rand.nextInt(0,61);
		genSeconds = rand.nextInt(0,61);
		
		this.hours = genHours;
		this.minutes = genMinutes;
		this.genSeconds = genSeconds;
		
		if(minutes >= 0 || minutes <= 59 && seconds >= 0 || seconds <= 60
				&& hours >= 0 || hours <= 24)
		{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		}
		
		else if(hours >= 0 || hours < 24 && minutes == 60 && seconds >= 0
				|| seconds <=60)
		{
			this.hours = hours+1;
			this.minutes = minutes-minutes+0;
			this.seconds = seconds;
		}
		
		else if(hours >= 0 || hours < 24 && minutes == 60 &&
				seconds ==60)
		{
			this.hours = hours+1;
			this.minutes = minutes-minutes+0;
			this.seconds = seconds-seconds+0;
		}
		
		else if(hours >= 0 || hours == 24 && minutes == 60 &&
				seconds ==60)
		{
			this.hours = hours-hours;
			this.minutes = minutes-minutes+0;
			this.seconds = seconds-seconds+0;
		}
		
		else
		{
			System.out.println("Invalid hour, minutes, and time input!");
		}
		
	}
	
	/**
	 * 
	 * @param hours sets the hour 
	 * @param minutes sets the minutes
	 * @param seconds sets the seconds
	 */
	
	public void addTime(int hours, int minutes, int seconds)
	{
		if(minutes >= 0 || minutes <= 59 && seconds >= 0 || seconds <= 60
				&& hours >= 0 || hours <= 24)
		{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		}
		
		else if(hours >= 0 || hours < 24 && minutes == 60 && seconds >= 0
				|| seconds <=60)
		{
			this.hours = hours+1;
			this.minutes = minutes-minutes+0;
			this.seconds = seconds;
		}
		
		else if(hours >= 0 || hours < 24 && minutes == 60 &&
				seconds ==60)
		{
			this.hours = hours+1;
			this.minutes = minutes-minutes+0;
			this.seconds = seconds-seconds+0;
		}
		
		else if(hours >= 0 || hours == 24 && minutes == 60 &&
				seconds ==60)
		{
			this.hours = hours-hours;
			this.minutes = minutes-minutes+0;
			this.seconds = seconds-seconds+0;
		}
		
		else
		{
			System.out.println("Invalid hour, minutes, and time input!");
		}
		
	}
	
	/*This method was used to decremite the train's time by hours, minutes & seconds 
	 * by one based on the timer in the main class.
	 */
	/*
	public void decremiteTime(int decremiteBy)
	{
		if(minutes >= 0 || minutes <= 59 && seconds >= 0 || seconds <= 60
				&& hours >= 0 || hours <= 24)
		{
		this.hours = hours;
		this.minutes = minutes-decremiteBy;
		this.seconds = seconds-decremiteBy;
		}
		
		else if(hours >= 0 || hours < 24 && minutes == 60 && seconds >= 0
				|| seconds <=60)
		{
			this.hours = hours+1;
			this.minutes = minutes-minutes+0;
			this.seconds = seconds;
		}
		
		else if(hours >= 0 || hours < 24 && minutes == 60 &&
				seconds ==60)
		{
			this.hours = hours+1;
			this.minutes = minutes-minutes+0;
			this.seconds = seconds-seconds+0;
		}
		
		else if(hours >= 0 || hours == 24 && minutes == 60 &&
				seconds ==60)
		{
			this.hours = hours-hours;
			this.minutes = minutes-minutes+0;
			this.seconds = seconds-seconds+0;
		}
		
		else
		{
			System.out.println("Invalid hour, minutes, and time input!");
		}
	}
	*/
	
	/**
	 * 
	 * @return hours, minutes & seconds in String format
	 */
	public String getTime()
	{
		return hours+":"+minutes+":"+seconds;
	}
	
	/*
	 * If the overridden method addFrom(String from) is not called, the default method addFrom()
	 * generates a random trainStation location from said state for a oncoming train.
	 */
	public void addFrom()
	{
		randomFrom = rand.nextInt(trainStationLocations.length);
		this.From = trainStationLocations[randomFrom];
		
		
		/*If the From/Origin does not equal To, The From reference gets assigned to the
		 * randomly generated trainStationLocations. Otherwise, if From/Origin is equal to To/Destination,
		 * then addTo does a recursive call until its From's value is different from To's value.
		 */
		if(From != To)
		{
			this.From = trainStationLocations[randomFrom];
		}
		
		else
		{
			addFrom();
		}
	}
	
	/**
	 * 
	 * @param from adds where the train is coming from.
	 */
	public void addFrom(String from)
	{
		this.From = from;
	}
	
	/*
	 * If the overridden method addTo(String to) is not called, the default method addFrom() gets called &
	 * generates a random trainStation location from said state for a departing train IN THE MAIN TRAIN STATION!
	 */
	public void addTo()
	{
		randomTo = rand.nextInt(trainStationLocations.length);
		this.To = trainStationLocations[randomTo];
		
		/*If the To/Destination does not equal From, The To reference gets assigned to the
		 * randomly generated trainStationLocations. Otherwise, if To/Destination is equal to From/Origin,
		 * Then addTo does a recursive call until its To's value is different from From's value.
		 */
		if(To != From)
		{
			this.To = trainStationLocations[randomTo];
		}
		
		else
		{
			/*
			 * If the train is going to the same location as its origin, the train would be 
			 * experiencing an emergency. So it would be moved up the priority queue.
			 */
			System.out.println("Train "+getTrainName()+" is experiencing an ememgency at: "+getFrom());
			pQ.add(getTrainName());
			addTo();
		}
	}
	
	/**
	 * 
	 * @param to adds where the train is coming from
	 */
	public void addTo(String to)
	{
		this.To = to;
	}
	
	/**
	 * 
	 * @return from (The origin)
	 */
	public String getFrom()
	{
		return From;
	}
	
	/**
	 * 
	 * @return TO (The departure)
	 */
	public String getTo()
	{
		return To;
	}
}//Class ends here
