package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * 
 * @author Omar_Ahmed
 *
 */
public class SinglyLinkedList implements ILinkedList {
	/**
	 * 
	 */
	private SinglyNode header;
	/**
	 * 
	 */
	private SinglyNode lastNode;
	/**
	 * 
	 */
	private int size = 0;

	/**
	 * 
	 */
	public SinglyLinkedList() {

		header = new SinglyNode(null);
		lastNode = header;

	}

	/**
	 * Inserts a specified element at the specified sposition in the list.
	 * 
	 * @param index
	 *            index of the node
	 * @param element
	 *            data of the node
	 */
	public final void add(final int index, final Object element) {
		if (index < 0 || index > size) {
			throw new RuntimeException();
		}
		if (index == 0) {
			SinglyNode n = new SinglyNode(element);
			if (size == 0) {
				header.next = n;
				lastNode = n;
				size++;
			} else {
				n.next = header.next;
				header.next = n;
				size++;
			}
		} else if (index == size) {
			add(element);
		} else {
			SinglyNode n = new SinglyNode(element);
			SinglyNode x = header.next;
			for (int i = 0; i < index - 1; i++) {
				x = x.next;
			}
			n.next = x.next;
			x.next = n;
			size++;
		}

	}

	/**
	 * Inserts the specified element at the end of the list.
	 * 
	 * @param element
	 *            data of the node
	 */
	public final void add(final Object element) {
		SinglyNode n = new SinglyNode(element);
		if (size == 0) {
			header.next = n;
			lastNode = n;
			size++;
		} else {
			lastNode.next = n;
			lastNode = n;
			size++;
		}

	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 *            index of the node
	 * @return the data at the index
	 */
	public final Object get(final int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException();
		} else {
			SinglyNode n = header.next;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}

			return n.element;
		}
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 *            index of the node
	 * @param element
	 *            data of the node
	 */
	public final void set(final int index, final Object element) {

		if (index < 0 || index > size - 1) {
			throw new RuntimeException();
		} else {
			SinglyNode n = header.next;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}

			n.element = element;

		}

	}

	/**
	 * Removes all of the elements from this list.
	 */
	public final void clear() {

		header = new SinglyNode(null);
		lastNode = header;
		size = 0;

	}

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true or false
	 */
	public final boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 *            index of the node
	 */
	public final void remove(final int index) {
		if (index < 0 || index > size - 1 || size == 0) {
			throw new RuntimeException("");
		}
		if (index == size - 1) {

			if (size == 1) {
				header.next = null;
				lastNode = header;
				size--;
			} else {
				SinglyNode n = header.next;
				for (int i = 0; i < size - 2; i++) {
					n = n.next;
				}

				lastNode = n;
				lastNode.next = null;
				size--;
			}
		} else if (index == 0) {
			header.next = header.next.next;
			size--;
		} else {

			SinglyNode n = header.next;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}

			n.next = n.next.next;
			size--;
		}

	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return The size of linkedlist
	 */
	public final int size() {
		return size;
	}

	/**
	 * Returns a view of the portion of this list between the specified
	 * fromIndex and toIndex, inclusively.
	 * 
	 * @param fromIndex
	 *            index of the node1
	 * @param toIndex
	 *            data of the last node
	 * @return linkedlist from 1 to last
	 */
	public final ILinkedList sublist(final int fromIndex, final int toIndex) {
		if (fromIndex >= size || fromIndex < 0 || toIndex < 0 || toIndex >= size || fromIndex > toIndex) {
			throw new RuntimeException("");
		} else {
			ILinkedList subList = new SinglyLinkedList();
			SinglyNode n = header.next;
			for (int i = 0; i < size; i++) {
				if (i >= fromIndex && i <= toIndex) {
					subList.add(n.element);
				}
				n = n.next;
			}
			return subList;
		}
	}

	/**
	 * Returns true if this list contains an element with the same value as the
	 * specified element.
	 * 
	 * @param o
	 *            data
	 * @return true or false
	 */
	public final boolean contains(final Object o) {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		SinglyNode n = header.next;
		if (n.element.equals(o)) {
			return true;
		}
		for (int i = 0; i < size; i++) {
			if (n.element.equals(o)) {
				return true;
			}

			n = n.next;
		}
		return false;
	}

	/**
	 * . print the linkedlist
	 * 
	 * @return String
	 */
	public final String toString() {
		SinglyNode n = header.next;
		String temp = "";
		while (n != null) {
			temp = temp + n.element + " ";
			n = n.next;
		}
		return temp;
	}

}