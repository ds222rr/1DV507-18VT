package ds222rr_assign4.binheap;

public class WorkTask implements Task, Comparable<Task> {
	
	private int priority;	// Task priority
	private String description;	// Task description
	
	public WorkTask(int prior, String desc) {	// Constructor
		priority = prior;
		description = desc;
	}

	public int getPriority() {	// Returns priority
		return priority;
	}

	public String getDescription() {	// Returns description
		return description;
	}
	
	public String toString() {	// Returns print-out
		return ("Priority: "+priority+"; Description: "+description);
	}

	public int compareTo(Task otherTask) {		// Returns 1, 0, or -1
		WorkTask taskTwo = (WorkTask) otherTask;
		if (priority < taskTwo.priority) {
			return -1;
		}
		if (priority > taskTwo.priority) {
			return 1;
		}
		return 0;
	}

}
