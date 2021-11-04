package ds222rr_assign2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ds222rr_assign2.queue.LinkedQueue;

class LinkedQueueTest {

	static int number;
	
	@BeforeEach
	void count() {
		number++;
		System.out.println("Test number: "+number);
		
			/* **************************************************************** */
			/* Comment-out the object in every test which should not be tested! */
			/* **************************************************************** */

	}
	@Test
	void testConstructEnqueueSize() {
		LinkedQueue queue = new LinkedQueue();
		// ArrayQueue queue = new ArrayQueue();
		
		assertEquals(0, queue.size());
		queue.enqueue(5);
		assertEquals(1, queue.size());
	}
	
	@Test
	void testEmpty() {
		LinkedQueue queue = new LinkedQueue();
		// ArrayQueue queue = new ArrayQueue();
		
		assertEquals(true, queue.isEmpty());
		queue.enqueue(5);
		assertEquals(false, queue.isEmpty());
	}
	
	@Test
	void testDequeue() {
		LinkedQueue queue = buildLinked(1);
		// ArrayQueue queue = buildArray(1);
		
		assertEquals(1, queue.size());
		queue.dequeue();
		assertEquals(0, queue.size());
		assertThrows(RuntimeException.class, () -> queue.dequeue());
	}
	
	@Test
	void testIterator() {
		LinkedQueue queue = buildLinked(3);
		// ArrayQueue queue = buildArray(3);

		Iterator<Object> it = queue.iterator();
		int j = 0;
		while (it.hasNext()) {
			assertEquals(j++, it.next());
		}
		for (int i = 0; i < 3; i++) {
			queue.dequeue();
		}
		assertThrows(NoSuchElementException.class, () -> it.next());

	}
	
	@Test
	void testFirstLast() {
		LinkedQueue queue = buildLinked(3);
		// ArrayQueue queue = buildArray(3);
		assertEquals(queue.first(), 0);
		assertEquals(queue.last(), 2);
		for (int i = 0; i < 3; i++) {
			queue.dequeue();
		}
		assertThrows(RuntimeException.class, () -> queue.first());
		assertThrows(RuntimeException.class, () -> queue.last());
	}
	
	@Test
	void testToString() {
		LinkedQueue queue = buildLinked(3);
		// ArrayQueue queue = buildArray(3);
		
		assertEquals(queue.toString(), "[ 0 1 2 ]");
		queue.enqueue(3);
		queue.enqueue(4);
		queue.dequeue();
		queue.enqueue(5);
		assertEquals(queue.toString(), "[ 1 2 3 4 5 ]");
	}
	
	// Private help method to build an ArrayQueue object
	private ArrayQueue buildArray(int n) {
		ArrayQueue que = new ArrayQueue();
		for (int i = 0; i < n; i++) {
			que.enqueue(i);
		}
		return que;
	}
	// Private help method to build a LinkedQueue object
	private LinkedQueue buildLinked(int n) {
		LinkedQueue que = new LinkedQueue();
		for (int i = 0; i < n; i++) {
			que.enqueue(i);
		}
		return que;
	}
}