package eg.edu.alexu.csd.datastructure.iceHockey.cs47.tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.cs47.PlayGround;

public class testing {

	@Test
	public void test() {
		PlayGround object = new PlayGround();
		PlayGround object1 = new PlayGround();
		String[] photo1 = { "11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
		Point[] answer1 = { new Point(5, 5), new Point(5, 5) };
		Integer team1 = 1;
		Integer threshold1 = 3;
		String[] photo = {};
		Point[] answer = {};
		Integer team = 1;
		Integer threshold = 3;
		Point[] p1 = object1.findPlayers(photo1, team1, threshold1);
		assertArrayEquals("7owan", answer1, p1);
		Point[] p = object.findPlayers(photo, team, threshold);
		assertArrayEquals("7owan", answer, p);

	}

	@Test
	public void test1() {
		PlayGround object1 = new PlayGround();
		String[] photo1 = { "11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
		Point[] answer1 = { };
		Integer team1 = 1;
		Integer threshold1 = 100;
		Point[] p1 = object1.findPlayers(photo1, team1, threshold1);
		assertArrayEquals("7owan", answer1, p1);

	}

}
