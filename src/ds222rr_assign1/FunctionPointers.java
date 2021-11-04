/**
 * FunctionPointers.java
 * 13 jan 2017
 */
package ds222rr_assign1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author jlnmsi
 *
 */
public class FunctionPointers {

	public static void main(String[] args) {
		System.out.println("Part 1: Apply predicates");
		List<Integer> list = Arrays.asList(45, 3, 24, 16, 1, 1, 3, 8, 7, 6, 10, 12, 17, 22, 30);

		System.out.print("Print all numbers: ");
		Predicate<Integer> all = n -> true;
		selectAndPrint(list, all);

		System.out.print("\nPrint all odd numbers: ");
		Predicate<Integer> odd = n -> n%2==1;
		selectAndPrint(list, odd);

		System.out.print("\nPrint all numbers greater than 10: ");
		Predicate<Integer> aboveTen = n -> n>10;
		selectAndPrint(list, aboveTen);

		System.out.println("\n\nPart 2: Apply functions");
		List<Double> numbers = Arrays.asList(1.0, 16.0, 25.0, 81.0);
		System.out.println("Original: "+numbers);
		System.out.println("Square root: "+applyFunction(numbers, Math::sqrt));
		System.out.println("Power of two: " + applyFunction(numbers, FunctionPointers::powerOfTwo));
	}


	// Prints all elements in the list where predicate evaluates to true
	public static void selectAndPrint(List<Integer> list, Predicate<Integer> predicate) {
		List<Integer> temp = new ArrayList<Integer>();		// Create new List object
		// Iterative statement to copy 'list'
		for (int i = 0; i < list.size(); i++) {
			temp.add(list.get(i));
		}
		Predicate<Integer> neg = predicate.negate();	// Negate predicate
		temp.removeIf(neg);				// Remove elements which do not fulfill the condition of 'predicate'
		System.out.println(temp);
	}

	// Returns a new list containing the numbers resulting from applying fx 
	// on the input list numbers
	private static List<Double> applyFunction(List<Double> numbers, Function<Double, Double> fx) {
			List<Double> temp = new ArrayList<Double>();	// Create new List object
			// Iterative statement to copy 'numbers'
			for (int i = 0; i < numbers.size(); i++) {
				double num = numbers.get(i);
				temp.add(fx.apply(num));
			}
	return temp;
	}
	
	private static Double powerOfTwo(Double d) {	// Return square of d
		return Math.pow(d, 2);
	}
}
