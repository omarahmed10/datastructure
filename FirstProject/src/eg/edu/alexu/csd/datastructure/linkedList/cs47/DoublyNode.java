package eg.edu.alexu.csd.datastructure.linkedList.cs47;

/**
 * @author Omar_Ahmed
 */
public class DoublyNode {
	/**
	 */
	private Object element;
	/**
	 */
	private DoublyNode next;
	/**
	 */
	private DoublyNode prev;

	/**
	 * @param newEle  
	 *            data in the node
	 */
	public DoublyNode(final Object newEle) {
		this.element = newEle;
		next = null;
		prev = null;
	}

	/**. 
	 * Returns the element of this node
	 * @return element current 
	 */
	public final Object getElement() {
		return element;
	}

	/**.
	 *  Returns the previous node of this node
	 * @return prev node */
	public final DoublyNode getPrev() {
		return prev;
	}

	/**.
	 *  Returns the next node of this node
	 * @return next node
	 */
	public final DoublyNode getNext() {
		return next;
	}

	/** .
	 * Sets the element of this node
	 * @param newElem n */
	public final void setElement(final Object newElem) {
		element = newElem;
	}

	/** .
	 * Sets the previous node of this node 
	 * @param newPrev node
	 */
	public final void setPrev(final DoublyNode newPrev) {
		prev = newPrev;
	}

	/** .
	 * Sets the next node of this node 
	 * @param newNext node
	 */
	public final void setNext(final DoublyNode newNext) {
		next = newNext;
	}

}