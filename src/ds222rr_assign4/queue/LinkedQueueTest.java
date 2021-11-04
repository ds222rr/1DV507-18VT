package ds222rr_assign4.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedQueueTest {

	static int number;
	LinkedQueue<Integer> queueInteger = new LinkedQueue<Integer>();
	LinkedQueue<String> queueString = new LinkedQueue<String>();
	
	@BeforeEach
	void count() {
		number++;
		System.out.println("Test number: "+number);

	}
	@Test
	void testEnqueueSize() {	
		assertEquals(0, queueInteger.size());
		assertEquals(0, queueString.size());
		queueInteger.enqueue(5);
		queueString.enqueue("Start");
		assertEquals(1, queueInteger.size());
		assertEquals(1, queueString.size());
		
	}
	
	@Test
	void testEmpty() {
		if (queueInteger.size() == 0 && queueString.size() == 0) {
			assertEquals(true, queueInteger.isEmpty());
			assertEquals(true, queueString.isEmpty());
		}
		if (queueInteger.size() > 0 && queueString.size() > 0) {
			assertEquals(false, queueInteger.isEmpty());
			assertEquals(false, queueString.isEmpty());
		}
	}
	
	@Test
	void testDequeue() {
		queueInteger.enqueue(5);
		queueString.enqueue("Last");
		queueInteger.dequeue();
		queueString.dequeue();
		assertThrows(NoSuchElementException.class, () -> queueInteger.dequeue());
		assertThrows(NoSuchElementException.class, () -> queueString.dequeue());
	}
	
	@Test
	void testIterator() {
		queueInteger.enqueue(5);
		Iterator<Integer> itInteger = queueInteger.iterator();		
		if (itInteger.hasNext()) {
			assertEquals(5, itInteger.next().intValue());
		}
		if (!itInteger.hasNext()) {
			assertThrows(NoSuchElementException.class, () -> itInteger.next());
		}
		
		queueString.enqueue("Top");
		Iterator<String> itString = queueString.iterator();		
		if (itString.hasNext()) {
			assertEquals("Top", itString.next());
		}
		if (!itString.hasNext()) {
			assertThrows(NoSuchElementException.class, () -> itString.next());
		}
		

	}
	
	@Test
	void testFirstLast() {
		if (queueInteger.size() == 0) {
			assertThrows(NoSuchElementException.class, () -> queueInteger.first());
			assertThrows(NoSuchElementException.class, () -> queueInteger.last());
		}
		queueInteger.enqueue(2);
		queueInteger.enqueue(4);
		queueInteger.enqueue(6);
		assertEquals(queueInteger.first().intValue(), 2);
		assertEquals(queueInteger.last().intValue(), 6);
		
		if (queueString.size() == 0) {
			assertThrows(NoSuchElementException.class, () -> queueString.first());
			assertThrows(NoSuchElementException.class, () -> queueString.last());
		}
		queueString.enqueue("End");
		queueString.enqueue("Line");
		queueString.enqueue("House");
		assertEquals(queueString.first(), "End");
		assertEquals(queueString.last(), "House");
	}
	
	@Test
	void testToString() {
		if (queueInteger.size() == 0) {
			assertEquals(queueInteger.toString(), "[ ]");
		}
		queueInteger.enqueue(5);
		queueInteger.enqueue(8);
		queueInteger.enqueue(11);
		assertEquals(queueInteger.toString(), "[ 5 8 11 ]");
		
		if (queueString.size() == 0) {
			assertEquals(queueString.toString(), "[ ]");
		}
		queueString.enqueue("Ale");
		queueString.enqueue("Beer");
		queueString.enqueue("Mead");
		assertEquals(queueString.toString(), "[ Ale Beer Mead ]");
	}
}

