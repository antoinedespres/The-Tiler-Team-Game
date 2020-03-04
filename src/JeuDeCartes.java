import java.util.ArrayList;
import java.util.Collections;

public class JeuDeCartes {
  public static final int NBCARTES = 33;
  public static final int NBCARTESPARCOULEUR = 9;
  public static final int NBCOULEURS = 2;
  public static final int NBCARTESPARTAILLE = 5;
  public static final int NBTAILLES = 3;

  private ArrayList<Carte> tasCartes;

  public JeuDeCartes() {
    tasCartes = new ArrayList<>();

    this.remplirPaquet();

    this.mélangerPaquet();
  }

  /**
   * Remplissage du paquet de cartes
   */
  private void remplirPaquet() {
    int i = 0;
    for (; i < NBCARTESPARCOULEUR; ++i)
      this.tasCartes.add(new Carte(Carte.typeCarte.BLEU));
    for (; i < NBCARTESPARCOULEUR * NBCOULEURS; ++i)
      this.tasCartes.add(new Carte(Carte.typeCarte.ROUGE));
    for (; i < NBCARTESPARCOULEUR * NBCOULEURS + NBCARTESPARTAILLE; ++i)
      this.tasCartes.add(new Carte(Carte.typeCarte.TAILLE1));
    for (; i < NBCARTESPARCOULEUR * NBCOULEURS + NBCARTESPARTAILLE + NBCARTESPARTAILLE; ++i)
      this.tasCartes.add(new Carte(Carte.typeCarte.TAILLE2));
    for (; i < NBCARTES; ++i)
      this.tasCartes.add(new Carte(Carte.typeCarte.TAILLE3));
  }

  /**
   * Tire une carte du paquet
   * 
   * @return carteTirée : la carte tirée
   */
  public Carte tirerCarte() {
    Carte carteTirée = getTasCartes().get(getTasCartes().size() - 1);
    getTasCartes().remove(getTasCartes().size() - 1);
    return carteTirée;
  }

  // public Carte tirerCarte() {
  // Carte carteTirée = getTasCartes().get(getTasCartes().size() - 1);
  // getTasCartes().remove(getTasCartes().size() - 1);
  // return carteTirée;
  // }

  /**
   * vérifie si le paquet est vide
   * 
   * @return true si paquet vide
   */
  public boolean estVide() {
    return this.getTasCartes().isEmpty();
  }

  /**
   * Vide le paquet de carte
   */
  public void viderPaquet() {
    this.getTasCartes().clear();
  }

  /**
   * Mélange le paquet de carte
   */
  public void mélangerPaquet() {
    assert (!this.estVide());
    Collections.shuffle(this.getTasCartes());
  }

  /**
   * Ajoute une carte en haut du paquet
   * 
   * @param newCarte La Carte à insérer dans le jeu de cartes
   */
  public void insererCarte(Carte newCarte) {
    getTasCartes().add(getTasCartes().size() - 1, newCarte);
  }

  public ArrayList<Carte> getTasCartes() {
    return tasCartes;
  }
}
//