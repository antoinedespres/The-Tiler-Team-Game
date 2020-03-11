package Appli;

import static org.junit.Assert.*;

import org.junit.Test;

import components.JeuDeCartes;
import components.ListeCarreaux;

public class FctJeuTest {

	@Test
	public void test() {
		// test des conditions de fin de partie
		ListeCarreaux p = new ListeCarreaux(true); // plein
		ListeCarreaux q = new ListeCarreaux(false); // vide
		JeuDeCartes j = new JeuDeCartes();

		assertTrue(FctJeu.estTerminee(j, p, true));
		assertTrue(FctJeu.estTerminee(j, q, false));
		assertFalse(FctJeu.estTerminee(j, p, false));
	}

}
