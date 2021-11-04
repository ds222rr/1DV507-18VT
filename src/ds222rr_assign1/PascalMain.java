package ds222rr_assign1;

public class PascalMain {
	public static void main(String[] args) {
		int rows = 30;							// Row to print
		int [] arr = pascalRow(rows);			// Call of the recursive method
		System.out.println(ArrToString(arr));	// Print the row
	}	

	public static int[] pascalRow(int n) {		// Recursive method
		if (n == 1) {								// Base case 1: first row
			int [] pascal = {1};
			return pascal;
		}
		else if (n == 2) {							// Base case 2: second row
			int [] pascal = {1,1};
			return pascal;
		}
		else {										// In case of third row or higher
			int [] pascal = new int[n];
			int [] previous = pascalRow(n-1);		// Determine previous row by recursion
			pascal[0] = 1;							// First element of array = 1
			pascal[n-1] = 1;						// Last element of array = 1
			for (int i = 1; i < n-1; i++) {
				pascal[i] = previous[i-1] + previous[i];
			}
			return pascal;
		}
	}	
	
	public static String ArrToString(int [] array) {	// Method to print the row
		StringBuilder sb = new StringBuilder();			// Create new StringBuilder object
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			sb.append(" ");
		}
		return sb.toString();
	}
}