package eg.edu.alexu.csd.datastructure.maze.cs47;

import java.awt.Point;
import java.io.File;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.linkedList.cs47.SinglyLinkedList;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs47.MyQueue;

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
	private SinglyLinkedList pointList = new SinglyLinkedList();

	/** variable to determine size of the array. */
	private int n, m;

	/** to determine visited node. */
	private boolean[][] visited;

	/** determine whether it reach the End point or not. */
	private boolean reached = false;

	/** to trace path. */
	private MyQueue pathQueue = new MyQueue();

	@Override
	public final int[][] solveBFS(final File maze) {
		mazeArray = changeData(maze);
		reached = false;
		Node startPoint = new Node(startX, startY, null);
		bfs(startX, startY, startPoint);
		// system.out.println("=========BFS=============");
		if (reached) {
			// system.out.println(pointList.size());
			path = new int[pointList.size()][2];
			for (int i = 0; i < pointList.size(); i++) {
				Node current = (Node) pointList.get(i);
				path[i][0] = current.getX();
				path[i][1] = current.getY();
			}
			return path;
		} else {
			// system.out.println("noExit or noPath");
			return null;
		}
	}

	@Override
	public final int[][] solveDFS(final File maze) {
		mazeArray = changeData(maze);
		reached = false;
		dfs(startX, startY);
		// system.out.println("=========DFS=============");
		if (reached) {
			path = new int[pointList.size()][2];
			for (int i = 0; i < pointList.size(); i++) {
				Point current = (Point) pointList.get(i);
				path[i][0] = current.x;
				path[i][1] = current.y;
			}
			return path;
		} else {
			// system.out.println("noExit or noPath");
			return null;
		}
	}

	/**
	 * 
	 * @param x
	 *            is the x-axis of the current node
	 * @param y
	 *            is the y-axis of the current node
	 */
	private void dfs(final int x, final int y) {
		if (x < 0 || x >= n || y < 0 || y >= m || reached
				|| mazeArray[x][y] == '#' || visited[x][y]) {
			return;
		} else if (mazeArray[x][y] == 'E') {
			// system.out.println(x + "," + y);
			reached = true;
			Point current = new Point(x, y);
			pointList.add(current);
			visited[x][y] = true;
			return;
		} else {
			// system.out.println(x + "," + y);
			Point current = new Point(x, y);
			pointList.add(current);
			visited[x][y] = true;
		}
		dfs(x - 1, y);
		dfs(x, y + 1);
		dfs(x + 1, y);
		dfs(x, y - 1);
		if (!reached) {
			pointList.remove(pointList.size() - 1);
		}
	};

	/**
	 * Bfs.
	 *
	 * @param x
	 *            is the x-axis of the current node
	 * @param y
	 *            is the y-axis of the current node
	 */
	private void bfs(final int x, final int y, final Node parent) {
		// system.out.println(x + "," + y);
		visited[x][y] = true;
		// Point current = new Point(x, y);
		// pointList.add(current);
		// System.out.println(pointList);
		if (x - 1 >= 0 && mazeArray[x - 1][y] != '#' && !visited[x - 1][y]) {
			Node child = new Node(x - 1, y, parent);
			pathQueue.enqueue(child);
			visited[x - 1][y] = true;
			// System.out.println(child);
		}
		if (y + 1 < m && mazeArray[x][y + 1] != '#' && !visited[x][y + 1]) {
			Node child = new Node(x, y + 1, parent);
			pathQueue.enqueue(child);
			visited[x][y + 1] = true;
			// System.out.println(child);
		}
		if (x + 1 < n && mazeArray[x + 1][y] != '#' && !visited[x + 1][y]) {
			Node child = new Node(x + 1, y, parent);
			pathQueue.enqueue(child);
			visited[x + 1][y] = true;
			// System.out.println(child);
		}
		if (y - 1 >= 0 && mazeArray[x][y - 1] != '#' && !visited[x][y - 1]) {
			Node child = new Node(x, y - 1, parent);
			pathQueue.enqueue(child);
			visited[x][y - 1] = true;
			// System.out.println(child);
		}
		if (!pathQueue.isEmpty()) {
			Node newNode = (Node) pathQueue.dequeue();
			// System.out.println(newPoint.x + "," + newPoint.y);
			if (mazeArray[newNode.getX()][newNode.getY()] == 'E') {
//				System.out.println("DOne");
				Node node2 = newNode;
				while (node2 != null) {
					pointList.add(0, node2);
					node2 = node2.getParent();
				}
				reached = true;
				// pointList.add(newNode);
				return;
			} else {
				bfs(newNode.getX(), newNode.getY(), newNode);
			}
		} else {
			// there is no path or there is no exit.
			return;
		}

	}

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
			int rowNumber = 0, entriesNumber = 0, exitPoint = 0;
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
					if (dataArray[rowNumber][i] == 'E') {
						exitPoint++;
					}
				}
				rowNumber++;
			}
			if (entriesNumber == 0 || exitPoint == 0) {
				x.close();
				throw new RuntimeException();
			}
			x.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return dataArray;
	}
}
