package eg.edu.alexu.csd.datastructure.linkedList.cs47;


import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;


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
//		l.add(10, 8);
		l.printList();
		l.set(8, "ahmed");
		l.printList();
//		l.remove(9);
//		l.printList();
//		System.out.println(l.get(100));
//		System.out.println(l.get(8));
		System.out.println(l.isEmpty());
		System.out.println(l.size());
//		l.clear();
//		System.out.println(l.size());
		System.out.println(l.contains("ahmed"));
		System.out.println(l.sublist(0, 4).size());
		System.out.println(l.sublist(0, 4).get(3));
//		ILinkedList o = l.sublist(0, 4);
////		o = l.sublist(0, 4);
//		o.printList();
//		o.clear();
//		System.out.println(o.size());
	}

}
