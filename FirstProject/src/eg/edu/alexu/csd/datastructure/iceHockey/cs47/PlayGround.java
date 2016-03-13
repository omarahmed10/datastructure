package eg.edu.alexu.csd.datastructure.iceHockey.cs47;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class PlayGround implements IPlayersFinder {

	final int max = 51;
	int cnt = 0;
	int team;
	int threshold;
	String[] maze ;
	boolean[][] vis = new boolean[max][max];
	int[][] playerPosition;

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		maze =new String[photo.length];
		maze = photo;
		playerPosition =new int [photo.length * photo[0].length()][2];
		this.team = team;
		this.threshold = threshold;
		cntReachalbleCells(photo.length, photo[0].length());

		return null;
	}

	public void cntReachalbleCells(int r, int c) {
		if (!valid(r, c) 
				|| maze[r].charAt(c) != team 
				|| vis[r][c] == true)
			return; // invalid position or block position

		vis[r][c] = true; // we just visited it, don't allow any one back to it
		cnt++;
		System.out.println(r + "," + c);
		// Try the 4 neighbor cells
		cntReachalbleCells(r, c - 1);
		cntReachalbleCells(r, c + 1);
		cntReachalbleCells(r - 1, c);
		cntReachalbleCells(r + 1, c);
	}

	public boolean valid(int r, int c) {
		if (r < 0 || r > 3 || c < 0 || c > 3)
			return false;
		return true;
	}

	public static void main(String[] args) {
		PlayGround pgObject = new PlayGround();

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				pgObject.cnt = 0;
				pgObject.cntReachalbleCells(i, j);
				System.out.println(pgObject.cnt + "\n");
			}
	}

}
