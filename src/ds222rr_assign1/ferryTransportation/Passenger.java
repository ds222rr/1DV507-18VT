package ds222rr_assign1.ferryTransportation;

public class Passenger {
	private static int count = 0;		// Counter for ID
	private final int ID;
	private final int size = 1;			// Size of the passenger
	private final int price = 20;		// Total price for transportation
	
	public Passenger() {
		count++;
		ID = count;						// Unique ID for every passenger
	}
	
	public int getID() {				// Return ID of the passenger
		return ID;
	}
	
	public int getSize() {				// Return size of the passenger
		return size;
	}
	
	public int getPrice() {				// Return price for the transportation
		return price;
	}
}
