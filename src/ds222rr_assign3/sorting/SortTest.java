package ds222rr_assign3.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.Random;

class SortTest {
	
	public static int number;

	@BeforeEach
	void count() {
		number++;
		System.out.println("Test number: "+number);
	}
		
	@Test
	void testIntegerInsertionSort() {
		int[] arr = createIntArray();
		int[] sortArr = SortingAlgorithms.insertionSort(arr);
		for (int i = 0; i < sortArr.length-1; i++) {
			assertEquals(true, sortArr[i] <= sortArr[i+1]);
			assertEquals(false, sortArr[i] > sortArr[i+1]);
		}	
	}
	
	@Test
	void testStringInsertionSort() {
		String[] arr = createStringArray();
		assertEquals("House Table Book Wall Car Chair Pencil Envelope Dog Cat", SortingAlgorithms.printString(arr));
		Comparator<String> comparator = (n1, n2) -> n1.compareTo(n2);
		String[] sortArr = SortingAlgorithms.insertionSort(arr, comparator);
		assertEquals("Book Car Cat Chair Dog Envelope House Pencil Table Wall", SortingAlgorithms.printString(sortArr));	
	}
	
	@Test
	void testIntegerMergeSort() {
		int[] arr = createIntArray();
		int[] sortArr = SortingAlgorithms.mergeSort(arr);
		for (int i = 0; i < sortArr.length-1; i++) {
			assertEquals(true, sortArr[i] <= sortArr[i+1]);
			assertEquals(false, sortArr[i] > sortArr[i+1]);
		}		
	}
	
	@Test
	void testStringMergeSort() {
		String[] arr = createStringArray();
		assertEquals("House Table Book Wall Car Chair Pencil Envelope Dog Cat", SortingAlgorithms.printString(arr));
		Comparator<String> comparator = (n1, n2) -> n1.compareTo(n2);
		String[] sortArr = SortingAlgorithms.mergeSort(arr, comparator);
		assertEquals("Book Car Cat Chair Dog Envelope House Pencil Table Wall", SortingAlgorithms.printString(sortArr));	;		
	}
	
	// Private help method
	private int[] createIntArray() {	// method to create an int-array
		int[] in = new int[10];
		int size = 0;
		Random rand = new Random();		// Create new Random object
		int random = 0;
		for (int i = 0; i < in.length; i++) {
			boolean  flag = false;			// control flag
			random = rand.nextInt(100);		// Random integer for int-array
			for (int j = 0; j < size; j++) {
				if (random == in[j]) {		// In case random number is already in the array
					flag = true;
				}
			}
			if (flag == false) {	// In case random number is not in the array
				in[i] = random;
				size++;
			}
		}
		return in;
	}
	
	// Private help method
	private String[] createStringArray() {	// method to create a String-array
		String[] in = {"House", "Table", "Book", "Wall", "Car", 
					   "Chair", "Pencil", "Envelope", "Dog", "Cat"};
		return in;
	}
}
