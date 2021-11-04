package ds222rr_assign1.ferryTransportation;

public class Car extends Vehicle {
	public Car(int a) {
		type = "Car";						// Type of vehicle
		size = 1;							// Size of the vehicle in Cars
		space = 4;							// Maximum space for passengers on vehicle
		passengers = checkPass(a, space);	// Passengers on vehicle
		price = 100 + (passengers *15);		// Total price for transportation
	}
}
