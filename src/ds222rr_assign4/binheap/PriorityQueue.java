package ds222rr_assign4.binheap;

public interface PriorityQueue extends Iterable<Task> {
	
	public boolean isEmpty();			// Returns true for an empty queue
	
	public int size();					// Returns size of a queue
	
	public void insert(Task t);			// Inserts new element in a queue
	
	public Task peekHighest();			// Returns the highest element of a queue without removing it
	
	public Task pullHighest();			// Returns and removes the highest element of a queue
	
	public boolean contains(Task t);	// Returns true if queue contains t
	
	
}
