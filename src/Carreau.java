
public class Carreau {
	byte l;
	byte h;
	char lettre;
	couleur couleur;
	
	public enum couleur{BLEU, ROUGE};
	public Carreau(byte pLargeur, byte pHauteur, Carreau.couleur pCouleur)
	  {
	    l = pLargeur;
	    h= pHauteur;
	    couleur=Carreau.couleur pCouleur;
	  }        
}
