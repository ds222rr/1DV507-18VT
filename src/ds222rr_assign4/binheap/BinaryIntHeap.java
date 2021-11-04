package ds222rr_assign4.binheap;

import java.util.NoSuchElementException;

public class BinaryIntHeap {
	private int size = 0;				// Size of heap
	private int[] arr = new int[2];		// Array to store the heap
	private int temp;					// to temporary store a value 
	
	public BinaryIntHeap() {
	}

	public void insert(int n) {		// Add n to heap
		if (size+1 == arr.length) {	// Resize if size+1 == Array-length
			resize();
		}
		arr[++size] = n;	// Insert n to heap
		int num = size;		// to identify the position of the value that might be swapped
		// In case a value is larger than its parent
		while (num > 1 && arr[num] > arr[num/2]) {
			temp = arr[num/2];
			arr[num/2] = arr[num];
			arr[num] = temp;
			num = num/2;	// Update num to get the new position of the value that might be swapped
		}
	}
	
	public int pullHighest() {		// Return and remove element with highest priority
		if (isEmpty()) {	// Throw NoSuchElementException
			System.out.println("Illegal operation: pull on empty binary heap!");
			throw new NoSuchElementException();
		}
		int num = 1;
		int highest = arr[num];		// Store highest element to return it
		arr[num] = arr[size];		// Last element becomes the root
		arr[size--] = 0;			// Last position of the Array is deleted
		// Iterative statement to swap positions
		while (num < size && (arr[num] < arr[num*2] || arr[num] < arr[num*2+1])) {
			// If the leftChild has the larger value
			if (arr[num*2] > arr[num*2+1]) {	
				temp = arr[num*2];
				arr[num*2] = arr[num];
				arr[num] = temp;
				num = num*2;
			}
			// If the rightChild has the larger value
			else if (arr[num*2] < arr[num*2+1]) {
				temp = arr[num*2+1];
				arr[num*2+1] = arr[num];
				arr[num] = temp;
				num = num*2+1;
			}
		}
		return highest;
	}
	
	public String toString() {		// Print the heap
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i = 0; i < size+1; i++) {
			if (i != 0)
				sb.append(arr[i]+" ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public int size() {				// Current heap size
		return size;
	}
	
	public boolean isEmpty() {		// True if heap is empty
		return size == 0;
	}
	
	private void resize() {			// Resize the heap
		int[] tempArr = new int[arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i];
		}
		arr = tempArr;
	}	
}
