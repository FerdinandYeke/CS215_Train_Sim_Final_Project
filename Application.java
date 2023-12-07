/**
 * @author Ferdinand K. Yeke
 *
 */
import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
//import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;

public class Application {
	
	public static void clear()

    {
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

	/**
	 * @param args
	 * @throws EmptyQueueException 
	 */
	public static void main(String[] args) throws EmptyQueueException {
		// TODO Auto-generated method stub
		
		//Creates a new train instance/object from the TrainClass.
		TrainClass train = new TrainClass();
		Random rand = new Random();
		Queue<String> linked = new LinkedList<String>();
		
		//Sets the train's amount of routes, its id, and PassengerCapacity.
		train.setAmountOfRoutes(4);
		train.setID();
		train.setPassengerCapacity(100);
		
		//Creates a new passengers instance/object from the Passenger Class
		PassengerClass passengers = new PassengerClass();
		
		/*A variable that holds a randomly generated number from 20 to 100,
		 * which represents the amount of passenger there will be in a train car.
		 */
		int passengerAmountGen;
		passengerAmountGen = rand.nextInt(25,100);
		
		/*
		 * This generates the passengers name, and the amount of names that gets created by using 
		 * the passengerAmountGen variable, which also already stores a randomly generated integer value.
		 */
		passengers.genPassengerNames(passengerAmountGen);
		
		/*
		 * After that, the train method setToTrainCar tries to add all the passengers into cars
		 */
		train.setToTrainCar(passengers.getAllPassengers());
		
		/*
		 * A new TrainStation instance/object gets created here.
		 */
		TrainStation mainStation = new TrainStation();
		
		/*
		 * This is the where the part of trains being "generated" starts. First, the mainStation sets a trainName from the already
		 * generated train ID from the current setID method. Then the mainStation sets a random location of where a train is departing
		 * from, and a randomly generated place of where a train is going to. mainStation also generates the "estimated" time it takes
		 * from a train to reach its destination.
		 */
		mainStation.setTrainName(train.getID());
		mainStation.addFrom();
		mainStation.addTo();
		mainStation.addTime();
		
		class timePlugin extends TimerTask
		{
			public static int i = 0;
			
			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				/*
				 * This is the where the part of trains being "generated" TRULY starts. First, the mainStation sets a ANOTHER 
				 * trainName from the already generated train ID from the current setID method. Then 
				 * the mainStation sets ANOTHER random location of where a train is departing from, and a randomly generated place of 
				 * where a train is going to. mainStation also generates the "estimated" time it takes
				 * from a train to reach its destination. Each increment of the timer, a new trainStation instance gets created, and
				 * the steps repeat, while all of them get added to a linked list. 
				 */
				System.out.println(""+ ++i+" Seconds");
				System.out.println("Train ID: ["+mainStation.getTrainName()+"]. Departing from: ["+mainStation.getFrom()+".] Going to: ["+mainStation.getTo()+"]. "
						+ "Arrival Time: "+mainStation.getTime());
				
				new TrainStation();
				
				train.setID();;
				mainStation.setTrainName(train.getID());
				mainStation.addFrom();
				mainStation.addTo();
				mainStation.addTime();
				linked.add(train.getID());
				clear();
				//These lines could also be enqueued into a Queue or ArrayList
				//for consistency.
				
				
			}
			
		}//Outer time class ends here

		
		TimerTask taskWithTime = new timePlugin();
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(taskWithTime, 2000, 5000);
		//timer.cancel();
			
	}

}

