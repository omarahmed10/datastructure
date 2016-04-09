package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SinglyLinkedList implements ILinkedList {

	private SinglyNode header;
	private SinglyNode lastNode;
	private int Size = 0;

	public SinglyLinkedList() {

		header = new SinglyNode(null);
		lastNode = header;

	}

	public void add(int index, Object element) {
		if (index < 0 || index > Size)
			throw new RuntimeException();
		if (index == 0) {
			SinglyNode n = new SinglyNode(element);
			if (Size == 0) {
				header.next = n;
				lastNode = n;
				Size++;
			} else {
				n.next = header.next;
				header.next = n;
				Size++;
			}
		}

		else if (index == Size)
			add(element);

		else {
			SinglyNode n = new SinglyNode(element);
			SinglyNode x = header.next;
			for (int i = 0; i < index - 1; i++) {
				x = x.next;
			}
			n.next = x.next;
			x.next = n;
			Size++;
		}

	}

	public void add(Object element) {
		SinglyNode n = new SinglyNode(element);
		if (Size == 0) {
			header.next = n;
			lastNode = n;
			Size++;
		}

		else {
			lastNode.next = n;
			lastNode = n;
			Size++;
		}

	}

	@Override
	public Object get(int index) {
		if (index < 0 || index > Size - 1)
			throw new RuntimeException();
		else {
			SinglyNode n = header.next;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}

			return n.element;
		}
	}

	public void set(int index, Object element) {

		if (index < 0 || index > Size - 1)
			throw new RuntimeException();
		else {
			SinglyNode n = header.next;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}

			n.element = element;

		}

	}

	@Override
	public void clear() {

		header = new SinglyNode(null);
		lastNode = header;
		Size = 0;

	}

	public boolean isEmpty() {
		if (Size == 0)
			return true;
		else
			return false;
	}

	public void remove(int index) {
		if (index < 0 || index > Size - 1 || Size == 0)
			throw new RuntimeException("");
		if (index == Size - 1) {

			if (Size == 1) {
				header.next = null;
				lastNode = header;
				Size--;
			}

			else {
				SinglyNode n = header.next;
				for (int i = 0; i < Size - 2; i++)
					n = n.next;

				lastNode = n;
				lastNode.next = null;
				Size--;
			}
		}

		else if (index == 0) {
			header.next = header.next.next;
			Size--;
		}

		else {

			SinglyNode n = header.next;
			for (int i = 0; i < index - 1; i++)
				n = n.next;

			n.next = n.next.next;
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
				|| toIndex >= Size || fromIndex > toIndex)
			throw new RuntimeException("");
		else {
			ILinkedList subList = new SinglyLinkedList();
			SinglyNode n = header.next;
			for (int i = 0; i < Size; i++) {
				if (i >= fromIndex && i <= toIndex)
					subList.add(n.element);
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
		SinglyNode n = header.next;
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
		SinglyNode n = header.next;
		String temp = "";
		while (n != null) {
			temp = temp + n.element + " ";
			n = n.next;
		}
		return temp;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		
	}

}