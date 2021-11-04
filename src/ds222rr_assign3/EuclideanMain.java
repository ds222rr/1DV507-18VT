package ds222rr_assign3;

import java.util.Scanner;	// Get Scanner from Java Library

public class EuclideanMain {
	
	private static int counter = 0;
	// Create new Scanner object connected to the keyboard
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("Euclidan algorithm");
		int intOne = checkInt();	// integer 1
		int intTwo = checkInt();	// integer 2
		System.out.println("Result: "+euclidianAlgorithm(intOne, intTwo));
		scan.close();	// Close Scanner
	}
	
	// Euclidean algorithm
	public static int euclidianAlgorithm(int one, int two) {
		if (one == 0) {	// return two if one is 0
			return two;
		}
		else if (two == 0) {	// return one if two is 0
			return one;
		}
		else {
			while (two != 0) {
				if (one > two) {
					one -= two;
				}
				else {
					two -= one;
				}
			}
		}
		int result = one;
		return result;		// return result
	}
	
	public static int checkInt() {	// Input verification
		boolean flag = false;		// False for invalid input
		int integ = 0;
		do {
			System.out.print("Enter "+(++counter)+". positive integer: ");
			if (scan.hasNextInt()) {	// In case input is an integer
				integ = scan.nextInt();
				flag = true;
				if (integ < 0) {	// In case integer < 0
					counter--;
					System.out.println("Input is not a positive integer!");
					flag = false;
				}
			}
			else {	// In case input is not an integer
				System.out.println("Invalid input!");
				counter--;
				scan.next();
			}
		} while (flag == false);
		return integ;
	}
}
