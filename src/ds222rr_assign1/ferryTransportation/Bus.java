package ds222rr_assign1.ferryTransportation;

public class Bus extends Vehicle {
	public Bus(int a) {
		type = "Bus";						// Type of vehicle
		size = 4;							// Size of the vehicle in Cars
		space = 20;							// Maximum space for passengers on vehicle
		passengers = checkPass(a, space);	// Passengers on vehicle
		price = 200 + (passengers *10);		// Total price for transportation
	}
}
