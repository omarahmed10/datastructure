package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * 
 * @author Ali-Metawea
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

	@Override
	public final void add(final int index, final Object element) {
		if (index < 0 || index > size) {
			throw new RuntimeException();
		}
		if (index == 0) {
			DoublyNode n = new DoublyNode(element);
			if (size == 0) {
				header.setNext(n);
				lastNode = n;
				n.setPrev(header);
				size++;
			} else {
				n.setNext(header.getNext());
				n.setPrev(header);
				header.setNext(n);
				n.getNext().setPrev(n);
				size++;

			}
		} else if (index == size) {
			add(element);
		} else {
			DoublyNode n = new DoublyNode(element);
			DoublyNode x = header.getNext();
			for (int i = 0; i < index; i++) {
				x = x.getNext();
			}

			n.setNext(x);
			n.setPrev(x.getPrev());
			x.getPrev().setNext(n);
			x.setPrev(n);
			size++;

		}

	}

	@Override
	public final void add(final Object element) {
		DoublyNode n = new DoublyNode(element);
		if (size == 0) {
			header.setNext(n);
			lastNode = n;
			n.setPrev(header);
			size++;
		} else {
			lastNode.setNext(n);
			n.setPrev(lastNode);
			lastNode = n;
			size++;
		}
	}

	@Override
	public final Object get(final int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException();
		} else {
			DoublyNode n = header.getNext();
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
			DoublyNode n = header.getNext();
			for (int i = 0; i < index; i++) {
				n = n.getNext();
			}

			n.setElement(element);

		}
	}

	@Override
	public final void clear() {
		header = new DoublyNode(null);
		lastNode = header;
		size = 0;
	}

	@Override
	public final boolean isEmpty() {
		return size == 0;
	}

	@Override
	public final void remove(final int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException();
		}
		if (index == size - 1) {
			if (size == 1) {
				header.setNext(null);
				lastNode = header;
				size--;
			} else {
				lastNode = lastNode.getPrev();
				lastNode.setNext(null);
				size--;
			}
		} else if (index == 0) {
			header.getNext().getNext().setPrev(header);
			header.setNext(header.getNext().getNext());
			size--;
		} else {
			DoublyNode n = header.getNext();
			for (int i = 0; i < index; i++) {
				n = n.getNext();
			}
			n.getNext().setPrev(n.getPrev());
			n.getPrev().setNext(n.getNext());
			size--;
		}

	}

	@Override
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
			DoublyNode n = header.getNext();
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
		DoublyNode n = header.getNext();
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
	 * @author Ali-Metawea
	 * @return temp
	 */
	public final String toString() {
		DoublyNode n = header.getNext();
		String temp = "";
		while (n != null) {
			temp = temp + n.getElement() + " ";
			n = n.getNext();
		}
		return temp;
	}

}