/**
 * Classe Carreau. Un carreau est caractérisé par une largeur, une hauteur et
 * une lettre.
 *
 * @author Antoine Després
 * @author Thibault Henrion
 * @version 1.0
 */
public class Carreau {
	private int largeur;
	private int hauteur;
	private char lettre;

	/**
	 * Constructeur de carreau
	 *
	 * @param pLargeur Largeur du carreau
	 * @param pHauteur Hauteur du carreau
	 * @param pLettre  Lettre du carreau
	 * @param pRouge   Booléen définissant si le carreau doit être rouge ou non
	 */
	public Carreau(int pLargeur, int pHauteur, char pLettre, boolean pRouge) {
		assert (pLargeur >= 1 && pLargeur <= 3);
		assert (pHauteur >= 1 && pHauteur <= 3);

		if (pRouge) {
			pLettre = Character.toUpperCase(pLettre);
		}
		this.largeur = pLargeur;
		this.hauteur = pHauteur;
		this.lettre = pLettre;
	}

	/**
	 * Accesseur de la largeur d'un carreau
	 *
	 * @return largeur La largeur du carreau
	 */
	public int getLargeur() {
		return this.largeur;
	}

	/**
	 * Accesseur de la hauteur d'un carreau
	 *
	 * @return hauteur La hauteur du carreau
	 */
	public int getHauteur() {
		return this.hauteur;
	}

	/**
	 * Accesseur de la lettre d'un carreau
	 *
	 * @return lettre La lettre du carreau
	 */
	public char getLettre() {
		return this.lettre;
	}

	/**
	 * Vérifie si un carreau est rouge. Pour cela, on vérifie si la lettre du
	 * carreau est en majuscule.
	 *
	 * @return True si le carreau est rouge, false sinon
	 */
	public boolean estRouge() {
		return Character.isUpperCase(this.lettre);
	}

}
