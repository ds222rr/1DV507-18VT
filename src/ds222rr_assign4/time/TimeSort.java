package ds222rr_assign4.time;

import java.util.Comparator;
import java.util.Random;

public class TimeSort {
	
	private static long before = System.nanoTime();	// Time before starting
	private static long after = 0;					// Time after finishing
	private static long count = 0;				// Count sorted integers
	private static long countStr = 0;			// Total sorted Strings
	// Comparator for Strings
	private static Comparator<String> comparator = (n1, n2) -> n1.compareTo(n2);

	public static void main(String[] args) {

		// Integer insertion sort
		int[] intArr = createIntArray();
		count = 0;
		before = System.nanoTime();
		inSort(intArr);
		System.out.println("Insertion sort Integer: "+count);
		
		// String insertion sort
		String[] strArr = createStringArray();
		count = 0;
		before = System.nanoTime();
		inSort(strArr);
		System.out.println("Insertion sort String:  "+count);
		
		// Integer merge sort
		intArr = createIntArray();
		count = 0;
		before = System.nanoTime();
		intArr = mergeSort(intArr);
		System.out.println("Merge sort Integer:  "+countStr);
		
		// String merge sort
		strArr = createStringArray();
		count = 0;
		countStr = 0;
		before = System.nanoTime();
		strArr = mergeSort(strArr, comparator);
		System.out.println("Merge sort String:  "+countStr);
	}
	
	public static void inSort(int[] in) {
		// Iterative statement for insertionSort
		for (int i = 0; i < in.length; i++) {		
			int next = in[i];		// next element
			int counter = i;			// counter for position
			while (counter > 0 && in[counter-1] > next) {
				in[counter] = in[counter-1];
				counter--;
			}
			in[counter] = next;
			after = System.nanoTime();
			count++;
			if ((after-before) >= 1000000000) {
				break;
			}
		}
	}
	
	public static void inSort(String[] in) {
		// Iterative statement for insertionSort
		for (int i = 0; i < in.length; i++) {
			String next = in[i];	// next element
			int counter = i;			// counter for position
				while (counter > 0 && comparator.compare(in[counter-1], next) > 0) {
					in[counter] = in[counter-1];
					counter--;
				}
				in[counter] = next;
				after = System.nanoTime();
				count++;
				if ((after-before) >= 1000000000) {
					break;
				}
		}
	}
	
	public static int[] mergeSort(int[] in) {
		if (in.length == 1) {	// Base case
			return in;
		}
		// array to store the first half of 'in'
		int[] first = new int[in.length/2];
		//  array to store the second half of 'in'
		int[] second = new int[in.length-first.length];	
		
		for (int i = 0; i < first.length; i++) {	// Copy the first half of 'in'
			first[i] = in[i];
		}
		
		for (int i = 0; i < second.length; i++) {	// Copy the first half of 'in'
			second[i] = in[first.length+i];
		}
		first = mergeSort(first);	// call the method on the first half
		second = mergeSort(second);	// call the method on the second half
		
		int iFirst = 0;		// counter for the elements of the first half
		int iSecond = 0;	// counter for the elements of the second half
		int j = 0;			// counter for the original array
		// Iterative statement to determine which element should be chosen
		while (iFirst < first.length && iSecond < second.length) {
			// In case first's element is smaller than second's element
			if (first[iFirst] < second[iSecond]) {
				in[j] = first[iFirst++];
			}
			// In case second's element is smaller than first's element
			else {
				in[j] = second[iSecond++];
			}
			j++;	// increase original array's counter
		}
		
		// Only one of the two following iterative statements will be executed
		
		// Append the rest of first array's elements
		while (iFirst < first.length) {
			in[j++] = first[iFirst++];
		}
		// Append the rest of second array's elements
		while (iSecond < second.length) {
			in[j++] = second[iSecond++];
		}
		count++;
		after = System.nanoTime();
		if (after-before <= 1000000000) {
			countStr += count;
			count = 0;
		}
		return in;
	}
	
	public static String[] mergeSort(String[] in, Comparator<String> comparator) {
		if (in.length == 1) {	// Base case
			return in;
		}
		
		String[] first = new String[in.length/2];		// First half of the array
		String[] second = new String[in.length-first.length];	// Second half of the array
		
		for (int i = 0; i < first.length; i++) {	// Copy the first half of 'in'
			first[i] = in[i];
		}
		
		for (int i = 0; i < second.length; i++) {	// Copy the first half of 'in'
			second[i] = in[first.length+i];
		}
		first = mergeSort(first, comparator);	// call the method on the first half
		second = mergeSort(second, comparator);	// call the method on the second half
		
		int iFirst = 0;		// counter for the elements of the first half
		int iSecond = 0;	// counter for the elements of the second half
		int j = 0;			// counter for the original array
		// Iterative statement to determine which element should be chosen
		while (iFirst < first.length && iSecond < second.length) {
			// In case first's element is smaller than second's element
			if (comparator.compare(first[iFirst], second[iSecond]) < 0) {
			   in[j++] = first[iFirst++];	   
			}
			// In case second's element is smaller than first's element
			else {
				in[j++] = second[iSecond++];
			}
		}
		
		// Only one of the two following iterative statements will be executed
		
		// Append the rest of first array's elements
		while (iFirst < first.length) {
			in[j++] = first[iFirst++];
		}
		   
		// Append the rest of second array's elements
		while (iSecond < second.length) {
			in[j++] = second[iSecond++];
		}
		count++;
		after = System.nanoTime();
		if (after-before <= 1000000000) {
			countStr += count;
			count = 0;
		}
		return in;
	}

	public static int[] createIntArray() {	// method to create an int-array
		int[] in = new int[5000000];
		Random rand = new Random();		// Create new Random object
		for (int i = 0; i < in.length; i++) {
			in[i] = rand.nextInt(10000);
		}
		return in;
	}
	
	public static String[] createStringArray() {	// method to create an int-array
		String[] in = new String[3000000];
		Random rand = new Random();		// Create new Random object
		int random = 0;
		for (int i = 0; i < in.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				random = rand.nextInt(26)+65;		// Random integer for int-array
				sb.append((char) random);
			}
			in[i] = sb.toString();
		}
		return in;
	}
}
