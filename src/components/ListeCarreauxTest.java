package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListeCarreauxTest {

	@Test
	public void test() {
		ListeCarreaux p = new ListeCarreaux(true);
		assertTrue(p.size()==18);
	}

}
