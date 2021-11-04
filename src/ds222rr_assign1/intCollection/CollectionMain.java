package ds222rr_assign1.intCollection;

import java.util.Iterator;	// Get Iterator from the Java Library

public class CollectionMain {
	public static void main(String[] args) {
		ArrayIntList arrList = new ArrayIntList();							// Create new ArrayIntList object
		
		if (arrList.isEmpty()) {System.out.println("List is empty");}		// ==> List is empty
		else {System.out.println("List is not empty");}
			
		arrList.add(13);
		arrList.add(4);
		arrList.add(56);
		arrList.add(34);
		arrList.add(62);
		arrList.add(11);
		arrList.add(4);
		
		System.out.println("List contains: "+arrList.size()+" elements");	// ==> List contains: 7 elements
		System.out.println(arrList.toString());								// ==> [ 13 4 56 34 62 11 4 ]
		
		arrList.addAt(45, 4);
		System.out.println(arrList.toString());								// ==> [ 13 4 56 34 45 62 11 4 ]
		
		System.out.println("List contains: "+arrList.size()+" elements");	// ==> List contains: 8 elements
		
		arrList.remove(3);
		System.out.println(arrList.toString());								// ==> [ 13 4 56 45 62 11 4 ]
		
		System.out.println(arrList.get(6));									// ==> 4
		System.out.println(arrList.indexOf(45));							// ==> 3
		System.out.println(arrList.indexOf(99));							// ==> -1
		System.out.println("List contains: "+arrList.size()+" elements");	// ==> List contains: 7 elements
	
		
		ArrayIntStack arrStack = new ArrayIntStack();						// Create new ArrayIntStack object
	
		if (arrStack.isEmpty()) {System.out.println("Stack is empty");}		// ==> Stack is empty
		else {System.out.println("Stack is not empty");}
		
		System.out.println("Stack contains: "+arrStack.size()+" elements");	// ==> Stack contains: 0 elements
		
		arrStack.push(26);
		arrStack.push(5);
		arrStack.push(67);
		arrStack.push(343);
		arrStack.push(32);
		arrStack.push(1);
		arrStack.push(8);
		
		System.out.println("Stack contains: "+arrStack.size()+" elements");	// ==> Stack contains: 7 elements
		System.out.println(arrStack.toString());							// ==> [ 26 5 67 343 32 1 8 ]
		
		System.out.println("Peeking element: "+arrStack.peek());			// ==> Peeking element: 8
		System.out.println("Stack contains: "+arrStack.size()+" elements");	// ==> Stack contains: 7 elements
		
		System.out.println("Popping element: "+arrStack.pop());				// ==> Popping element: 8
		System.out.println("Stack contains: "+arrStack.size()+" elements");	// ==> Stack contains: 6 elements
		System.out.println("Popping element: "+arrStack.pop());				// ==> Popping element: 1
		System.out.println("Stack contains: "+arrStack.size()+" elements");	// ==> Stack contains: 5 elements
		
		// Check iterator
		System.out.print("Iterator: ");
		Iterator<Integer> it = arrStack.iterator();		// Create new Iterator Object
		// Iterative statement to run through the Stack
		while (it.hasNext()) {
			int n = it.next();	// Declare integer for the next element
			System.out.print(n + " ");										// ==> Iterator: 26 5 67 343 32
		}
		
	}
}
