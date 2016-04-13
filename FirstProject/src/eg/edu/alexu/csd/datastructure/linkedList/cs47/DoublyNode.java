package eg.edu.alexu.csd.datastructure.linkedList.cs47;

public class DoublyNode {
	/**
	 * 
	 */
	public Object element;
	/**
	 * 
	 */
	public DoublyNode next;
	/**
	 * 
	 */
	public DoublyNode prev;
/**
 * 
 * @param element
 */
	public DoublyNode(Object element) {
		this.element = element;
		next = null;
		prev = null;
	}
}