package eg.edu.alexu.csd.datastructure.stack.cs47;

import eg.edu.alexu.csd.datastructure.stack.IStack;
import eg.edu.alexu.csd.datastructure.linkedList.cs47.SinglyLinkedList;

/**
 * 
 * @author omar_ahmed
 *
 */
public class MyStack implements IStack {
	/**
	 * 
	 */
	private SinglyLinkedList s = new SinglyLinkedList();
	/**
	 * 
	 */
	private int i = 0;

	@Override
	public final void add(final int index, final Object element) {
		if (index < 0 || index > i) {
			throw new RuntimeException();
		}
		s.add(index, element);
		i++;
	}

	@Override
	public final Object pop() {
		if (i != 0) {
			Object pop = s.get(i - 1);
			s.remove(--i);
			return pop;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public final Object peek() {
		if (i != 0) {
			Object peek = s.get(i - 1);
			return peek;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public final void push(final Object element) {
//		s.add(element);
//		i++;
	}

	@Override
	public final boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public final int size() {
		return i;
	}

	/**
	 * 
	 * @param args         
	 */
	public static void main(final String[] args) {
		MyStack st = new MyStack();
		st.push("omar");
		System.out.println(st.peek());
		st.push(5);
		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st.size());
//		st.add(10, "element");
	}

}
