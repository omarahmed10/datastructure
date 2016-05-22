package eg.edu.alexu.csd.datastructure.maze.cs47;

import java.io.File;

/**
 * 
 * @author eng.omar ahmed
 *
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static final void main(final String[] args) {
		MazeSolver m = new MazeSolver();
		int[][] solution = m
				.solveBFS(new File("C:/Users/eng.omar ahmed/Desktop/maze.txt"));
		if (solution != null) {
			for (int i = 0; i < solution.length; i++) {
				System.out.print(
						"(" + solution[i][0] + "," + solution[i][1] + ") ");
			}
		}
//		System.out.println();
//		int[][] solution1 = m
//				.solveDFS(new File("C:/Users/eng.omar ahmed/Desktop/maze.txt"));
//		if (solution1 != null) {
//			for (int i = 0; i < solution1.length; i++) {
//				System.out.print(
//						"(" + solution1[i][0] + "," + solution1[i][1] + ") ");
//			}
//		}
	}
}
