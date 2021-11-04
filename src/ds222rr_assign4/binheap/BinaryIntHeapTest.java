package ds222rr_assign4.binheap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryIntHeapTest {
	
	BinaryIntHeap bih = new BinaryIntHeap();
	static int number;
	
	@BeforeEach
	void count() {
		number++;
		System.out.println("Test number: "+number);
	}
	
	@Test
	void testSizeInsert() {
		assertEquals(0, bih.size());
		bih.insert(23);
		assertEquals(1, bih.size());
	}
	
	@Test
	void testEmpty() {
		if (bih.size() == 0) {
			assertEquals(true, bih.isEmpty());
		}
		if (bih.size() > 0) {
			assertEquals(false, bih.isEmpty());
		}
	}

	@Test
	void testPullHighest() {
		if (bih.isEmpty()) {
			assertThrows(NoSuchElementException.class, () -> bih.pullHighest());
		}
		bih.insert(345);
		bih.insert(1734);
		bih.insert(124);
		assertEquals(1734, bih.pullHighest());
		assertEquals(345, bih.pullHighest());
		assertEquals(124, bih.pullHighest());
	}

	@Test
	void testToString() {
		assertEquals("[ ]", bih.toString());
		bih.insert(345);
		bih.insert(1734);
		bih.insert(124);
		assertEquals("[ 1734 345 124 ]", bih.toString());
	}

}
