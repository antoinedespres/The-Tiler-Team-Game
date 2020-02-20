public class Mur {

  /**
   * La largeur du mur est constante et définie à 5 unités.
   */
  private final static int LARGEUR = 5;

  /**
   * Tableau de caractères à deux dimensions.
   */
  char[][] mur;

  /**
   * La hauteur varie avec l'empilage de carreaux.
   */
  int hauteur = 5;

  public int getLargeur() {//a compléter
    return LARGEUR;
  }

  /**
   * Affiche le mur complet avec coordonnées.
   * 
   * @param m Le mur
   */
  public void afficherMur() {
    for (int i = mur.length; i >= 0; --i) {
      System.out.print(Integer.toString(i));
      for (int j = 0; j < this.getLargeur(); ++j) {
        // System.out.println((m.largeur-j)+m[i][j]);
      }
    }
    System.out.print(" ");
    for (int k = 1; k < m.getLargeur(); k++) {
      System.out.print(k);
    }
    System.out.println("");
  }

  public void placerCarreau(Mur m,Carreau c, int absBG, int ordBG) {
	  
  }
}
