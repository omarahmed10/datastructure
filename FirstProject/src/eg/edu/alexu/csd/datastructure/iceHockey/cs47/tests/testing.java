package eg.edu.alexu.csd.datastructure.iceHockey.cs47.tests;
import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.cs47.PlayGround;
import static org.junit.Assert.*;

import org.junit.Test;

public class testing {

	@Test
	public void test() {
		PlayGround objectGround = new PlayGround();
		String[] image = new String[]{
				"333333",
				"222222"
		};
		Integer team =1;
		Integer threshold = 3;
		
		Point[] p = objectGround.findPlayers(image, team, threshold);
		Point [] expecteds ={
				
		};
		assertArrayEquals(expecteds, p);
		
	}

}
