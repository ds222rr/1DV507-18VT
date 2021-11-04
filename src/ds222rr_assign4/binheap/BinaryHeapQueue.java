package ds222rr_assign4.binheap;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryHeapQueue implements PriorityQueue {
	
	private int size = 0;				// Size of heap
	private Task[] arr = new Task[2];	// Array to store the heap
	private Task temp;					// to temporary store a value 
	
	public BinaryHeapQueue() {}

	public boolean isEmpty() {	// Returns true if Queue us empty
		return size == 0;
	}

	public int size() {		// Returns number of elements in the Queue
		return size;
	}

	public void insert(Task t) {
		if (size+1 == arr.length) {	// Resize if size-1 == Array-length
			resize();
		}
		arr[++size] = t;	// Insert n to heap
		int num = size;		// to identify the position of the value that might be swapped
		// In case a value is larger than its parent
		while (num > 1 && arr[num].compareTo(arr[num/2]) == 1) {
			temp = arr[num/2];			
			arr[num/2] = arr[num];
			arr[num] = temp;
			num = num/2;	// Update num to get the new position of the value that might be swapped
		}
	}


	public Task peekHighest() {// Returns element in the root without removing it
		if (isEmpty()) {	// Throw NoSuchElementException
			System.out.println("Illegal operation: pull on empty binary heap!");
			throw new NoSuchElementException();
		}
		return arr[1];
	}


	public Task pullHighest() {		// Returns and removes element in the root
		if (isEmpty()) {	// Throw NoSuchElementException
			System.out.println("Illegal operation: pull on empty binary heap!");
			throw new NoSuchElementException();
		}
		int num = 1;
		Task highest = arr[num];		// Store highest element to return it
		arr[num] = arr[size];		// Last element becomes the root
		arr[size--] = null;			// Last position of the Array is deleted
		// Iterative statement to swap positions
		while (num < size && arr[num*2] != null && (arr[num].compareTo(arr[num*2]) == -1 || arr[num*2+1] != null && arr[num].compareTo(arr[num*2+1]) == -1)) {
			// If the leftChild has the larger value
			if (arr[num*2+1] == null || arr[num*2].compareTo(arr[num*2+1]) == 1) {	
				temp = arr[num*2];
				arr[num*2] = arr[num];
				arr[num] = temp;
				num = num*2;
			}
			// If the rightChild has the larger value
			else if (arr[num*2] == null || arr[num*2].compareTo(arr[num*2+1]) == -1) {
				temp = arr[num*2+1];
				arr[num*2+1] = arr[num];
				arr[num] = temp;
				num = num*2+1;
			}
		}
		return highest;
	}


	public boolean contains(Task t) {	// Returns true if Task t is found
		for (int i = 1; i < size-1; i++) {
			if (arr[i].equals(t)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {		// Print the heap
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size+1; i++) {
			if (i != 0)
				sb.append("Priority: "+arr[i].getPriority()+"; Task: "+arr[i].getDescription()+"\n");
		}
		return sb.toString();
	}
	
	public Iterator<Task> iterator() {
		return new BinaryHeapQueueIterator();
	}
	
	private void resize() {			// Resize the heap
		Task[] tempArr = new Task[arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i];
		}
		arr = tempArr;
	}
	
	private class BinaryHeapQueueIterator implements Iterator<Task> {
		
		private final Task[] array;
		private boolean flag[];
		private int num;
		private int next = 1;
		private int a = 1;
		
		public BinaryHeapQueueIterator() {
			array = arr;
			num = size;
			flag = new boolean[array.length];	// Array to mark traversed Tasks
		}
		
		public boolean hasNext() {
			return next-1 < num;
		}
		
		public WorkTask next() {
			if (!hasNext()) {
				System.out.print("Illegal operation: next on empty structure!");
				throw new NoSuchElementException();
			}
			int count = 1;
			while (flag[count] == true) {	// Skip all traversed Tasks
				count++;
			}		
			WorkTask wT = (WorkTask) array[count];
			// In case array position is higher than 1
			if (count > 1) {
				a = count;
				// Iterative statement to check for a Task with a higher priority
				while (count < num) {
					if (flag[count+1] == false && array[a].compareTo(array[count+1]) == -1) {
						a = count+1;
					}
					count++;
				}
			}
			wT = (WorkTask) array[a];
			flag[a] = true;
			next++;
			return  wT;
		}
		
	}



}
