package ds222rr_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet {
	
	private int size = 0;	// Size of the Set
	private Node[] buckets = new Node[4];	// bucket-array for elements
	
	public Iterator<Word> iterator() {	// Iterator
		return new HashWordIterator();
	}

	public void add(Word word) {	// Add new Word object to HashSet
		if (!contains(word)) {		// If 'word' is not already stored in the bucket
			int bucketNr = getBucketNumber(word);
			Node node = new Node(word);		// Create new Node object
			node.next = buckets[bucketNr];	// First node becomes new nodes successor
			buckets[bucketNr] = node;		// New node becomes first node of the bucket
			size++;
			if (size == buckets.length) {	// Rehash if necessary
				rehash();
			}
		}
	}
	
	// Verify whether HashSet contains a specific Word object
	public boolean contains(Word word) {
		int bucketNr = getBucketNumber(word);	// Get determined bucketNumber of 'word'
		Node node = buckets[bucketNr];			// Start with the first node of the bucket
		// Iterative statement to compare the hashCode of two Word objects
		while (node != null) {
			// If hashCode is equal
			if (node.word.hashCode() == word.hashCode()) {
				return true;
			}
			// If hashCode is not found in the bucket
			else {
				node = node.next;
			}
		}
		return false;
	}

	public int size() {		// Return size of HashSet
		return size;
	}
	
	// Return bucketNumber determined by hashCode modulus buckets.length
	private int getBucketNumber(Word w) {	
		int bucketNumber = w.hashCode();
		return bucketNumber % buckets.length;
	}
	
	private void rehash() {		// Rehash method
		Node[] temp = buckets;	// Store nodes in temp
		buckets = new Node[temp.length*2];	// Recreate buckets-array
		size = 0;	// Reset size of HashWordSet
		// Iterative statement to readd all nodes to buckets-array
		for (int i = 0; i < temp.length; i++) {
			Node node = temp[i];
			while (node != null) {
				add(node.word);
				node = node.next;
			}
		}
	}
	// Private inner class for HashWordIterator
	private class HashWordIterator implements Iterator<Word> {
		private int bucketNr = 0;	// Integer for bucketNumber
		private int count = 0;		// Integer to count traversed nodes
		private Node node = buckets[bucketNr];	// Starting point of the iteration
		
		public boolean hasNext() {
			return (count < size);
		}
			
		@Override
		public Word next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// Iterative statement to get the next bucket containing at least one node
			while (buckets.length > bucketNr && node == null) {
				node = buckets[++bucketNr];
			}
			Node ret = node;	// Node to return
			node = node.next;
			count++;
			return ret.word;
		}
	}
	
	// Private inner class node
	private class Node {
		
		private Word word;
		private Node next;
		
		Node(Word w) {
			word = w;
			next = null;
		}
	}
}
