package eg.edu.alexu.csd.datastructure.queue.cs47;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestQueue {

	@Test
	public void test() {
		MyQueue queue = new MyQueue();
		assertEquals(0, queue.size());
		queue.enqueue("omar");
		queue.enqueue("Ahmed");
		queue.enqueue("Ali");
		queue.dequeue();
		queue.dequeue();
		queue.enqueue("Khaled");
		assertEquals("Ali", queue.dequeue());
		assertEquals(1, queue.size());
		queue.dequeue();
		assertEquals(true, queue.isEmpty());
	}

}
