package eg.edu.alexu.csd.datastructure.iceHockey.cs47;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class PlayGround implements IPlayersFinder {

	final int max = 51;
	int cnt;
	int team;
	int threshold;
	String[] maze;
	boolean[][] vis = new boolean[max][max];
	int[][] playerPosition;

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		maze = new String[photo.length];
		maze = photo;

		int x = photo.length * photo[0].length(); ///// photo[0].length() is
													///// length of one string
													///// as all given string
													///// are equal in length
		playerPosition = new int[x][2];
		this.team = team;
		this.threshold = threshold;
		for (int I = 0; I < photo.length; I++) {
			for (int J = 0; J < photo[I].length(); J++) {
				////////// initializing playerPositions list to avoid
				////////// NullPointer
				for (int i = 0; i < x; i++)
					for (int j = 0; j < 2; j++)
						playerPosition[i][j] = 0;
				/////////
				cnt = 0;
				cntReachalbleCells(photo.length, photo[0].length());
			}
		}

		return null;
	}

	public void cntReachalbleCells(int r, int c) {
		if (!valid(r, c) || maze[r].charAt(c) != team || vis[r][c] == true)
			return; // invalid position

		vis[r][c] = true; // we just visited it, don't allow any one back to it

		playerPosition[cnt][0] = r; ////// saving player position (x coordinate)
		playerPosition[cnt][1] = c; ////// (y coordinate)

		cnt++; ///// counting number of cell where a player was found

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
