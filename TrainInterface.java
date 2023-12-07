/**
 * 
 */

/**
 * @author Ferdinand K. Yeke
 *
 */
public interface TrainInterface<T> {
	
	//Sets the train model.
	public void setID();
	
	//Sets the amount of routes.
	public void setAmountOfRoutes(int routes);
	
	//Sets the Passenger capacity for the train.
	public void setPassengerCapacity(int capacity);
	
	//Sets the passenger to the train car.
	public void setToTrainCar(String passengers);

}
