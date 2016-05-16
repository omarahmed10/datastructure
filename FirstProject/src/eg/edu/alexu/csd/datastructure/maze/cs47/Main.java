package eg.edu.alexu.csd.datastructure.maze.cs47;

import java.io.File;

public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public final static void main(final String[] args) {
		MazeSolver m = new MazeSolver();
		m.solveDFS(new File("C:/Users/eng.omar ahmed/Desktop/maze.txt"));
	}
}
