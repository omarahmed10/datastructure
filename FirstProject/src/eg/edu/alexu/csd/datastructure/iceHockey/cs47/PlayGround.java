package eg.edu.alexu.csd.datastructure.iceHockey.cs47;

import java.awt.Point;
import java.util.Arrays;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.Comparator;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class PlayGround implements IPlayersFinder {

	final int max = 51;
	int cnt;
	int c = 0;
	char team;
	int threshold;
	String[] maze;
	boolean[][] vis = new boolean[max][max];
	int[][] playerPosition;
	Point[] positions = new Point[250];

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		maze = new String[photo.length];
		maze = photo;
		if (photo.length != 0) {
			
			this.team = (char) (team + 48);
			this.threshold = threshold;
			
			int x = photo.length * photo[0].length(); ///// photo[0].length() is length of one string
														///// as all given string are equal in length
			playerPosition = new int[x][2];

			for (int I = 0; I < photo.length; I++) {
				for (int J = 0; J < photo[I].length(); J++) {
					////////// initializing playerPositions list to avoid NullPointer
					for (int i = 0; i < x; i++)
						for (int j = 0; j < 2; j++)
							playerPosition[i][j] = 0;
					/////////
					cnt = 0;
					cntReachalbleCells(I,J);
					if (cnt * 4 >= threshold) {
//						System.out.println(cnt);
						positions[c] = new Point(0,0); ////// initializing
						positions[c] = new Point(getPlayerCenter(playerPosition, cnt));
						c++;
//						System.out.println(positions[c].x + "," + positions[c].y);
					}
				}
			}
			Arrays.sort(positions, 0, c,new PointCmp());
			Point[] finalPositions = new Point[c];
			for(int i = 0;i < c;i++)
				finalPositions[i] = positions[i];
			return finalPositions;
		}
		return null;
	}

	public void cntReachalbleCells(int r, int c) {
		if (!valid(r, c) || maze[r].charAt(c) != team || vis[r][c] == true)
			if (r != maze.length || c != maze[0].length()) {
				return; // invalid position
			}

		vis[r][c] = true; // we just visited it, don't allow any one back to it

		if (maze[r].charAt(c) == team) {
			playerPosition[cnt][0] = c; ////// saving player position (c coordinate)
			playerPosition[cnt][1] = r; ////// (y coordinate)
//			System.out.println(playerPosition[cnt][0] + "," + playerPosition[cnt][1]);
			cnt++; ///// counting number of cell where a player was found
		}
		// Try the 4 neighbor cells
		cntReachalbleCells(r, c - 1);
		cntReachalbleCells(r, c + 1);
		cntReachalbleCells(r - 1, c);
		cntReachalbleCells(r + 1, c);
	}

	public boolean valid(int r, int c) {
		if (r < 0 || r >= maze.length || c < 0 || c >= maze[0].length())
			return false;
		return true;
	}

	public Point getPlayerCenter(int a[][], int n) {
		Point x;
		int min = a[0][0], max = a[0][0], row, col;
		for (int j = 0; j < n; j++) {
			if (a[j][0] < min)
				min = a[j][0];
			else if (a[j][0] > max)
				max = a[j][0];
		}
		row = ((max * 2) + 2 - (min * 2)) / 2 + (2 * min);
//		System.out.println(max +" "+ min);
		min = max = a[0][1];
		for (int j = 0; j < n; j++) {
			if (a[j][1] < min)
				min = a[j][1];
			else if (a[j][1] > max)
				max = a[j][1];
		}
		col = ((max * 2) + 2 - (min * 2)) / 2 + (2 * min);
//		System.out.println(max +" "+ min);
		x = new Point(row, col);
//		System.out.println(x.x + "," + x.y);
		return x;
	}

	public static void main(String[] args) {
		String[] image = {

				};
		PlayGround pgObject = new PlayGround();
		Point[] answer = pgObject.findPlayers(image, 1, 4);
//		System.out.println(answer[0].x + "," + answer[0].y);
//		System.out.println(answer.length);
		for (int i = 0; i < answer.length; i++)
			if (answer[i] != null)
				System.out.println(answer[i].x + "," + answer[i].y);
		// for (int i = 0; i < 4; i++)
		// for (int j = 0; j < 4; j++) {
		// pgObject.cnt = 0;
		// pgObject.cntReachalbleCells(i, j);
		// System.out.println(pgObject.cnt + "\n");
		// }
	}

}

class PointCmp implements Comparator<Point> {
	public int compare(Point a, Point b) {
		return (a.x < b.x) ? -1 : (a.x > b.x) ? 1 : 0;
	}
}
