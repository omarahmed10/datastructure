package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author Omar_Ahmed
 */
public class SinglyLinkedList implements ILinkedList {
	/**
	 */
	private SinglyNode header;
	/**
	 */
	private SinglyNode lastNode;
	/**
	 */
	private int size = 0;

	/**
	 */
	public SinglyLinkedList() {

		header = new SinglyNode(null);
		lastNode = header;
	}

	@Override
	public final void add(final int index, final Object element) {
		if (index < 0 || index > size) {
			throw new RuntimeException();
		}
		if (index == 0) {
			SinglyNode n = new SinglyNode(element);
			if (size == 0) {
				header.setNext(n);
				lastNode = n;
				size++;
			} else {
				n.setNext(header.getNext());
				header.setNext(n);
				size++;
			}
		} else if (index == size) {
			add(element);
		} else {
			SinglyNode n = new SinglyNode(element);
			SinglyNode x = header.getNext();
			for (int i = 0; i < index - 1; i++) {
				x = x.getNext();
			}
			n.setNext(x.getNext());
			x.setNext(n);
			size++;
		}

	}

	@Override
	public final void add(final Object element) {
		SinglyNode n = new SinglyNode(element);
		lastNode.setNext(n);
		lastNode = n;
		size++;
	}

	@Override
	public final Object get(final int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException();
		} else if (index == size - 1) {
			return lastNode.getElement();
		} else {
			SinglyNode n = header.getNext();
			for (int i = 0; i < index; i++) {
				n = n.getNext();
			}

			return n.getElement();
		}
	}

	@Override
	public final void set(final int index, final Object element) {

		if (index < 0 || index > size - 1) {
			throw new RuntimeException();
		} else {
			SinglyNode n = header.getNext();
			for (int i = 0; i < index; i++) {
				n = n.getNext();
			}

			n.setElement(element);
		}
	}

	@Override
	public final void clear() {

		header = new SinglyNode(null);
		lastNode = header;
		size = 0;
	}

	@Override
	public final boolean isEmpty() {
		return size == 0;
	}

	@Override
	public final void remove(final int index) {
		if (index < 0 || index > size - 1 || size == 0) {
			throw new RuntimeException("");
		}
		if (index == size - 1) {

			if (size == 1) {
				header.setNext(null);
				lastNode = header;
				size--;
			} else {
				SinglyNode n = header.getNext();
				for (int i = 0; i < size - 2; i++) {
					n = n.getNext();
				}

				lastNode = n;
				lastNode.setNext(null);
				size--;
			}
		} else if (index == 0) {
			header.setNext(header.getNext().getNext());
			size--;
		} else {

			SinglyNode n = header.getNext();
			for (int i = 0; i < index - 1; i++) {
				n = n.getNext();
			}

			n.setNext(n.getNext().getNext());
			size--;
		}
	}

	@Override
	public final int size() {
		return size;
	}

	@Override
	public final ILinkedList sublist(final int fromIndex, final int toIndex) {
		if (fromIndex >= size || fromIndex < 0 || toIndex < 0 || toIndex >= size
				|| fromIndex > toIndex) {
			throw new RuntimeException("");
		} else {
			ILinkedList subList = new SinglyLinkedList();
			SinglyNode n = header.getNext();
			for (int i = 0; i < size; i++) {
				if (i >= fromIndex && i <= toIndex) {
					subList.add(n.getElement());
				}
				n = n.getNext();
			}
			return subList;
		}
	}

	@Override
	public final boolean contains(final Object o) {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		SinglyNode n = header.getNext();
		if (n.getElement().equals(o)) {
			return true;
		}
		for (int i = 0; i < size; i++) {
			if (n.getElement().equals(o)) {
				return true;
			}

			n = n.getNext();
		}
		return false;
	}

	/**
	 * . print the linked list
	 * 
	 * @return String
	 */
	public final String toString() {
		SinglyNode n = header.getNext();
		String temp = "";
		while (n != null) {
			temp = temp + n.getElement() + " ";
			n = n.getNext();
		}
		return temp;
	}
}