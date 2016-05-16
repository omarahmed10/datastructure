package eg.edu.alexu.csd.datastructure.maze.cs47;

import java.io.File;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.linkedList.*;

import eg.edu.alexu.csd.datastructure.linkedList.cs47.SinglyLinkedList;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;

/**
 * The Class MazeSolver.
 */
public class MazeSolver implements IMazeSolver {

	/** x_axis of the starting position. */
	private int startX;

	/** y_axis of the starting position. */
	private int startY;

	/** file dataSaver. */
	private char[][] mazeArray;

	/** the require path to the end. */
	private int[][] path;

	/** . */
	private SinglyLinkedList xList = new SinglyLinkedList();
	/** . */
	private SinglyLinkedList yList = new SinglyLinkedList();

	/** variable to determine size of the array. */
	private int n, m;

	/** to determine visited node. */
	private boolean[][] visited;

	/** determine whether it reach the End point or not. */
	private boolean reached = false;

	@Override
	public final int[][] solveBFS(final File maze) {
		mazeArray = changeData(maze);

		return null;
	}

	@Override
	public final int[][] solveDFS(final File maze) {
		mazeArray = changeData(maze);
		dfs(startX, startY);
		System.out.println("======================");
		path = new int[xList.size()][2];
		for (int i = 0; i < xList.size(); i++) {
			path[i][0] = (int) xList.get(i);
			xList.remove(i);
			path[i][1] = (int) yList.get(i);
			yList.remove(i);
		}
		return path;
	}

	/**
	 * 
	 * @param x
	 *            is the x-axis of the visited node
	 * @param y
	 *            is the y-axis of the visited node
	 */
	private void dfs(final int x, final int y) {
		if (x < 0 || x >= n || y < 0 || y >= m || reached
				|| mazeArray[x][y] == '#') {
			return;
		} else if (visited[x][y]) {
			return;
		} else if (mazeArray[x][y] == 'E') {
			System.out.println(x + "," + y);
			reached = true;
			xList.add(x);
			yList.add(y);
			visited[x][y] = true;
			return;
		} else {
			System.out.println(x + "," + y);
			xList.add(x);
			yList.add(y);
			visited[x][y] = true;
		}
		dfs(x - 1, y);
		dfs(x, y + 1);
		dfs(x + 1, y);
		dfs(x, y - 1);
	};

	/**
	 * @param data
	 *            change data of the given file to a two dimensional array.
	 * @return return the data in the required form.
	 */
	public final char[][] changeData(final File data) {
		Scanner x;
		char[][] dataArray = {};
		try {
			x = new Scanner(data);
			if (x.hasNextInt()) {
				n = x.nextInt();
				m = x.nextInt();
				dataArray = new char[n][m];
				visited = new boolean[n][m];
			} else {
				x.close();
				throw new RuntimeException();
			}
			int rowNumber = 0, entriesNumber = 0;
			while (x.hasNext()) {
				String row = x.next();
				if (row.length() != m || entriesNumber > 1) {
					x.close();
					throw new RuntimeException();
				}
				for (int i = 0; i < row.length(); i++) {
					dataArray[rowNumber][i] = row.charAt(i);
					if (dataArray[rowNumber][i] == 'S') {
						startX = rowNumber;
						startY = i;
						entriesNumber++;
					}
				}
				rowNumber++;
			}
			x.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return dataArray;
	}
}
