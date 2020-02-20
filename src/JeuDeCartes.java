import java.util.ArrayList;
import java.util.Collections;

public class JeuDeCartes {
  private static final int NBCARTES = 33;
  private static final int NBCARTESCOULEUR = 9;
  private static final int NBCOULEURS=2;
  private static final int NBCARTESCOULEURTOT = 18;
  private static final int NBCARTESTAILLE = 5;

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
    for (; i < NBCARTESCOULEUR; ++i) {
      this.tasCartes.add(new Carte(Carte.typeCarte.BLEU));
    }
    for (; i < NBCARTESCOULEUR*NBCOULEURS; ++i) {
      this.tasCartes.add(new Carte(Carte.typeCarte.ROUGE));
    }
    for (; i < (i + NBCARTESTAILLE); ++i) {
      this.tasCartes.add(new Carte(Carte.typeCarte.TAILLE1));
    }
    for (; i < (NBCARTESCOULEURTOT + NBCARTESTAILLE + NBCARTESTAILLE); ++i) {
      this.tasCartes.add(new Carte(Carte.typeCarte.TAILLE2));
    }
    for (; i < NBCARTES; ++i) {
      this.tasCartes.add(new Carte(Carte.typeCarte.TAILLE3));
    }
  }
  
  /**
  *Tire une carte du paquet
  *@return carteTirée : la carte tirée
  */
  public Carte tirerCarte() {
    Carte carteTirée = tasCartes.get(tasCartes.size() - 1);
    tasCartes.remove(tasCartes.size() - 1);
    return carteTirée;
  }


  /**
  *vérifie si le paquet est vide
  *@return true si paquet vide
  */
  public boolean estVide(){
    return this.tasCartes.isEmpty();
  }
  
  /**
  * Vide le paquet de carte
  */
  public void viderPaquet() {
    this.tasCartes.clear();
  }

  /**
  * Mélange le paquet de carte
  */
  public void mélangerPaquet() {
    assert(!this.estVide());
    Collections.shuffle(this.tasCartes);
  }

  /**
  * Ajoute une carte en haut du paquet
  * @param newCarte La Carte à insérer dans le jeu de cartes
  */
  public void insererCarte(Carte newCarte) {
    tasCartes.add(tasCartes.size() - 1, newCarte);
  }

  /**
  * Incrémente le compteur de cartes écartées
  * 
  */
  public void écarterCarte(){
    Main.s.incrementer(carteEcartee);
  }
}
// créer une fct getTypeCarte pour la fonction afficher carte dispo dans
// Carreau.java