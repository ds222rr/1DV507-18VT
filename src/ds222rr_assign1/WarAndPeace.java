package ds222rr_assign1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class WarAndPeace {
	public static void main(String[] args) throws MalformedURLException, IOException {
		// Create new URL object connected to the link of WarAndPeace.txt
		URL url = new URL("http://homepage.lnu.se/staff/jlnmsi/java2/2018/WarAndPeace.txt");
		
		// Create new Scanner object connected to url to get an input stream
		Scanner scan = new Scanner(url.openStream());	

		StringBuilder sb = new StringBuilder();			// Create new StringBuilder object
		
		while (scan.hasNextLine()) {	// Iterative statement to append all lines of WarAndPeace.txt to sb
			String temp = scan.nextLine();
			sb.append(temp);
			// To avoid merging two words after a line break
			if (!temp.endsWith(" ")) {
				sb.append(" ");
			}
		}
		scan.close();					// Close Scanner
		String text = sb.toString();	// StringBuilder to String

		
		String[] words = text.split(" ");  // Split String into words, stored in array words

		System.out.println("Initial word count: "+words.length);   // 577091
			
		Stream<String> stream = Arrays.stream(words);	// Array to stream
		long uniqueWords = stream			// Declare wordCount by applying the following stream operators
			.map(w -> removeChars(w))		// map the elements to the removeChars method
			.filter(w -> w.length()>0)		// Remove empty words
			.map(w -> w.toLowerCase())		// map the elements to the toLowerCase method
			.distinct()						// Remove all words that occur more than one time
			.count();						// Count remaining elements
		System.out.println("\nUnique word count: "+uniqueWords);	// 23701
	}
	
	// Method to remove characters except the ones in the method's condition
	public static String removeChars(String string) {
		StringBuilder sb = new StringBuilder();			// Create new StringBuilder object
		for (int i = 0; i < string.length(); i++) {		
			char c = string.charAt(i);
			if (Character.isUpperCase(c) || Character.isLowerCase(c) || c == '\''|| c == '-' ) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
