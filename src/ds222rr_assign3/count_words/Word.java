package ds222rr_assign3.count_words;

public class Word implements Comparable<Word> {
	private String word;
	   
	public Word(String str) {	// Constructor
		word = str.toLowerCase();
	}
	public String toString() {	// Word to String
		return word;
	}
	   
	/* Override Object methods */
	public int hashCode() {
		int hash = 0;
		// Iterative statement to create hashcode for word object
		for (int i = 0; i < word.length(); i++) {
			hash += Math.pow((int) Character.toLowerCase(word.charAt(i)), 3) * (word.length()-i);
		}
		return hash;
	}
	   
	public boolean equals(Object other) {	// Verify equality of two Word objects
		if (other instanceof Word) {
			return hashCode() == other.hashCode();
		}
		return false;
	}
	   
	/* Implement Comparable */
	public int compareTo(Word w) {	// Compare two Word objects
		int length = 0;
		// The shorter word determines the duration of the following for-loop
		if (word.length() < w.word.length()) {
			length = word.length();
		}
		else {
			length = w.word.length();
		}
		// Iterative statement to compare two word character-by-character
		for (int i = 0; i < length; i++) {
			int fChar = (int) Character.toLowerCase(word.charAt(i));	// Get ASCII-value
			int sChar = (int) Character.toLowerCase(w.word.charAt(i));	// Get ASCII-value
			// Case: first character is smaller than second character (or both are equal and for-loop ends)
			if (fChar < sChar || fChar == sChar && i == length-1 && word.length() < w.word.length()) {
				return -1;
			}
			// Case: second character is smaller than first character (or both are equal and for-loop ends)
			else if (fChar > sChar || fChar == sChar && i == length-1 && word.length() > w.word.length()) {
				return 1;
			}
		}
		return 0;
	}
}