
public class Carreau {
	private byte l;
	private byte h;
	private char lettre;
	private couleur clr;
	
	public enum couleur{BLEU, ROUGE};
	
	/**
	 * Constructeur de carreau.
	 * @param pLargeur Largeur du carreau
	 * @param pHauteur Hauteur du carreau
	 * @param pCouleur Couleur du carreau
	 */
	public Carreau(byte pLargeur, byte pHauteur, Carreau.couleur pCouleur)
	  {
	    l = pLargeur;
	    h= pHauteur;
	    clr=pCouleur;
	  }        
}
