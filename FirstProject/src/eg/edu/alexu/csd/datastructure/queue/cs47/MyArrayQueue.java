package eg.edu.alexu.csd.datastructure.queue.cs47;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * The Class MyArrayQueue.
 * 
 * @author omar_ahmed
 *
 */
public class MyArrayQueue implements IQueue, IArrayBased {

	/** list of elements. */
	private Object[] list;
	/** front of the list. */
	private int f;
	/** rear of the list. */
	private int r;
	/** number of elements in queue. */
	private int count;

	/** size of List. */
	private int listSize;

	/**
	 * Instantiates a new my array queue.
	 *
	 * @param size
	 *            the size
	 */
	public MyArrayQueue(final int size) {
		f = 0;
		r = 0;
		count = 0;
		this.listSize = size;
		if (size <= 0) {
			throw new RuntimeException();
		}
		list = new Object[this.listSize];
	}

	@Override
	public final void enqueue(final Object item) {
		if (count == listSize - 1) {
			throw new RuntimeException();
		}
		list[r] = item;
		count++;
		r = (r + 1) % listSize;
	}

	@Override
	public final Object dequeue() {
		if(f == r){
			throw new RuntimeException();
		}
		Object element = list[f];
		list[f] = null;
		f = (f + 1) % listSize;
		count--;
		return element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.edu.alexu.csd.datastructure.queue.IQueue#isEmpty()
	 */
	@Override
	public final boolean isEmpty() {
		return f == r;
	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return (listSize - f + r) % listSize;
	}

}
