package eg.edu.alexu.csd.datastructure.linkedList.cs47;


public class TestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList l = new MyLinkedList();
		l.add(12);
		l.add(0,5);
		l.add(1,6);
		l.add(2,6);
		l.add(0,1);
		l.add("omar");
		l.add(6, "element");
//		l.clear();
		l.add(12);
		l.add(8, 7);
		l.printList();
		l.set(0, "ahmed");
		l.printList();
		l.remove(9);
		l.printList();
		System.out.println(l.get(0));
//		System.out.println(l.get(8));
		System.out.println(l.isEmpty());

	}

}
