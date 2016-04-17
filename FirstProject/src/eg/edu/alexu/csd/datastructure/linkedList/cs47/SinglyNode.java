package eg.edu.alexu.csd.datastructure.linkedList.cs47;

/**.
 * @author Ali-Metawea
 */
public class SinglyNode {
	/**
	 */
	private Object element;
	/**.
	 */
	private SinglyNode next;

	/**.
	 * @param newEle a
	 */
	public SinglyNode(final Object newEle) {

		this.element = newEle;
		next = null;
	}

	/**. Returns the element of this node
	 *  @return element a 
	 */
	public final Object getElement() {
		return element;
	}

	/** Returns the next node of this node.
	 * @return next  
	 */
	public final SinglyNode getNext() {
		return next;
	}

	/** Sets the element of this node.
	 * @param newElem  
	 */
	public final void setElement(final Object newElem) {
		element = newElem;
	}

	/** Sets the next node of this node.
	 * @param newNext  
	 */
	public final void setNext(final SinglyNode newNext) {
		next = newNext;
	}

}