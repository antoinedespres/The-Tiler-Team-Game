package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class MurTest {

	@Test
	public void test() {
		// test des erreurs de placement
		Mur m = new Mur();
		Carreau x = new Carreau(1,3,'x',false);
		ListeCarreaux p = new ListeCarreaux(true);
		TypeErreur t1=m.placerCarreau(p.getCarreau('c'), -1, -1);
		assertTrue(t1==TypeErreur.DEPASSEMENT);
		TypeErreur t2=m.placerCarreau(x, 1, 1);
		assertTrue(t2==TypeErreur.CORRECT);
		TypeErreur t3=m.placerCarreau(p.getCarreau('a'), 1, 4);
		assertTrue(t3==TypeErreur.CLONAGE);
		TypeErreur t4=m.placerCarreau(p.getCarreau('d'),1,4);
		assertTrue(t4==TypeErreur.REPOS_BASE);
		TypeErreur t5 = m.placerCarreau(p.getCarreau('e'), 5, 1);
		assertTrue(t5==TypeErreur.NON_CONTACT);
	}

}
