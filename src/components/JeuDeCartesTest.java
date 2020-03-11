package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class JeuDeCartesTest {

	@Test
	public void test() {
		JeuDeCartes j = new JeuDeCartes();
		assertTrue(j.getJeuCartes().size()==33);
	}
}
