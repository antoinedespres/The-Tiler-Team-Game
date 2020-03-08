/**
 * Classe Carte.
 * 
 * @author Antoine Després
 * @author Thibault Henrion
 * @version 1.0
 */
public class Carte {

	/**
	 * Une carte est caractérisée seulement par le type de carreau qu'elle oblige à
	 * jouer (taille ou couleur)
	 */
	private TypeCarte tc;

	/**
	 * Constructeur de carte
	 * 
	 * @param tc le type de carte
	 */
	public Carte(TypeCarte tc) {
		this.tc = tc;
	}

	/**
	 * Accesseur de type de carte
	 * 
	 * @return tc le type de carte
	 */
	public TypeCarte getTypeCarte() {
		return this.tc;
	}
}