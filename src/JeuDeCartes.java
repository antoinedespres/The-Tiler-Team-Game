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

    this.m�langerPaquet();
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
  *@return carteTir�e : la carte tir�e
  */
  public Carte tirerCarte() {
    Carte carteTir�e = getTasCartes().get(getTasCartes().size() - 1);
    getTasCartes().remove(getTasCartes().size() - 1);
    return carteTir�e;
  }


  /**
  *v�rifie si le paquet est vide
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
  * M�lange le paquet de carte
  */
  public void m�langerPaquet() {
    assert(!this.estVide());
    Collections.shuffle(this.getTasCartes());
  }

  /**
  * Ajoute une carte en haut du paquet
  * @param newCarte La Carte � ins�rer dans le jeu de cartes
  */
  public void insererCarte(Carte newCarte) {
    getTasCartes().add(getTasCartes().size() - 1, newCarte);
  }

  /**
  * Incr�mente le compteur de cartes �cart�es
  * 
  */
  public void �carter(Score s){
    s.incrementer("carte�cart�e");
  }

  public ArrayList<Carte> getTasCartes() {
	return tasCartes;
  }
}
// 