package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * 
 * @author Omar_Ahmed
 *
 */
public class DoublyLinkedList implements ILinkedList {
	/**
	 * 
	 */
	private DoublyNode header;
	/**
	 * 
	 */
	private DoublyNode lastNode;
	/**
	 * 
	 */
	private int size = 0;

	/**
	 * 
	 */
	public DoublyLinkedList() {
		header = new DoublyNode(null);
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
			DoublyNode n = new DoublyNode(element);
			if (size == 0) {
				header.next = n;
				lastNode = n;
				n.prev = header;
				size++;
			} else {
				n.next = header.next;
				n.prev = header;
				header.next = n;
				n.next.prev = n;
				size++;

			}
		} else if (index == size) {
			add(element);
		} else {
			DoublyNode n = new DoublyNode(element);
			DoublyNode x = header.next;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}

			n.next = x;
			n.prev = x.prev;
			x.prev.next = n;
			x.prev = n;
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
		DoublyNode n = new DoublyNode(element);
		if (size == 0) {
			header.next = n;
			lastNode = n;
			n.prev = header;
			size++;
		} else {
			lastNode.next = n;
			n.prev = lastNode;
			lastNode = n;
			size++;
		}
	}

	@Override
	public final Object get(final int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException();
		} else {
			DoublyNode n = header.next;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}

			return n.element;
		}
	}

	@Override
	public final void set(final int index, final Object element) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException();
		} else {
			DoublyNode n = header.next;
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
		header = new DoublyNode(null);
		lastNode = header;
		size = 0;
	}

	/**
	 * @return true
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
		if (index < 0 || index > size - 1) {
			throw new RuntimeException();
		}
		if (index == size - 1) {
			if (size == 1) {
				header.next = null;
				lastNode = header;
				size--;
			} else {
				lastNode = lastNode.prev;
				lastNode.next = null;
				size--;
			}
		} else if (index == 0) {
			header.next.next.prev = header;
			header.next = header.next.next;
			size--;
		} else {
			DoublyNode n = header.next;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}
			n.next.prev = n.prev;
			n.prev.next = n.next;
			size--;
		}

	}

	/**
	 * @return Size
	 */
	public final int size() {
		return size;
	}

	@Override
	public final ILinkedList sublist(final int fromIndex, final int toIndex) {
		if (fromIndex >= size || fromIndex < 0 || fromIndex > toIndex) {
			throw new RuntimeException("");
		} else if (toIndex < 0 || toIndex >= size) {
			throw new RuntimeException();
		} else {
			ILinkedList subList = new DoublyLinkedList();
			DoublyNode n = header.next;
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
		DoublyNode n = header.next;
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
	 * @return temp
	 */
	public final String toString() {
		DoublyNode n = header.next;
		String temp = "";
		while (n != null) {
			temp = temp + n.element + " ";
			n = n.next;
		}
		return temp;
	}

}