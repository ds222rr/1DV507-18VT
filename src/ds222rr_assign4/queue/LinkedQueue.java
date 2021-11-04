package ds222rr_assign4.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
	
	private Node head = null;		// Head of the queue
	private Node tail = null;		// Tail of the queue
	private int size = 0;			// Size of the queue
	
	public LinkedQueue() {}
	

	
	public int size() {
		return size;
	}

	
	public boolean isEmpty() {
		return head == null;
	}

	
	public void enqueue(T n) {
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

	
	public T dequeue() {
		checkEmpty();		// Throws RuntimeException in case of an empty queue
		Node node = head;	// Store node to be dequeued temporary for return	
		head = head.next;	// Dequeue node
		size--;
		return node.value;
	}

	
	public T first() {
		checkEmpty();		// Throws RuntimeException in case of an empty queue
		return head.value;
	}

	
	public T last() {
		checkEmpty();		// Throws RuntimeException in case of an empty queue
		return tail.value;
	}

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
	
	public Iterator<T> iterator() {
		return new linkedQueueIterator<T>();
	}
	
	private class Node {		// Private inner class
		
		private T value;		// Value of the node
		private Node next;		// Pointer to the following node
		
		Node(T v) {				// Constructor
			value = v;
			next = null;
		}
	}
	
	private void checkEmpty() {	// Private help method to check methods on queue
		if (size == 0) {
			System.out.println("Illegal operation: remove//get on empty queue!");
			throw new NoSuchElementException();
		}
	}
	
	private class linkedQueueIterator<X> implements Iterator<X> {	// Private inner class
		private Node node = head;	// Starting Point
		
		public X next() {		// Traverse to next element
			if (!hasNext()) {	// In case hasNext = false
				System.out.println("Illegal operation: next on empty queue");
				throw new NoSuchElementException();
			}
			Node previous = node;
			node = node.next;
			return (X) previous.value;
		}
		
		public boolean hasNext() {	// True if queue element has a following element
			return node != null;
		}
	}
}
