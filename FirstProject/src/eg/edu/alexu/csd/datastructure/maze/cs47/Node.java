package eg.edu.alexu.csd.datastructure.maze.cs47;
// TODO: Auto-generated Javadoc

/**
 * The Class Node.
 *
 * @author eng.omar ahmed
 */
public class Node {

	/** The x-axis. */
	private int x;

	/** The y-axis. */
	private int y;

	/** The parent. */
	private Node parent;

	/**
	 * 
	 * @param x1
	 *            of current point.
	 * @param y1
	 *            of current point.
	 * @param parent1
	 *            which call this point.
	 */
	public Node(final int x1, final int y1, final Node parent1) {
		this.x = x1;
		this.y = y1;
		this.parent = parent1;
	}

	/**
	 * 
	 * @return x-axis.
	 */

	public final int getX() {
		return x;
	}

	/**
	 * 
	 * @return y-axis.
	 */

	public final int getY() {
		return y;
	}
	/**
	 * 
	 * @return y-axis.
	 */

	public final Node getParent() {
		return parent;
	}
}
