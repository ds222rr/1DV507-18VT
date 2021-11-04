package ds222rr_assign2.queue;

import java.util.Iterator;

/**
 * This interface defines the functionality for a queue implementation. The functionality includes
 * enqueuing elements in and dequeuing elements out from a Queue, as well as accessing the first and the 
 * last element of a Queue and to iterate all Node objects using an iterator.
 * 
 * Illegal operations (calling first(), last() or dequeue() methods on queue having <code>size</code> = 0)
 * should throw a <code>RunTimeException</code>.
 * 
 * @author Author
 */

public interface Queue {  
	
		/** Returns the current amount of objects connected to the LinkedQueue
		 * @return		An integer containing the number of objects connected to the LinkedQueue		
		 */
	   public int size();                     // current queue size 
	   
		/** Returns true if there are no objects connected to the LinkedQueue 
		 * @return		boolean <code>size</code> == 0
		 * */
	   public boolean isEmpty();              // true if queue is empty 
	   
		/** Adds a new object at the end (and begin of queue is empty) of the Queue
		 * @param		n to be added to the queue.
		 */
	   public void enqueue(Object n);   // add element at end of queue 
	   
		/** Removes and returns the object at the begin of the Queue
		 * @return		The object which was located at the begin of the Queue
		 * @throws		RuntimeException if Queue's <code>size</code> = 0
		*/
	   public Object dequeue();               // return and remove first element. 
	   
		/** Returns the object at the begin of the Queue without removing it 
		 *	@return		The object which is located at the begin of the Queue
		 *	@throws		RuntimeException if Queue's <code>size</code> = 0
		*/
	   public Object first();                 // return (without removing) first element 
	   
		/** Returns the object at the end of the Queue without removing it 
		 * 	@return		The object which is located at the end of the Queue
		 *	@throws		RuntimeException if Queue's <code>size</code> = 0
		*/
	   public Object last();                  // return (without removing) last element 
	   
		/** Returns a String containing all object that are currently in the Queue 
		 * 	@return		String Object containing all objects values
		*/
	   public String toString();              // return a string representation of the queue content
		
	   /** Returns an Iterator which traverses all objects of the Queue and returns their values
		*  @return		Iterator traversing Nodes and returning their values
		*/
	   public Iterator<Object> iterator();    // element iterator
	}