package ds222rr_assign4.binheap;

public interface Task extends Comparable<Task> {
	
	public int getPriority();		// Returns priority of the Task
	
	public String getDescription();	// Returns description of the Task
	
}
