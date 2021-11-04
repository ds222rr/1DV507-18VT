package ds222rr_assign1.ferryTransportation;

import java.util.Iterator;	// Get Iterator from the Java Library

public class FerryIterator implements Iterator<Vehicle> {	// implementing the Interator Interface
	private int next = 0;
	private final Vehicle [] fields;
	private final int vehicles;
	
	public FerryIterator(int n, Vehicle [] array) {	// Constructor
		vehicles = n;
		fields = array;
	}

	public boolean hasNext() {		// verify whether the iterator has a next element
		return next < vehicles;
	}
	
	public Vehicle next() throws IndexOutOfBoundsException {	// return the (next) Vehicle, increase next by one
		return fields[next++];
	}
}
