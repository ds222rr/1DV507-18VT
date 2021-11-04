package ds222rr_assign1.ferryTransportation;

public class Bicycle extends Vehicle {
	public Bicycle() {
		type = "Bicycle";						// Type of vehicle
		size = 0.2;								// Size of the vehicle in Cars
		space = 1;								// Maximum space for passengers on vehicle
		passengers = space;						// Passengers on vehicle
		price = 40;								// Total price for transportation
	}
}