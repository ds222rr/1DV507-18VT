package ds222rr_assign1.ferryTransportation;

public abstract class Vehicle {
	protected static int count = 0;				// Counter for ID
	protected final int ID;
	protected String type;						// Type of vehicle
	protected double size;						// Size of the vehicle in Cars
	protected int space;						// Maximum space for passengers on vehicle
	protected int passengers;					// Passengers on vehicle
	protected int price;						// Total price for transportation
	protected FerryClass embarkedOnFerry;		// Ferry of the vehicle
	
	public Vehicle() {
		count++;
		ID = count;								// Unique ID for every Vehicle
	}

	
	public double getSize() {					// Return size of the vehicle
		return size;
	}
	
	public int getSpace() {						// return space of the vehicle
		return space;
	}
	
	public int getPrice() {						// return total price of the vehicle
		return price;
	}
	
	public int getID() {						// return ID of the vehicle
		return ID;
	}
	
	public String getType() {					// return type of the vehicle
		return type;
	}
	
	public int getPassengers() {				// return number of passengers on the vehicle
		return passengers;
	}
	
	public String isOnFerry() {					// return the name of the ferry the vehicle is embarked on
		StringBuilder sb = new StringBuilder();
		sb.append(embarkedOnFerry.getName().toString());
		return sb.toString();
	}
	
	public boolean isEmbarked() {				// return whether the vehicle is embarked or not
		if (embarkedOnFerry == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	protected int checkPass(int pass, int sp) {		// Verify whether the number of passengers
		if (pass <= sp && pass > 0) {
			return pass;
		}
		else {
			System.err.print("Invalid number of passengers!");
			throw new RuntimeException();
		}
	}
}
