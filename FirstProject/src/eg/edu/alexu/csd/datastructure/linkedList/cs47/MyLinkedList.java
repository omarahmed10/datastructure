package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class MyLinkedList implements ILinkedList {

	public SNode head = null;

	@Override
	public void add(int index, Object element) {
		SNode newNode = new SNode(element);
		SNode n = head;
		if (n != null && index != 0) {
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
				if (n == null)
					throw new RuntimeException("yamokos");
			}
			newNode.next = n.next;
			n.next = newNode;
		} else if (index == 0) {
			newNode.next = head;
			head = newNode;
		}
	}

	public void printList() {
		SNode i = head;
		System.out.print("[");
		while (i != null) {
			System.out.print(i.value);
			i = i.next;
			if (i != null)
				System.out.print(",");
		}
		System.out.println("]");
	}

	@Override
	public void add(Object element) {
		SNode newNode = new SNode(element);
		SNode i = head;
		if (i != null) {
			while (i.next != null) {
				i = i.next;
				if (i == null)
					throw new RuntimeException("yamokos");
			}
			i.next = newNode;
		} else {
			head = newNode;
		}
	}

	@Override
	public Object get(int index) {
		try {
			SNode i = head;
			if (i != null && index != 0) {
				for (int count = 0; count < index; count++) {
					i = i.next;
					// if (i == null)
					// throw new RuntimeException("yamokos");
				}
			}
			// else if (i == null)
			// // throw new RuntimeException("yamokos");

			return i.value;

		} catch (Exception e) {
			throw new RuntimeException("yamokos");
		}

	}

	@Override
	public void set(int index, Object element) {

		SNode i = head;
		if (i != null && index != 0) {
			for (int count = 0; count < index; count++) {
				i = i.next;
				if (i == null)
					throw new RuntimeException("yamokos");
			}
		} else if (i == null)
			throw new RuntimeException("yamokos");

		i.value = element;

	}

	@Override
	public void clear() {
		head = null;
	}

	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	@Override
	public void remove(int index) {
		try {
			SNode m;
			SNode n = head;
			if (n != null && index != 0) {
				for (int i = 0; i < index - 1; i++) {
					n = n.next;
					// if( n == null )
					// throw new RuntimeException("yamokos");
				}
				m = n.next;
				// if( m == null )
				// throw new RuntimeException("yamokos");
				n.next = m.next;
			} else if (index == 0) {
				m = head;
				head = m.next;
			}

		} catch (Exception e) {
			throw new RuntimeException("yamokos");
		}
		// SNode m;
		// SNode n = head;
		// if (n != null && index != 0) {
		// for (int i = 0; i < index - 1; i++) {
		// n = n.next;
		// // if( n == null )
		// // throw new RuntimeException("yamokos");
		// }
		// m = n.next;
		// // if( m == null )
		// // throw new RuntimeException("yamokos");
		// n.next = m.next;
		// } else if (index == 0) {
		// m = head;
		// head = m.next;
		// }

	}

	@Override
	public int size() {
		SNode n = head;
		int count = 0;
		while (n != null) {
			n = n.next;
			count++;
		}
		return count;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object o) {
		try {
			SNode n = head;
			while (n != null && !n.value.equals(o)) {
				n = n.next;
			}
			if( n.value.equals(o))
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

}
