import java.util.ArrayList;
import java.util.Collections;

public class JeuDeCartes {
  private static final int NBCARTES = 33;
  private static final int NBCARTESPARCOULEUR = 9;
  private static final int NBCOULEURS=2;
  private static final int NBCARTESPARTAILLE = 5;
  private static final int NBTAILLES=3;

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
    for (; i < NBCARTESPARCOULEUR; ++i) {
      this.getTasCartes().add(new Carte(Carte.typeCarte.BLEU));
    }
    for (; i < NBCARTESPARCOULEUR*NBCOULEURS; ++i) {
      this.getTasCartes().add(new Carte(Carte.typeCarte.ROUGE));
    }
    for (; i < (i + NBCARTESPARTAILLE); ++i) {
      this.getTasCartes().add(new Carte(Carte.typeCarte.TAILLE1));
    }
    for (; i < (i+NBCARTESPARTAILLE); ++i) {
      this.getTasCartes().add(new Carte(Carte.typeCarte.TAILLE2));
    }
    for (; i < NBCARTES; ++i) {
      this.getTasCartes().add(new Carte(Carte.typeCarte.TAILLE3));
    }
  }
  
  /**
  *Tire une carte du paquet
  *@return carteTirée : la carte tirée
  */
  public Carte tirerCarte() {
    Carte carteTirée = getTasCartes().get(getTasCartes().size() - 1);
    getTasCartes().remove(getTasCartes().size() - 1);
    return carteTirée;
  }


  /**
  *vérifie si le paquet est vide
  *@return true si paquet vide
  */
  public boolean estVide(){
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
    assert(!this.estVide());
    Collections.shuffle(this.getTasCartes());
  }

  /**
  * Ajoute une carte en haut du paquet
  * @param newCarte La Carte à insérer dans le jeu de cartes
  */
  public void insererCarte(Carte newCarte) {
    getTasCartes().add(getTasCartes().size() - 1, newCarte);
  }

  /**
  * Incrémente le compteur de cartes écartées
  * 
  */
  public void écarter(Score s){
    s.incrementer("carteÉcartée");
  }

  public ArrayList<Carte> getTasCartes() {
	return tasCartes;
  }
}
// 