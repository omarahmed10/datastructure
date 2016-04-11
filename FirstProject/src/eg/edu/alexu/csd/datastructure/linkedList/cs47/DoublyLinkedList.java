package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DoublyLinkedList implements ILinkedList {

	private DoublyNode header;
	private DoublyNode lastNode;
	private int Size = 0;

	public DoublyLinkedList() {
		header = new DoublyNode(null);
		lastNode = header;
	}

	@Override
	public void add(int index, Object element) {
		if (index < 0 || index > Size) {
			throw new RuntimeException();
		}
		if (index == 0) {
			DoublyNode n = new DoublyNode(element);
			if (Size == 0) {
				header.next = n;
				lastNode = n;
				n.prev = header;
				Size++;
			} else {
				n.next = header.next;
				n.prev = header;
				header.next = n;
				n.next.prev = n;
				Size++;

			}
		} else if (index == Size) {
			add(element);
		} else {
			DoublyNode n = new DoublyNode(element);
			DoublyNode x = header.next;
			for (int i = 0; i < index; i++)
				x = x.next;

			n.next = x;
			n.prev = x.prev;
			x.prev.next = n;
			x.prev = n;
			Size++;

		}

	}

	@Override
	public void add(Object element) {
		DoublyNode n = new DoublyNode(element);
		if (Size == 0) {
			header.next = n;
			lastNode = n;
			n.prev = header;
			Size++;
		} else {
			lastNode.next = n;
			n.prev = lastNode;
			lastNode = n;
			Size++;
		}
	}

	@Override
	public Object get(int index) {
		if (index < 0 || index > Size - 1)
			throw new RuntimeException();
		else {
			DoublyNode n = header.next;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}

			return n.element;
		}
	}

	@Override
	public void set(int index, Object element) {
		if (index < 0 || index > Size - 1)
			throw new RuntimeException();
		else {
			DoublyNode n = header.next;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}

			n.element = element;

		}
	}

	@Override
	public void clear() {
		header = new DoublyNode(null);
		lastNode = header;
		Size = 0;
	}

	@Override
	public boolean isEmpty() {
		if (Size == 0)
			return true;
		else
			return false;
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index > Size - 1)
			throw new RuntimeException();
		if (index == Size - 1) {
			if (Size == 1) {
				header.next = null;
				lastNode = header;
				Size--;
			} else {
				lastNode = lastNode.prev;
				lastNode.next = null;
				Size--;
			}
		}

		else if (index == 0) {
			header.next.next.prev = header;
			header.next = header.next.next;
			Size--;
		}

		else {
			DoublyNode n = header.next;
			for (int i = 0; i < index; i++)
				n = n.next;
			n.next.prev = n.prev;
			n.prev.next = n.next;
			Size--;
		}

	}

	@Override
	public int size() {
		return Size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (fromIndex >= Size || fromIndex < 0 || toIndex < 0
				|| toIndex >= Size || fromIndex > toIndex) {
			throw new RuntimeException("");
		} else {
			ILinkedList subList = new DoublyLinkedList();
			DoublyNode n = header.next;
			for (int i = 0; i < Size; i++) {
				if (i >= fromIndex && i <= toIndex) {
					subList.add(n.element);
				}
				n = n.next;
			}
			return subList;
		}
	}

	@Override
	public boolean contains(Object o) {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		DoublyNode n = header.next;
		if (n.element.equals(o))
			return true;
		for (int i = 0; i < Size; i++) {
			if (n.element.equals(o))
				return true;

			n = n.next;
		}
		return false;
	}

	public String toString() {
		DoublyNode n = header.next;
		String temp = "";
		while (n != null) {
			temp = temp + n.element + " ";
			n = n.next;
		}
		return temp;
	}
}