
public class Carreau {
	private int largeur;
	private int hauteur;
	private char lettre;
	
	public enum couleur{BLEU, ROUGE};
	
	/**
	 * Constructeur de carreau.
	 * @param pLargeur Largeur du carreau
	 * @param pHauteur Hauteur du carreau
	 * @param pCouleur Couleur du carreau
	 */
	public Carreau(int pLargeur, int pHauteur, char pLettre) {
	    largeur = pLargeur;
	    hauteur = pHauteur;
        lettre = pLettre;
	  }

   //fonction afficher qui prend en param le type de carte et utilise un tableau 2D pour les afficher horizontalement
   //pour toutes case du tab empty, inserer un espace.
   //crÃ©er une fct dans Carte pour recup type carte.
  
  public void afficherCartesRest(){

  }

  public int getLargeur(){
    return largeur;
  }

  public int getHauteur(){
    return hauteur;
  }

  public void placerCarreau(Carreau c, int absBG, int ordBG, Mur m){
    if(placementCorrect(c,m)){

    }
    else saisie();
  }

  private boolean placementCorrect(Carreau c, Mur m){
    return (!dépasse(c,m) && touche(c,m) && baseRepose(c,m) && !cloneBord(c,m));
  }

  private boolean dépasse(Carreau c, int absBG, int ordBG, Mur m){
    return absBG+c.largeur< m.getLargeur();
  }

  private boolean touche(Carreau c, Mur m){
    return;
  }

  private boolean baseRepose(Carreau c, Mur m){

  }

  private boolean cloneBord(Carreau c, int absBG, int ordBG, Mur m){
    return m.mur[absBG-1][ordBG].equals();
  }

}
