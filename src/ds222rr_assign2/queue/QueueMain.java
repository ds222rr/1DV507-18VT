package ds222rr_assign2.queue;

import java.util.Iterator;	// Get Iterator from Java Library

public class QueueMain {
	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();		// Create new LinkedQueue object
		if (queue.isEmpty()) {
			System.out.println("Queue is empty");	// --> Queue is empty
		}
		else {
			System.out.println("Queue is not empty");
		}
		// Enqueuing 5 elements
		queue.enqueue(43);	queue.enqueue(12);	queue.enqueue(67);	
		queue.enqueue(23);	queue.enqueue(56);
		
		System.out.println("Queue: "+queue.toString()+
		" Head: "+queue.first()+" Tail: "+queue.last());	// [ 43 12 67 23 56 ] Head: 43 Tail: 56
		
		System.out.println("Dequeuing: "+queue.dequeue());	// Dequeuing 43
		System.out.println("Dequeuing: "+queue.dequeue());	// Dequeuing 12
		
		System.out.println("Queue: "+queue.toString()+
		" Head: "+queue.first()+" Tail: "+queue.last());	// Queue: [ 67 23 56 ] Head: 67 Tail: 56
		
		queue.enqueue(89);
		
		System.out.println("Queue: "+queue.toString()+
		" Head: "+queue.first()+" Tail: "+queue.last());	// [ 67 23 56 89 ] Head: 67 Tail: 89
		
		queue.enqueue(123);
		queue.enqueue(2);
		
		System.out.println("Queue: "+queue.toString()+
		" Head: "+queue.first()+" Tail: "+queue.last());	// [ 67 23 56 89 123 2 ] Head: 67 Tail: 2
		
		System.out.println("Dequeuing: "+queue.dequeue());	// Dequeuing 67
		System.out.println("Dequeuing: "+queue.dequeue());	// Dequeuing 23
		
		System.out.println("Queue: "+queue.toString()+
		" Head: "+queue.first()+" Tail: "+queue.last());	// [ 56 89 123 2 ] Head: 56 Tail: 2
		
		System.out.println("Dequeuing: "+queue.dequeue());	// Dequeuing 56
		
		// Check Iterator
		Iterator<Object> it = queue.iterator();
		System.out.print("Node iterator: ");				// 89 123 2
		while (it.hasNext()) {
			Object n = it.next();
			System.out.print(n+ " ");
		}
	}
}
