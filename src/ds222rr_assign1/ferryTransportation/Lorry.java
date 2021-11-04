package ds222rr_assign1.ferryTransportation;

public class Lorry extends Vehicle {
	public Lorry(int a) {
		type = "Lorry";						// Type of vehicle
		size = 8;							// Size of the vehicle in Cars
		space = 2;							// Maximum space for passengers on vehicle
		passengers = checkPass(a, space);	// Passengers on vehicle
		price = 300 + (passengers *15);		// Total price for transportation
	}
}
