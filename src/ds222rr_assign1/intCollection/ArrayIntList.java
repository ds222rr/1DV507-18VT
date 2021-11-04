package ds222rr_assign1.intCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList {
	
	/* Add integer n to the end of the list. */
	public void add(int n) {
		if (values.length == size) {
			resize();
		}
		values[size++] = n;
	}
	
	/* Inserts integer n at position index. Shifts the element currently at that 
	 * position (if any) and any subsequent elements to the right.  */
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if (values.length == size) {
			resize();
		}
		if (index > size || index < 0) {
			throw new IllegalStateException("Exception: illegal operation on IntList!");
		}
		
		for (int i = 0; i < size-index; i++) {
			values[size-i] = values[size-i-1];
		}
		values[index] = n;
		size++;
	}
	
	/* Remove integer at position index. */
	public void remove(int index) throws IndexOutOfBoundsException {
		for (int i = index; i < size; i++) {
			if (i < size-1) {
				values[i] = values[i+1];
			}
		}
		size--;
	}
	
	/* Get integer at position index. */
	public int get(int index) throws IndexOutOfBoundsException {
		return values[index];
	}
	
	/* Find position of integer n, otherwise return -1 */
	public int indexOf(int n) {
		for (int i = 0; i < size; i++) {
			if (values[i] == n) {
				return i;
			}
		}
		return -1;
	}
}
