import java.util.*;

public class Mur {
  private static final int NBPIECENEUTRE = 2;
  private static final char LETTREPIECENEUTRE = 'x';
  private static final Carreau PIECENEUTRE1 = new Carreau(1, 3, LETTREPIECENEUTRE, false);//piece verticale
  private static final int[] POSPIECENEUTRE1 = {1, 5};
  private static final Carreau PIECENEUTRE2 = new Carreau(3, 1, LETTREPIECENEUTRE, false);// piece horizontale
  private static final int[] POSPIECENEUTRE2 = {1, 3};
  /**
    les axes sont en base 10
  */
  private static final int BASEAXES = 10;

  // La largeur du mur est constante et définie à 5 unités.
  private final static int LARGEUR = 5;
  // Nombre de cotés sur un carreau
  private final static int COTECARREAU = 2;

  // Tableau de caractères à deux dimensions.
  private ArrayList<Character>[] mur = new ArrayList[LARGEUR];

  public Mur() {
    for (int i = 0; i < LARGEUR; i++) {
      this.mur[i] = new ArrayList<Character>();
    }
    this.placerPieceNeutre();
  }

  private void placerPieceNeutre(){
    Random piece = new Random();
    Random position = new Random();
    if(piece.nextInt(NBPIECENEUTRE) == 0){
      this.placerCarreau(PIECENEUTRE1, POSPIECENEUTRE1[position.nextInt(2)], 1);
    }
    else{
      this.placerCarreau(PIECENEUTRE2, POSPIECENEUTRE2[position.nextInt(2)], 1);
    }
  }

  public int getHauteurMax() {
    int hauteurMax = 0;
    for (ArrayList<Character> i : mur) {
      if (i.size() >= hauteurMax)
        hauteurMax = i.size();
    }
    return hauteurMax;
  }

    public int getHauteurMin() {
    int hauteurMin = this.mur[0].size();
    for (ArrayList<Character> i : mur) {
      if (i.size() <= hauteurMin)
        hauteurMin = i.size();
    }
    return hauteurMin;
  }

  /**
   * Affiche le mur complet avec coordonnées.
   * 
   * @return s La chaîne de caractères contenant le mur
   */
  public String toString() {
    String s = "";
    for (int i = this.getHauteurMax(); i >= 0; --i) {
      if(this.getHauteurMax()>BASEAXES && i+1<BASEAXES){//pour éviter un décalage à partir de la ligne 10
        s+= ' ';
      }
      s +=i+1;
      s += ' ';
      for (int j = 0; j < LARGEUR; j++) {
        if (i < this.mur[j].size()) {
          s += this.mur[j].get(i);
        } else {
          s += ' ';
        }
        s += ' ';
      }
      s += '\n';
    }
    if(this.getHauteurMax()>BASEAXES)
      s += "   1 2 3 4 5";
    else
      s += "  1 2 3 4 5";
    return s;
  }

  /**
   * Place un carreau sur le {@link Mur}
   *
   * @param c     Le carreau
   * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
   * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
   * @param m     Le {@link Mur}
   */
  public boolean placerCarreau(Carreau c, int absBG, int ordBG) {
    absBG--;
    ordBG--;
    if (this.placementCorrect(c, absBG, ordBG)|| c.getLettre() == LETTREPIECENEUTRE) {
      for (int i = absBG; i < absBG + c.getLargeur(); i++) {
        for (int j = 0; j < c.getHauteur(); j++) {
          this.mur[i].add(c.getLettre());
        }
      }
      return true;
    }
    return false;
  }

  /**
   * Vérifie si le placement de carreau est correct
   *
   * @param c Le {@link Carreau}
   * @param m Le {@link Mur}
   * @return True si le placement est correct, false sinon
   */
  private boolean placementCorrect(Carreau c, int absBG, int ordBG) {// absBG doit être utilisé de 0 à 4; ordBG
    // de 0 à x
    // On ne fait pas un ET entre toutes les méthodes car si la première est à
    // false, toutes les suivantes ne seront pas exécutées.
    boolean dépasse = dépasse(c, absBG, ordBG);
    boolean touche = this.touche(c, absBG, ordBG);
    boolean baseRepose = baseRepose(c,absBG,ordBG);
    boolean cloneBord = this.cloneBord(c, absBG, ordBG);
    return (!dépasse && touche && baseRepose && !cloneBord);
  }

  /**
   * Vérifie si le carreau dépasse de la zone à carreler
   *
   * @param c     Le {@link Carreau}
   * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
   * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
   * @param m     Le {@link Mur}
   */
  private boolean dépasse(Carreau c, int absBG, int ordBG) {
    if (absBG + c.getLargeur() < LARGEUR && absBG >= 0 && ordBG >= 0) {
      return true;
    }
    System.err.println("Le carreau dépasse de la zone à carreler");
    return false;
  }

  /**
   * Vérifie si le carreau touche un autre carreau et repose sur une base stable
   *
   * @param c Le {@link Carreau}
   * @param m Le {@link Mur}
   */

  private boolean touche(Carreau c, int absBG, int ordBG) {
    if (baseRepose(c, absBG, ordBG))
        return true;
    if(ordBG==0){
      boolean touche = false;
      for (int i = -1; i < COTECARREAU; i += 2) {
        if (this.mur[absBG + i].size() >= ordBG) {
          touche = true;
        }
      }
      if (!touche) {
        System.err.println("Le carreau ne touche pas un carreau déjà posé");
        return false;
      }
    }
    return true;
  }

  /**
   * Vérifie si le carreau dépasse de la zone à carreler
   *
   * @param c     Le {@link Carreau}
   * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
   * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
   * @param m     Le {@link Mur}
   */
  private boolean baseRepose(Carreau c, int absBG, int ordBG) {
   for (int i = 0; i < c.getLargeur(); i++) {
      if (this.mur[absBG + i].size() != ordBG) {
        System.err.println("Toute la base ne repose pas soit sur le bas de la zone à carreler soit sur d'autres cartons.");
        return false;
      }
   }
    return true;
  }

  /**
   * @param c Le Carreau
   * @return True si le nouveau carreau clone son bord inférieur, false sinon
   */
  private boolean cloneBord(Carreau c, int absBG, int ordBG) {
    
    return false;
    
    
    
    // if (m.mur[absBG - 1][ordBG].equals()) {
    //return true;
    // }
    // System.err.println("Le carreau clone un carreau déjà posé.");
  }
}
