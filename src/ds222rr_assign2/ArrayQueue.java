package ds222rr_assign2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ds222rr_assign2.queue.Queue;

public class ArrayQueue implements Queue {
	
	private int first = 0;		// First element to dequeue
	private int last = 0;		// Last element added to the queue
	private int size = 0;		// Number of elements in the queue
	private Object [] circularArray = new Object [4];	// Array representing the queue
	
	public int size() {		// Get the current size of the Array
		return size;
	}
	
	public boolean isEmpty() {		// Returns true if the size = 0
		return size == 0;
	}
	
	public void enqueue(Object element) {		// Enqueuing an element
		if (size == circularArray.length) {		// In case the Array is full
			resize();
		}
		if (size == 0) {						// In case of an empty Array
			circularArray[size++] = element;
		}
		else {
			// In case the place at the end of the Array is occupied
			if (last == circularArray.length-1) {
				last = 0;
				// Store the last element at the first place of the Array
				circularArray[last] = element; 
			}
			else {	// Append element on the queue's end
				circularArray[++last] = element;
			}
			size++;
		}
	}
	
	public Object dequeue() {		// Dequeuing an element
		checkEmpty();	// Throws RuntimeException in case of an empty queue
		Object dequeued = circularArray[first++];
		// In case the dequeued element was at the last place of the Array
		if (first == circularArray.length) {
			first = 0;
		}
		size--;
		// In case the Queue has been cleared
		if (size == 0) {
			first = 0;
			last = 0;
		}
		return dequeued;
	}
	
	// Return an Iterator to traverse over all objects of the ArrayQueue
	public Iterator<Object> iterator() {
		return new arrayQueueIterator();
	}
	
	public String toString() {		// Get a printout of the Queue
		StringBuilder sb = new StringBuilder();		// Create new StringBuilder object
		sb.append("[ ");
		// In case of an empty String
		if (size == 0) { // no action
		}
		// In case the first element comes before the last element in the Array
		else if (first <= last) {
			// Iterative statement to append the elements of the Queue regularly
			for (int i = first; i <= last; i++) {
				sb.append(circularArray[i] + " ");
			}
		}
		// In case the last element comes before the first element in the Array
		else {
			// Iterative statement to append the elements of the queue from first to the end
			for (int i = first; i < circularArray.length; i++) {
				sb.append(circularArray[i] + " ");
			}
			// Iterative statement to append the elements of the queue from the begin to last
			for (int i = 0; i <= last; i++) {
				sb.append(circularArray[i] + " ");
			}
		}
		sb.append(']');
		return sb.toString();
	}
	
	public Object first() {		// Get the the first element in the Array
		checkEmpty();			// Throws RuntimeException in case of an empty queue
		return circularArray[first];
	}
	
	public Object last() {		// Get the the last element in the Array
		checkEmpty();			// Throws RuntimeException in case of an empty queue
		return circularArray[last];
	}
	
	private void checkEmpty() {		// Private help method
		if (size == 0) {
			System.out.println("Illegal operation: remove//get on empty queue!");
			throw new RuntimeException();
		}
	}
	
	private void resize() {		// Method to increase the size of the Array
		Object [] temp = new Object[2*circularArray.length];	// Temp-Array
		// In case the first element comes before the last element in the Array
		if (first <= last) {
			// Iterative statement to copy the elements of the Queue regularly
			for (int i = first; i <= last; i++) {
				temp[i-first] = circularArray[i];
			}
		}
		// In case the last element comes before the first element in the Array
		else {
			// Iterative statement to copy the elements of the queue from first to the end
			for (int i = first; i < circularArray.length; i++) {
				temp[i-first] = circularArray[i];
			}
			// Iterative statement to copy the elements of the queue from the begin to last
			for (int i = 0; i <= last; i++) {
				temp[i+circularArray.length-first] = circularArray[i];
			}
		}
		first = 0;			// Set first to the element at the begin of the Array
		last = size-1;		// Set last to the last element of the Queue
		circularArray = temp; 	// New reference for circularArray
	}
	
	private class arrayQueueIterator implements Iterator<Object> {	// Private inner class
		private int nextObject = 0;	// Starting Point
		
		public Object next() {	// Traverse to next element
			if (!hasNext()) {	// In case hasNext = false
				throw new NoSuchElementException();
			}
			return circularArray[nextObject++];
		}

		public boolean hasNext() {	// True if queue element has a following element
			return nextObject < size;
		}
	}
}
