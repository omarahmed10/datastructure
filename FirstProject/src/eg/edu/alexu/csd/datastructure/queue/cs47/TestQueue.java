package eg.edu.alexu.csd.datastructure.queue.cs47;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// TODO: Auto-generated Javadoc
/**
 * The Class TestQueue.
 */
public class TestQueue {

	/**
	 * . test_1
	 */

	@Test
	public final void test1() {
		MyQueue queue = new MyQueue();
		// long start = System.currentTimeMillis();
		// for(int i = 0;i < 10000000 ;i++){
		// queue.enqueue("omar");
		// }
		// long first = System.currentTimeMillis();
		// for(int i = 0; i < 10000000 ;i++){
		// queue.dequeue();
		// }
		// long second = System.currentTimeMillis();
		// System.out.println(first-start);
		// System.out.println(second-first);
		// System.out.println(second-start);
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

	/**
	 * . Test_2
	 */
	@Test
	public final void test2() {
		MyArrayQueue aQueue = new MyArrayQueue(10000005);
		// long start = System.currentTimeMillis();
		// for(int i = 0;i < 10000000 ;i++){
		// aQueue.enqueue("omar");
		// }
		// long first = System.currentTimeMillis();
		// for(int i = 0; i < 10000000 ;i++){
		// aQueue.dequeue();
		// }
		// long second = System.currentTimeMillis();
		// System.out.println(first-start);
		// System.out.println(second-first);
		// System.out.println(second-start);
		aQueue.enqueue("omar0");
		aQueue.enqueue("omar1");
		aQueue.enqueue("omar2");
		aQueue.enqueue("omar3");
		aQueue.enqueue("omar4");
		aQueue.dequeue();
		aQueue.dequeue();
		aQueue.dequeue();
		aQueue.dequeue();
		aQueue.enqueue("Ahmed0");
		aQueue.enqueue("Ahmed1");
		aQueue.enqueue("Ahmed2");
		aQueue.enqueue("Ahmed3");
		assertEquals("omar4", aQueue.dequeue());
		assertEquals("Ahmed0", aQueue.dequeue());
		assertEquals("Ahmed1", aQueue.dequeue());
		assertEquals("Ahmed2", aQueue.dequeue());
		assertEquals("Ahmed3", aQueue.dequeue());
		// aQueue.enqueue("Ahmed5");
		assertEquals(true, aQueue.isEmpty());
		// aQueue.dequeue();
	}

}
