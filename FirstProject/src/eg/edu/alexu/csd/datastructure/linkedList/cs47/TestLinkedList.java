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
		System.out.println(l.get(2));
//		l.add(8, 7);
		l.printNode();

	}

}
