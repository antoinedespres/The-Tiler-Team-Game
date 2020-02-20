import java.lang.*;

import javax.lang.model.util.ElementScanner6;

/**
 * Classe Carreau
 * Un carreau est caractérisé par une largeur, une hauteur et une lettre
 * @author Antoine Després, Thibault Henrion
 * @version 1.0
 */
public class Carreau {
  private int largeur;
  private int hauteur;
  private char lettre;
 

  /**
   * Constructeur de carreau
   * @param pLargeur Largeur du carreau
   * @param pHauteur Hauteur du carreau
   * @param pLettre Lettre du carreau
   * @param pRouge Booléen carreau rouge ou non
   */
  public Carreau(int pLargeur, int pHauteur, char pLettre, boolean pRouge) {
    if(pRouge){
      pLettre = Character.toUpperCase(pLettre);
    }
    largeur = pLargeur;
    hauteur = pHauteur;
    lettre = pLettre;
  }

  // fonction afficher qui prend en param le type de carte et utilise un tableau
  // 2D pour les afficher horizontalement
  // pour toutes case du tab empty, inserer un espace.
  // créer une fct dans Carte pour recup type carte.


  /**
  * Renvoie la largeur du carreau
  * @return largeur La largeur du carreau
  */
  public int getLargeur() {
    return largeur;
  }

  /**
  * Renvoie la hauteur du carreau
  * @return hauteur La hauteur du carreau
  */
  public int getHauteur() {
    return hauteur;
  }

  /**
  * Renvoie la lettre du carreau
  * @return lettre La lettre du carreau
  */
  public int getLettre() {
    return lettre;
  }

  /**
  * Vérifie si un carreau est rouge
  * Pour cela, on vérifie si la lettre du carreau est en majuscule.
  * @return True si le carreau est rouge, false sinon
  */
  public boolean estRouge(){
    return Character.isUpperCase(this.lettre);
  }

  /**
  * Place un carreau sur le {@link Mur}
  * @param c Le carreau
  * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
  * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
  * @param m Le {@link Mur}
  */
  public void placerCarreau(Carreau c, int absBG, int ordBG, Mur m) {
    if (placementCorrect(c, m)) {
    m.placerCarreau(c, absBG, ordBG);
    
    }
    else Main.saisie();
  }

  /**
  * Vérifie si le placement de carreau est correct
  * @param c Le {@link Carreau}
  * @param m Le {@link Mur}
  * @return True si le placement est correct, false sinon
  */
  private boolean placementCorrect(Carreau c, Mur m, int absBG, int ordBG) {
    // On ne fait pas un ET entre toutes les méthodes car si la première est à false, toutes les suivantes ne seront pas exécutées.
    boolean dépasse=dépasse(c, absBG, ordBG ,m);
    boolean touche=touche(c,m);
    boolean baseRepose = baseRepose(c,absBG, ordBG, m);
    boolean cloneBord = cloneBord(c, absBG, ordBG, m);
    return (!dépasse && touche && baseRepose && cloneBord);
  }

  /**
  * Vérifie si le carreau dépasse de la zone à carreler
  * @param c Le {@link Carreau}
  * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
  * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
  * @param m Le {@link Mur}
  */
  private boolean dépasse(Carreau c, int absBG, int ordBG, Mur m) {
    if(absBG + c.largeur < m.getLargeur()){
      return true;
    }
    System.err.println("Le carreau dépasse de la zone à carreler");
    return false;
  }

  /**
  * Vérifie si le carreau touche un autre carreau
  * @param c Le {@link Carreau}
  * @param m Le {@link Mur}
  */
  private boolean touche(Carreau c, Mur m) {
    if(1){
      return true;
    }

    System.err.println("Le carreau ne touche pas un carreau déjà posé");
    return false;
  }

  /**
  * Vérifie si le carreau dépasse de la zone à carreler
  * @param c Le {@link Carreau}
  * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
  * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
  * @param m Le {@link Mur}
  */
  private boolean baseRepose(Carreau c, int absBG, int ordBG, Mur m) {
    if(1){
      return true;
    }
    System.err.println("Toute la base du carreau ne repose pas sur le bas de la zone à carreler ou sue d'autres carreaux");
  }

  private boolean cloneBord(Carreau c, int absBG, int ordBG, Mur m) {
    if(m.mur[absBG - 1][ordBG].equals()){
      return true;
    }
    System.err.println("Le carreau clone un carreau déjà posé.");
  }
}
