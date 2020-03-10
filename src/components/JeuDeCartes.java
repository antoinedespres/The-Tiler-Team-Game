package components;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe JeuDeCartes.
 * 
 * @author Antoine Després
 * @author Thibault Henrion
 * @version 1.0
 */
public class JeuDeCartes {
	public static final int NBCARTES = 33;
	public static final int NBCARTESPARCOULEUR = 9;
	public static final int NBCOULEURS = 2;
	public static final int NBCARTESPARTAILLE = 5;
	public static final int NBTAILLES = 3;

	private ArrayList<Carte> listeCartes;

	/**
	 * Constructeur de jeu de cartes
	 */
	public JeuDeCartes() {
		listeCartes = new ArrayList<>();

		this.remplirPaquet();

		this.mélangerPaquet();
	}

	/**
	 * Remplissage du paquet de cartes
	 */
	private void remplirPaquet() {
		int i = 0;
		for (; i < NBCARTESPARCOULEUR; ++i)
			this.listeCartes.add(new Carte(TypeCarte.BLEU));
		for (; i < NBCARTESPARCOULEUR * NBCOULEURS; ++i)
			this.listeCartes.add(new Carte(TypeCarte.ROUGE));
		for (; i < NBCARTESPARCOULEUR * NBCOULEURS + NBCARTESPARTAILLE; ++i)
			this.listeCartes.add(new Carte(TypeCarte.TAILLE1));
		for (; i < NBCARTESPARCOULEUR * NBCOULEURS + NBCARTESPARTAILLE + NBCARTESPARTAILLE; ++i)
			this.listeCartes.add(new Carte(TypeCarte.TAILLE2));
		for (; i < NBCARTES; ++i)
			this.listeCartes.add(new Carte(TypeCarte.TAILLE3));
	}

	/**
	 * Tire une carte du paquet
	 *
	 * @return carteTirée : la carte tirée
	 */
	public Carte tirerCarte() {
		Carte carteTirée = getJeuCartes().get(getJeuCartes().size() - 1);
		getJeuCartes().remove(getJeuCartes().size() - 1); // on ne la remet pas dans le paquet
		return carteTirée;
	}

	/**
	 * Vérifie si le paquet est vide
	 *
	 * @return true si paquet vide, false sinon
	 */
	public boolean estVide() {
		return this.getJeuCartes().isEmpty();
	}

	/**
	 * Vide le paquet de cartes
	 */
	public void viderPaquet() {
		this.getJeuCartes().clear();
	}

	/**
	 * Mélange le paquet de cartes
	 */
	public void mélangerPaquet() {
		assert (!this.estVide());
		Collections.shuffle(this.getJeuCartes());
	}

	/**
	 * Ajoute une carte en haut du paquet
	 *
	 * @param newCarte La Carte à insérer dans le jeu de cartes
	 */
	public void insererCarte(Carte newCarte) {
		getJeuCartes().add(getJeuCartes().size() - 1, newCarte);
	}

	/**
	 * Accesseur du jeu de cartes
	 * 
	 * @return listeCartes le jeu de cartes
	 */
	public ArrayList<Carte> getJeuCartes() {
		return listeCartes;
	}
}