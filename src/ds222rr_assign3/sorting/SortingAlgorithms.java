package ds222rr_assign3.sorting;

import java.util.Comparator;

public class SortingAlgorithms {
	
		/* ************************************************************************ */
		/* Methods implemented from the book "Big Java - Late Objects" by Horstmann */
		/* ************************************************************************ */
	
	public static String printString(String[] in) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < in.length; i++) {
			sb.append(in[i]);
			if (i < in.length-1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	
	public static int[] insertionSort(int[] in) {
		int[] intArr = new int[in.length];		// Create new array to copy in
		// Iterative statement to copy in to intArr
		for (int i = 0; i < in.length; i++) {
			intArr[i] = in[i];
		}
		// Iterative statement for insertionSort
		for (int i = 0; i < intArr.length; i++) {
			int next = intArr[i];		// next element
			int counter = i;			// counter for position
			while (counter > 0 && intArr[counter-1] > next) {
				intArr[counter] = intArr[counter-1];
				counter--;
			}
			intArr[counter] = next;
		}
		return intArr;
	}
	
	public static String[] insertionSort(String[] in, Comparator<String> comparator) {
		String[] strArr = new String[in.length];	// Create new array to copy in
		// Iterative statement to copy in to strArr
		for (int i = 0; i < in.length; i++) {
			strArr[i] = in[i];
		}
		// Iterative statement for insertionSort
		for (int i = 0; i < strArr.length; i++) {
			String next = strArr[i];	// next element
			int counter = i;			// counter for position
				while (counter > 0 && comparator.compare(strArr[counter-1], next) > 0) {
					strArr[counter] = strArr[counter-1];
					counter--;
				}
				strArr[counter] = next;
		}
		return strArr;
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
		return in;
	}
}