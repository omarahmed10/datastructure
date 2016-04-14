package eg.edu.alexu.csd.datastructure.linkedList.cs47.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs47.SinglyLinkedList;

/**
 * 
 * @author Omar_Ahmed
 *
 */
public class TestPloynomial {
	/**
	 *  
	 */
	private final int a = 1, b = 2, c = 3, d = 4;
	/**
	 * 
	 */
	private final int e = 5, f = 6, g = 7, h = 8, i = 9;

	/**
	 * 
	 */
	@org.junit.Test
	public final void test() {
		SinglyLinkedList x = new SinglyLinkedList();
		x.add(a);
		x.add(b);
		x.add(c);
		x.add(d);
		x.add(e);
		x.add(f);

		assertEquals(a, x.get(0));
		assertEquals(b, x.get(a));
		assertEquals(c, x.get(b));
		assertEquals(d, x.get(c));
		assertEquals(e, x.get(d));
		assertEquals(f, x.get(e));

		x.add(c, g);

		assertEquals(g, x.get(c));

		x.set(0, h);

		assertEquals(h, x.get(0));

		ILinkedList y = new SinglyLinkedList();
		y = x.sublist(0, c);

		assertEquals(d, y.size());

		x.remove(c);

		assertEquals(f, x.size());
		assertEquals(d, x.get(c));

		assertTrue(x.contains(e));

		assertFalse(x.contains(i));

		x.clear();

		assertTrue(x.isEmpty());

	}

}
