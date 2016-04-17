package eg.edu.alexu.csd.datastructure.linkedList.cs47;
/**
 * 
 * @author Omar_Ahmed
 *
 */
public class SinglyNode {
	/**
	 *
	 */
	public Object element ;
	/**
	 *
	 */
	public SinglyNode next;
	/**
	 *
	 * @param element
	 */
	public SinglyNode(Object element){
		
		this.element = element;
		next = null;
	}
	public static void main(String[] args){
		SinglyNode n = new SinglyNode(5);
		SinglyNode m = new SinglyNode(5);
		if( n.element == m.element )
			System.out.println("Done");
	}
}
