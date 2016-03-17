package eg.edu.alexu.csd.datastructure.iceHockey.cs47;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class testingIceHockek {

	@Test
	public void test() {
		PlayGround object = new PlayGround();
		String[] photo = {

				};
		Point[] answer = 
				new Point[]{

		};
		Integer team = 4;
		Integer threshold = 16;
		Point[] p = object.findPlayers(photo, team, threshold);
//		System.out.println(p.length);
		assertArrayEquals("7owan",answer, p);

	}

}
