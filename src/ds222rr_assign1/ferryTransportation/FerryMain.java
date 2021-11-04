package ds222rr_assign1.ferryTransportation;

import java.util.Iterator;	// Get Iterator from Java Library

public class FerryMain {
	public static void main(String[] args) {
		FerryClass ferry = new FerryClass("ferry 1");	// Create new FerryClass object
		for (int i = 0; i < 154; i++) {			// Embark 154 passengers
			ferry.embark(new Passenger());
		}
		Vehicle v1 = new Car(4);				// Vehicle (with amount of passengers)
		Vehicle v2 = new Car(4);
		Vehicle v3 = new Lorry(2);
		Vehicle v4 = new Lorry(2);
		Vehicle v5 = new Bus(20);
		Vehicle v6 = new Lorry(2);
		Vehicle v7 = new Bus(20);
		Vehicle v8 = new Lorry(2);
		Vehicle v9 = new Lorry(2);
		Vehicle v10 = new Car(4);
		ferry.embark(v1);
		ferry.embark(v2);
		ferry.embark(v3);
		ferry.embark(v2);		// Message: Vehicle is already embarked!
		ferry.embark(v4);
		ferry.embark(v5);
		ferry.embark(v6);
		ferry.embark(v7);		// Message: Not enough space to embark the number of passengers!
		ferry.embark(v8);
		ferry.embark(v9);		// Message: Not enough space to embark this Vehicle!
		ferry.embark(v10);
		
		System.out.println("Vehicle is on ferry: "+v1.isOnFerry());						// ferry 1
		System.out.println("Current passengers on ferry: "+ferry.countPassengers());	// 194
		System.out.println("Money earned so far: "+ferry.countMoney());					// 5280
		
		Vehicle v11 = new Bicycle();
		Vehicle v12 = new Bicycle();
		Vehicle v13 = new Bicycle();
		Vehicle v14 = new Bicycle();
		Vehicle v15 = new Bicycle();
		Vehicle v16 = new Bicycle();

		ferry.embark(v10);		// Message: Vehicle is already embarked!
		ferry.embark(v11);
		ferry.embark(v12);
		ferry.embark(v13);		
		ferry.embark(v14);
		ferry.embark(v15);		
		ferry.embark(v16);		// Message: Not enough space to embark this Vehicle!
		
		if (v16.isEmbarked()) {
			System.out.println("Vehicle is embarked!");
		}
		else {
			System.out.println("Vehicle is not embarked!");		// v16 = not embarked
		}
		
		if (v15.isEmbarked()) {
			System.out.println("Vehicle is embarked!");			// v15 = embarked
		}
		else {
			System.out.println("Vehicle is not embarked!");
		}
		
		Passenger p1 = new Passenger();					// Create new Passenger object
		Passenger p2 = new Passenger();					// Create new Passenger object

		ferry.embark(p1);
		ferry.embark(p2);		// Message: Not enough space to embark this passenger!

		System.out.println(ferry.toString());
		
		
		// Check Iterator
		Iterator<Vehicle> it = ferry.iterator();	// Create new Iterator object
		System.out.print("\nVehicles on the ferry: ");
		while (it.hasNext()) {
			Vehicle n = it.next();
			System.out.print(n.type+" ");
		}
	}
}
