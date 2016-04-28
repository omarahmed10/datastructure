package eg.edu.alexu.csd.datastructure.stack.cs47;

import eg.edu.alexu.csd.datastructure.stack.IStack;

import java.util.LinkedList;

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
		int newIndex = i - index;
		s.add(newIndex, element);
		i++;
	}

	@Override
	public final Object pop() {
		if (i != 0) {
			Object pop = s.get(0);
			s.remove(0);
			i--;
			return pop;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public final Object peek() {
		if (i != 0) {
			Object peek = s.get(0);
			return peek;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public final void push(final Object element) {
		s.add(0, element);
		i++;
	}

	@Override
	public final boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public final int size() {
		return i;
	}
	
	public String toString(){
		return s.toString();
	}
	/**
	 * 
	 * @param args         
	 */
	public static void main(final String[] args) {
		MyStack st = new MyStack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.add(2, 0);
		st.add(0,0);
		st.add(6, '*');
		st.add(3, '*');
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		
	}

}
