package ds222rr_assign2.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class representing an queue consisting Node objects, which are linked among themselves. It allows to 
 * create new Node objects and to enqueue Node objects, which contains an object variable, at the end of
 * the queue, and to dequeue Node objects at the begin of the queue. It provides also an Iterator to
 * traverse all Node objects and return their values.
 * 
 * A LinkedQueue object has unlimited capacity, its Node objects form a chain, every object has a 
 * reference to its next Node object. The LinkedQueue object itself has a reference to the 
 * first(<code>head</code>) Node object and the last(<code>tail</code>) Node object of the queue.
 * 
 * Illegal operations (calling first(), last() or dequeue() methods on an queue having <code>size</code> = 0)
 * throw a <code>RunTimeException</code>.
 * 
 * @author Dennis Steinhilber
 * 
 */

public class LinkedQueue implements Queue {

	private Node head = null;		// Head of the queue
	private Node tail = null;		// Tail of the queue
	private int size = 0;			// Size of the queue
	
	/** Constructs a new instance of LinkedQueue
	 */
	public LinkedQueue() {}
	
	/** Returns the current amount of objects connected to the LinkedQueue
	 * @return		An integer containing the number of objects connected to the LinkedQueue		
	 */
	public int size() {							 
		return size;
	}

	/** Returns true if there are no Node objects connected to the LinkedQueue
	 * @return	   Boolean <code>size</code> == 0
	 *  */
	public boolean isEmpty() {					
		return head == null;
	}
	
	/** Adds a new Node object at the end (and begin of queue is empty) of the LinkedQueue
	 * @param      n to be added to the queue.
	 */
	public void enqueue(Object n) {
		if (head == null) {			// In case there is no node connected to head
			head = new Node(n);
			tail = head;			// Head and tail point at the same node (size: 1)
		}
		else {
			tail.next = new Node(n);	// New Node attached to tail.next
			tail = tail.next;			// New Node becomes new tail
		}
		size++;
	}
	
	/** Removes and returns the Node object at the begin of the LinkedQueue
	 * @return		The Object which was located at the begin of the LinkedQueue
	 * @throws		RuntimeException if LinkedQueue's <code>size</code> = 0
	*/
	public Object dequeue() {
		checkEmpty();		// Throws RuntimeException in case of an empty queue
		Node node = head;	// Store node to be dequeued temporary for return	
		head = head.next;	// Dequeue node
		size--;
		return node.value;
	}

	/** Returns the Node object at the begin of the LinkedQueue without removing it 
	 *	@return		The Object which is located at the begin of the LinkedQueue
	 *	@throws		RuntimeException if LinkedQueue's <code>size</code> = 0
	*/
	public Object first() {
		checkEmpty();		// Throws RuntimeException in case of an empty queue
		return head.value;
	}
	/** Returns the Node object at the end of the LinkedQueue without removing it 
	 * 	@return		The Object which is located at the end of the LinkedQueue
	 *	@throws		RuntimeException if LinkedQueue's <code>size</code> = 0
	*/
	public Object last() {
		checkEmpty();		// Throws RuntimeException in case of an empty queue
		return tail.value;
	}
	
	/** Returns a String containing all Node object that are currently in the LinkedQueue 
	 * 	@return		String Object containing all Node values
	*/
	public String toString() {
		StringBuilder sb = new StringBuilder();		// Create new StringBuilder object
		sb.append("[ ");
		Node node = head;
		for (int i = 0; i < size; i++) {
			sb.append(node.value + " ");
				node = node.next;
		}
		sb.append(']');
		return sb.toString();
	}
	
	/** Returns an Iterator which traverses all Node objects of the LinkedQueue and returns their values 
	 * 	@return		Iterator traversing Nodes and returning their values
	*/
	public Iterator<Object> iterator() {
		return new linkedQueueIterator();
	}
	
	private class Node {		// Private inner class
		
		private Object value;		// Value of the node
		private Node next;			// Pointer to the following node
		
		Node(Object v) {			// Constructor
			value = v;
			next = null;
		}
	}
	
	private void checkEmpty() {	// Private help method to check methods on queue
		if (size == 0) {
			System.out.println("Illegal operation: remove//get on empty queue!");
			throw new RuntimeException();
		}
	}
	
	private class linkedQueueIterator implements Iterator<Object> {	// Private inner class
		private Node node = head;	// Starting Point
		
		public Object next() {	// Traverse to next element
			if (!hasNext()) {	// In case hasNext = false
				throw new NoSuchElementException();
			}
			Node previous = node;
			node = node.next;
			return previous.value;
		}
		
		public boolean hasNext() {	// True if queue element has a following element
			return node != null;
		}
	}
}
