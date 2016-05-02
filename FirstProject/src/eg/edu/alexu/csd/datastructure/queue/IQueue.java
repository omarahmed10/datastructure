package eg.edu.alexu.csd.datastructure.queue;

/**
 * The Interface IQueue.
 * @author omarahmed
 *
 */
public interface IQueue {
	
	/**
	 * Inserts an item at the queue front.
	 *
	 * @param item the item
	 */
	public void enqueue(Object item);

	/**
	 * Removes the object at the queue rear and returns it.
	 *
	 * @return the object
	 */
	public Object dequeue();

	/**
	 * Tests if this queue is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in the queue.
	 *
	 * @return the int
	 */
	public int size();
}
