package ds222rr_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeWordSet implements WordSet {

	private TWS root = null;	// Root of the TreeSet
	private int size = 0;		// Size of the Set
	private TWS temp;			// Temporarily root for 'add' and 'contains' methods
	
	@Override
	public Iterator<Word> iterator() {	// Iterator
		return new TWSIterator();
	}

	@Override
	public void add(Word word) {	// Add new Word object to TreeSet
		if (root == null) {				// In case TreeSet is empty
			root = new TWS(word);
			size++;
		}
		else {	// In case TreeSet is not empty
			temp = root;
			root.add(word);
		}
	}

	@Override
	// Verify whether TreeSet contains a specific Word object
	public boolean contains(Word word) {
		if (root == null) {		// In case TreeSet is empty
			return false;
		}
		else {	// In case TreeSet is not empty
			temp = root;
			return root.contains(word);
		}

	}

	@Override
	public int size() {		// Return size of TreeSet
		return size;
	}
	
	private class TWS {		// Private inner class TWS
		private Word word;
		private TWS leftChild = null;	// LeftChild of TWS object
		private TWS rightChild = null;	// RightChild of TWS object
		private TWS parent = null;		// Parent of TWS object
		private boolean flag = false;	// Flag to mark an traversed TWS object (Iteration)
		
		TWS(Word w) {	// Constructor
			word = w;
		}
		
		void add(Word w) {
			// In case 'w' is smaller than 'word'
			if(w.compareTo(temp.word) == -1) {
				// Create new TWS object if leftChild is unoccupied
				if (leftChild == null) {
					leftChild = new TWS(w);
					size++;
					leftChild.parent = temp;
				}
				else {	// Search in a deeper level of the TreeSet
					temp = temp.leftChild;
					temp.add(w);
				}
			}
			// In case 'w' is larger than 'word'
			else if (w.compareTo(temp.word) == 1) {
				// Create new TWS object if rightChild is unoccupied
				if (rightChild == null) {
					rightChild = new TWS(w);
					size++;
					rightChild.parent = temp;
				}
				else {	// Search in a deeper level of the TreeSet
					temp = temp.rightChild;
					temp.add(w);
				}
			}
		}
		
		boolean contains(Word w) {
			// In case 'w' is smaller than 'word'
			if (w.compareTo(word) == -1) {
				// In case there is no leftChild
				if (leftChild == null) {
					return false;
				}
				else {	// Search in a deeper level of the TreeSet
					temp = temp.leftChild;
					temp.contains(w);
				}
			}
			// In case 'w' is larger than 'word'
			else if (w.compareTo(word) == 1) {
				// In case there is no rightChild
				if (rightChild == null) {
					return false;
				}
				else {	// Search in a deeper level of the TreeSet
					temp = temp.rightChild;
					temp.contains(w);
				}
			}
			return true;	// In case 'w' is found
		}
	}
	// Private inner class for TWSIterator
	private class TWSIterator implements Iterator<Word> {		
		private TWS position = root;	// Current position during iteration
		private int count = 0;			// Counter for traversed elements

		public boolean hasNext() {
			return (count < size);
		}

		public Word next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			boolean word = false;	// Flag to determine whether the while loop can be stopped
			do {
				// Go as far left as possible
				while (position.leftChild != null && position.leftChild.flag == false) {
					position = position.leftChild;
				}
				// Check position for flag
				if (position.flag == false) {
					position.flag = true;	// Mark element as traversed
					word = true;			// Change word to 'true' to stop the iteration
					count++;
				}
				// Check for a right way
				else if (position.rightChild != null && position.rightChild.flag == false) {
					position = position.rightChild;	// One position to the right
					// Go as left as possible
					while (position.leftChild != null && position.leftChild.flag == false) {
						position = position.leftChild;
					}
					// Check position for flag
					if (position.flag == false) {
						position.flag = true;	// Mark element as traversed
						word = true;			// Change word to 'true' to stop the iteration
						count++;
					}
				}
				// Go back upwards
				else {
					while (position.parent != null && position.parent.flag == true) {
						position = position.parent;
					}
					position = position.parent;	// One position upwards to get the next element
				}
			} while (word == false);	
			return position.word;
		}
	}
}