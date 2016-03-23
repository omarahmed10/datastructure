package eg.edu.alexu.csd.datastructure.iceHockey.cs47;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class PlayGround implements IPlayersFinder {

	private final int max = 51;
	private int cnt;
	private int noOfPlayer = 0;
	private char team;
	private String[] image;
	private boolean[][] vis = new boolean[max][max];
	private int[][] playerPosition;
	private Point[] positions = new Point[250];

	// private int i = 0;

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {

		image = new String[photo.length];
		image = photo;
		noOfPlayer = 0;
		this.team = (char) (team + 48);
		if (photo.length != 0) {
			int x = photo.length * photo[0].length(); // /// photo[0].length()
														// is
			// /// length of one
			// /// string
			// /// as all given
			// /// string are equal
			// /// in length
			playerPosition = new int[x][2];
			for (int I = 0; I < photo.length; I++) {
				for (int J = 0; J < photo[I].length(); J++) {
					// //////// initializing playerPositions list to avoid
					// //////// NullPointer
					for (int i = 0; i < x; i++)
						for (int j = 0; j < 2; j++)
							playerPosition[i][j] = 0;
					// ///////
					cnt = 0;
					cntReachalbleCells(I, J);
					if (cnt * 4 >= threshold) {
						positions[noOfPlayer] = new Point(0, 0); // ////
																	// initializing
						positions[noOfPlayer] = new Point(getPlayerCenter(
								playerPosition, cnt));
						noOfPlayer++;
						System.out.println(positions[noOfPlayer]);
						System.out.println(noOfPlayer);
					}
				}
			}
			Arrays.sort(positions, 0, noOfPlayer, new PointCmp());
			Point[] finalPositions = new Point[noOfPlayer];
			for (int i = 0; i < noOfPlayer; i++)
				finalPositions[i] = positions[i];
			return finalPositions;
		}
		Point[] finalPositions = {};
		return finalPositions;
	}

	public void cntReachalbleCells(int r, int c) {
		if (!valid(r, c) || image[r].charAt(c) != team || vis[r][c] == true)
			return; // invalid position

		vis[r][c] = true; // we just visited it, don't allow any one back to it

		if (image[r].charAt(c) == team) {
			playerPosition[cnt][0] = c; // //// saving player position (c
										// //// coordinate)
			playerPosition[cnt][1] = r; // //// (y coordinate)
			cnt++; // /// counting number of cell where a player was found
		}
		cntReachalbleCells(r, c - 1);
		cntReachalbleCells(r, c + 1);
		cntReachalbleCells(r - 1, c);
		cntReachalbleCells(r + 1, c);
	}

	public boolean valid(int r, int c) {
		if (r < 0 || r >= image.length || c < 0 || c >= image[0].length())
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
		min = max = a[0][1];
		for (int j = 0; j < n; j++) {
			if (a[j][1] < min)
				min = a[j][1];
			else if (a[j][1] > max)
				max = a[j][1];
		}
		col = ((max * 2) + 2 - (min * 2)) / 2 + (2 * min);
		x = new Point(row, col);
		return x;
	}

	public static void main(String[] args) {
		String[] image = { "1", "1" };
		PlayGround pgObject = new PlayGround();
		Point[] answer = pgObject.findPlayers(image, 1, 4);
		String[] image1 = { "3", "3", "3" };

		for (int i = 0; i < answer.length; i++)
			if (answer[i] != null)
				System.out.println(answer[i].x + "," + answer[i].y);

		Point[] answer1 = pgObject.findPlayers(image1, 3, 3);
		for (int i = 0; i < answer1.length; i++)
			if (answer1[i] != null)
				System.out.println(answer1[i].x + "," + answer1[i].y);
	}

}

class PointCmp implements Comparator<Point> {
	public int compare(Point a, Point b) {
		return (a.x < b.x) ? -1 : (a.x > b.x) ? 1 : 0;
	}
}
