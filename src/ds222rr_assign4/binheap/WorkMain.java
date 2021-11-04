package ds222rr_assign4.binheap;

import java.util.Iterator;

public class WorkMain {
	public static void main(String[] args) {
		WorkTask[] workTasks = new WorkTask[12];
		BinaryHeapQueue bhq = new BinaryHeapQueue();	// Create new BinaryHeapQueue object
		
		// Create some WorkTasks
		workTasks[0] = new WorkTask(6, "WorkTask 1");
		workTasks[1] = new WorkTask(12, "WorkTask 2");
		workTasks[2] = new WorkTask(4, "WorkTask 3");
		workTasks[3] = new WorkTask(60, "WorkTask 4");
		workTasks[4] = new WorkTask(142, "WorkTask 5");
		workTasks[5] = new WorkTask(312, "WorkTask 6");
		workTasks[6] = new WorkTask(64, "WorkTask 7");
		workTasks[7] = new WorkTask(26, "WorkTask 8");
		workTasks[8] = new WorkTask(99, "WorkTask 9");
		workTasks[9] = new WorkTask(3, "WorkTask 10");
		workTasks[10] = new WorkTask(11, "WorkTask 11");
		workTasks[11] = new WorkTask(41, "WorkTask 12");
		
		// Add WorkTasks to 'bhq'
		for (int i = 0; i < workTasks.length-1; i++) {
			bhq.insert(workTasks[i]);
		}
		System.out.println("Tree contains WorkTask 5: "+bhq.contains(workTasks[5]));	// Expect true
		System.out.println("Tree contains WorkTask 11: "+bhq.contains(workTasks[11]));	// Expect false
		System.out.println("");
		
		System.out.println(bhq.toString());

		// Expect: 312, Task 6
		System.out.println("Peekout");
		WorkTask t13 = (WorkTask) bhq.peekHighest();
		System.out.println("Number 13: "+t13.getPriority()+" "+t13.getDescription());
		System.out.println("");
		
		System.out.println(bhq.toString());
		
		// Traverse over all WorkTasks
		System.out.println("WorkTask Iteration");
		Iterator<Task> it = bhq.iterator();
		while (it.hasNext()) {
			WorkTask wT = (WorkTask) it.next();
			System.out.println(wT.getDescription()+" ");
		}
		System.out.println("");
		
		// Expect: 312, 142, 99, 64, 60, 26, 12, 11, 6, 4, 3
		System.out.println("Pulling all Tasks");
		int l = bhq.size();
		for (int i = 0; i < l; i++) {
			WorkTask t14 = (WorkTask) bhq.pullHighest();
			System.out.println((i+1)+". "+t14.getPriority()+" "+t14.getDescription());
		}
		
		// Except: empty
		System.out.println(bhq.toString());
		System.out.println("Tree is empty: "+bhq.isEmpty());	// Expect: true;
	}
}
