import java.util.ArrayList;
import java.util.Collections;

public class JeuDeCartes {
  private static final int NBCARTESTOT = 33;
  private static final int NBCARTESCOULEUR = 9;
  private static final int NBCARTESCOULEURTOT = 18;
  private static final int NBCARTESTAILLE = 5;

interface typeCarte {
	enum COULEUR implements typeCarte {BLEU, ROUGE; }
    
    enum TAILLE implements typeCarte {T1, T2, T3; }
}
  

  private ArrayList<typeCarte> tasCartes;

  public JeuDeCartes() {
    tasCartes = new ArrayList<>();

    this.remplirPaquet();

    this.mélangerPaquet();
  }

  public void remplirPaquet() {
    int i = 0;
    for (; i < NBCARTESCOULEUR; ++i) {
      this.tasCartes.add(typeCarte.COULEUR.BLEU);
    }
    for (; i < NBCARTESCOULEURTOT; ++i) {
      this.tasCartes.add(typeCarte.COULEUR.ROUGE);
    }
    for (; i < (NBCARTESCOULEURTOT + NBCARTESTAILLE); ++i) {
      this.tasCartes.add(typeCarte.TAILLE.T1);
    }
    for (; i < (NBCARTESCOULEURTOT + NBCARTESTAILLE + NBCARTESTAILLE); ++i) {
      this.tasCartes.add(typeCarte.TAILLE.T2);
    }
    for (; i < NBCARTESTOT; ++i) {
      this.tasCartes.add(typeCarte.TAILLE.T3);
    }
  }

  /*
   * public typeCarte gettypeCarte(){ return this.typeCarte; }
   */

  public typeCarte tirerCarte() {
    typeCarte carteTirée = tasCartes.get(tasCartes.size() - 1);
    tasCartes.remove(tasCartes.size() - 1);
    return carteTirée;
  }

  public void viderPaquet() {
    this.tasCartes.clear();
  }

  public void mélangerPaquet() {
    Collections.shuffle(this.tasCartes);
  }

  public void insererCarte(typeCarte newCarte) {
    tasCartes.add(tasCartes.size() - 1, newCarte);
  }
}
// créer une fct getTypeCarte pour la fonction afficher carte dispo dans
// Carreau.java