package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class MurTest {

	@Test
	public void test() {
		Mur m = new Mur();
		Carreau x = new Carreau(1,3,'x',false);
		ListeCarreaux p = new ListeCarreaux(true);
		TypeErreur t1=m.placerCarreau(p.getCarreau('c'), -1, -1);
		assertTrue(t1==TypeErreur.DEPASSEMENT); // test de l'erreur de dépassement
		TypeErreur t2=m.placerCarreau(x, 1, 1);
		TypeErreur t3=m.placerCarreau(p.getCarreau('a'), 1, 4);
		assertTrue(t3==TypeErreur.CLONAGE);
	}

}
