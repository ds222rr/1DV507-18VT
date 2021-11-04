package ds222rr_assign4.time;

public class Time {
	
	private static long before = 0;			// Time before starting
	private static long after = 0;			// Time after finishing				
	private static long count = 0;			// Count Concatenations/Appendices for one period
	private static long countTotal = 0;		// Total number of Concatenations/Appendices after b periods
	private static long length = 0;			// Length of the final String
	private static int b = 10;				// Period-counter
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// Call method for short String
		System.out.println("String short");
		countStr(Character.toString((char) (100)));
		// Call method for long String
		System.out.println("String long");
		countStr("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZAB");
		// Call method for short StringBuilder
		System.out.println("StringBuilder short");
		countSb(Character.toString((char) (100)));	
		// Call method for long StringBuilder
		System.out.println("StringBuilder long");
		countSb("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZAB");	
	}	

	public static void countStr(String str) {	// Method for Strings
		countTotal = 0;		// Reset countTotal before starting new method
		length = 0;			// Reset Length before starting new method
		// Iterative statement for b periods
		for (int i = 0; i < b; i++) {
			String string = "";				// Reset String before starting new cycle
			before = System.nanoTime();		// Starting time
			count = 0;						// Reset count before starting new cycle
			// Repeat as long as expired time < 1000000000
			do {
				string = string + str;
				after = System.nanoTime();	// Ending time
				count++;					// Increase count for one concatenation
			} while ((after-before) < 1000000000);
			length += string.length();		// String-Length of all periods
			countTotal += count;			// Concatenation of all periods
		}
		
		// Print result
		System.out.println("Concatenations: "+countTotal/b);
		System.out.println("String Length: \t"+length/b);
		// Time to concatenate one character
		System.out.println("");
	}
	
	public static void countSb(String str) {	// Method for StringBuilders
		countTotal = 0;
		length = 0;
		// Iterative statement for b periods
		for (int i = 0; i < b; i++) {
			sb = new StringBuilder();		// Reset StringBuilder before starting new cycle
			before = System.nanoTime();		// Starting time
			count = 0;						// Reset count before starting new cycle
			// Repeat as long as expired time < 1000000000
			do {
				sb.append(str);
				after = System.nanoTime();	// Ending time
				count++;					// Increase count for one appendix
			} while ((after-before) < 1000000000);
			length += sb.length();			// String-Length of all periods
			countTotal += count;			// Appendices of all periods
		}
		// Average time to append one character (Time divided by average-length)
		long average = ((after-before)/(length/b));	
		long toStringTime = 0;						// Time to convert sb toString
		
		// Iterative statement to determine the time of the toString-method
		for (int i = 0; i < b; i++) {
			before = System.nanoTime();
			sb.toString();
			after = System.nanoTime();
			toStringTime += (after-before);
		}
		
		toStringTime = toStringTime/b;				// Average toString-time
		countTotal = countTotal/b;					// Average Appendices
		length = length/b;							// Average Length
		// To reduce the number of appendices according to the toString-time
		long subApp = ((((toStringTime)/average))/str.length());
		// To reduce the number of characters according to the toString-time
		long subLen = ((subApp)*str.length());

		
		// Print result
		System.out.println("Appendices: \t"+(countTotal-subApp));
		System.out.println("String Length: \t"+(length-subLen));
		System.out.println("");
	}
}