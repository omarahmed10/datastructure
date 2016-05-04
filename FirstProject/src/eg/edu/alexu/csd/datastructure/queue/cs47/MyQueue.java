package eg.edu.alexu.csd.datastructure.queue.cs47;

import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.linkedList.cs47.SinglyLinkedList;;

// TODO: Auto-generated Javadoc
/**
 * The Class MyQueue.
 */
public class MyQueue implements IQueue, ILinkedBased {

	/** The list. */
	private SinglyLinkedList list = new SinglyLinkedList();

	@Override
	public final void enqueue(final Object item) {
		list.add(item);
	}

	@Override
	public final Object dequeue() {
		Object dequeue = new Object();
		dequeue = list.get(0);
		list.remove(0);
		return dequeue;
	}

	@Override
	public final boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		System.out.println("             ");
	}
}
