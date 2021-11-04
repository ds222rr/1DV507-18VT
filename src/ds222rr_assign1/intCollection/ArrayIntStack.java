package ds222rr_assign1.intCollection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	
	/* Add integer at top of stack. */
	public void push(int n) {
		if (values.length == size) {
			resize();
		}
		values[size++] = n;
	}
	
	/* Returns and removes integer at top of stack  */
	public int pop() throws IndexOutOfBoundsException {
		int temp = values[size-1];
		values[size--] = 0;
		return temp;
	}
	
	/* Returns without removing integer at top of stack */
	public int peek() throws IndexOutOfBoundsException {
		return values[size-1];
	}
}
