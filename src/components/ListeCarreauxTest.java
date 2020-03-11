package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListeCarreauxTest {

	@Test
	public void test() {
		ListeCarreaux p = new ListeCarreaux(true);
		Carte c = new Carte(TypeCarte.TAILLE1);
		assertTrue(p.size()==18);
		// on vérifie qu'un carreau de dimension 2x2 ne fait pas partie de ceux de taille 1
		assertFalse(p.carreauDispo(c).contient('d'));
	}
}
