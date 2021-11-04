package ds222rr_assign1.ferryTransportation;

import java.util.Iterator;

public class FerryClass implements ferry {
	private final int PASSENGER_SIZE = 200;		// Maximum passengers
	private final int VEHICLE_SIZE = 40;		// Maximum vehicle size
	private Passenger [] passengers = new Passenger [PASSENGER_SIZE];	// Array for passengers
	private Vehicle [] vehicles = new Vehicle [VEHICLE_SIZE];			// Array for vehicles
	private int money = 0;												// earned money
	private int currentPassengers = 0;									// count passengers
	private int currentVehicles = 0;									// count vehicles
	private double usedVehiclesSpace = 0;								// count used space of vehicles
	private final String name;
	
	public FerryClass(String n) {
		name = n;
	}
	
	public int countPassengers() {				// Number of passengers on board
		return currentPassengers;
	}
	  
	public int countVehicleSpace() {			// Used vehicle space. One car is 1.
		return (int) (usedVehiclesSpace + (countVehicles("Bicycle")*0.2));	// Count the space of bicycles separately
	}
	  
	public int countMoney() {					// Earned money
		return money;
	}
	  
	public Iterator<Vehicle> iterator() {		// Vehicle iterator  
		return new FerryIterator(currentVehicles, vehicles);
	}
	
	public void embark(Vehicle v) {				// Embark vehicle, warning if not enough space
		if (embarked(v)) {							// In case vehicles is already embarked
			System.out.println("Vehicle is already embarked!");
		}
		else if (!hasSpaceFor(v)) {					// In case there is not enough space for vehicle v
			System.out.println("Not enough space to embark this Vehicle!");	
		}
		else if (currentPassengers+v.passengers > PASSENGER_SIZE)	// In case there is not enough space for the passengers
			System.out.println("Not enough space to embark the number of passengers!");	
		else {
			vehicles[currentVehicles++] = v;	// Add vehicle v to array
			v.embarkedOnFerry = this;
			// Iterative statement to embark the passengers of vehicle v
			for (int i = 0; i < v.passengers; i++) {
				passengers[currentPassengers++] = new Passenger();
			}
			if (v.getType() != "Bicycle") {		// Do not count the space for bicycles due to its double value
				usedVehiclesSpace += v.size;
			}
			money += v.price;					// increase earned money
		}
	}  
	
	protected boolean embarked (Vehicle v) {	// Check whether a vehicle is already embarked
		boolean isEmbarked = false;
		for (int j = 0; j < currentVehicles; j++) {
			// In case vehicle's ID has been found in the vehicles-array
			if (vehicles[j].getID() == v.getID()) {
				isEmbarked = true;
				break;	
			}
		}
		return isEmbarked;
	}
	
	public void embark(Passenger p) {			// Embark passenger, warning if not enough room
		// In case there is not enough space for passenger p
		if (!hasRoomFor(p)) {
			System.out.println("Not enough space to embark this passenger!");
		}
		else {
			passengers[currentPassengers++] = p;	// Add passenger p to array
			money += p.getPrice();					// increase earned money
		}
	}
	
	public void disembark() {                  // Clear (empty) ferry. The money earned remains, 
		currentPassengers = 0;				   // i.e., is not reset to zero 
		currentVehicles = 0;
		usedVehiclesSpace = 0;
	}
	
	public boolean hasSpaceFor(Vehicle v) {    // true if we can embark vehicle v
		// Count the used space of bicycles separately due to its double value
		double temp = (double) (VEHICLE_SIZE-usedVehiclesSpace-(Math.round((countVehicles("Bicycle")*0.2)*10)/10));
		return temp >= v.getSize();
	}
	
	public boolean hasRoomFor(Passenger p) {   // true if we can embark passenger p
		return currentPassengers+p.getSize() <= PASSENGER_SIZE;
	}
	
	public String toString() {                 // Nice looking ferry status print out
		StringBuilder sb = new StringBuilder();
		sb.append("\nNumber of passengers on ferry: "+currentPassengers+"\n");
		sb.append("Number of vehicles on ferry: "+currentVehicles+"\n");
		sb.append("\tLorries: "+countVehicles("Lorry")+"\n");
		sb.append("\tBusses: "+countVehicles("Bus")+"\n");
		sb.append("\tCars: "+countVehicles("Car")+"\n");
		sb.append("\tBicycles: "+countVehicles("Bicycle")+"\n");
		sb.append("Money earned: "+money+"\n");
		return sb.toString();
	}
	
	private int countVehicles(String ty) {		// Count all types of vehicle
		int num = 0;
		for (int i = 0; i < currentVehicles; i++) {
			if (vehicles[i].type == ty) {
				num++;
			}
		}
		return num;
	}
	
	public String getName() {					// Get name of ferry
		return name;
	}
}
