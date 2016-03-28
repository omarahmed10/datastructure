package eg.edu.alexu.csd.datastructure.linkedList.cs47;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class MyLinkedList implements ILinkedList {

	public SNode head = null;

	@Override
	public void add(int index, Object element) {
		SNode newNode = new SNode(element);
		SNode n = head;
		if (n != null) {
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			newNode.next = n.next ;
			n.next = newNode ;
		}
		else if (index == 0) {
			head = newNode ;
		}
		System.out.println("Anta7omar");
		
	}
	public void printNode(){
		SNode i = head;
		
		while(i != null){
			System.out.print(i.value + ",");
			i = i.next;
		}
	}
	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
