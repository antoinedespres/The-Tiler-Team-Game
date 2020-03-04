import java.util.*;

public class PaquetCarreau {

  private ArrayList<Carreau> tasCarreau;

  private final int COTEMAXCARREAU = 3;

  private final char lettres[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' };
  private final int dim[][] = { { 1, 1, 2, 2, 1, 3, 2, 3, 3 }, { 1, 2, 1, 2, 3, 1, 3, 2, 3 } };

  /*
   * Constructeur de PaquetCarreau
   *
   * @param remplir Booléen permettant de choisir de remplir ou non le paquet
   */
  public PaquetCarreau(boolean remplir) {
    tasCarreau = new ArrayList<>();
    if (remplir) {
      this.remplirPaquet();
    }
  }

  public int size(){
    return this.tasCarreau.size();
  }

  public void retirerCarreau(char lettre) {
    for (int i = 0; i < this.tasCarreau.size(); i++) {
      if (this.tasCarreau.get(i).getLettre() == lettre) {
        this.tasCarreau.remove(i);
        return;
      }
    }
    System.err.println("Le carreau n'as pas été trouvé");
  }

  /**
   * Remplissage d'un paquet de carreaux
   */
  private void remplirPaquet() {
    boolean rouge = false;
    for (int j = 0; j < 2; ++j) {
      int k = 0;
      for (char i : lettres) {
        tasCarreau.add(new Carreau(dim[0][k], dim[1][k], i, rouge));
        k++;
      }
      rouge = true;
    }
  }

  /**
   * Affichage des carreaux pouvant être joués avec la carte tirée
   *
   * @param carteTiree la carte tirée
   */
  public PaquetCarreau carreauDispo(Carte carteTiree) {
    PaquetCarreau carreauDispo = new PaquetCarreau(false);
    switch (carteTiree.getTypeCarte()) {
    case BLEU:
      for (Carreau i : this.tasCarreau) {
        if (Character.isLowerCase(i.getLettre()))
          carreauDispo.tasCarreau.add(i);
      }
      break;
    case ROUGE:
      for (Carreau i : this.tasCarreau) {
        if (Character.isUpperCase(i.getLettre()))
          carreauDispo.tasCarreau.add(i);
      }
      break;
    case TAILLE1:
      for (Carreau i : this.tasCarreau) {
        if (i.getHauteur() == 1 || i.getLargeur() == 1)
          carreauDispo.tasCarreau.add(i);
      }
      break;
    case TAILLE2:
      for (Carreau i : this.tasCarreau) {
        if (i.getHauteur() == 2 || i.getLargeur() == 2)
          carreauDispo.tasCarreau.add(i);
      }
      break;
    case TAILLE3:
      for (Carreau i : this.tasCarreau) {
        if (i.getHauteur() == 3 || i.getLargeur() == 3)
          carreauDispo.tasCarreau.add(i);
      }
      break;
    }
    return carreauDispo;
  }

  public Carreau getCarreau(char lettre) {
    for (int i = 0; i < this.tasCarreau.size(); i++) {
      if (this.tasCarreau.get(i).getLettre() == lettre) {
        return this.tasCarreau.get(i);
      }
    }
    return (new Carreau(1, 1, 'z', true));
  }

  public ArrayList getPaquetCarreau() {
    return tasCarreau;
  }

  private int LargeurCarreaux(){
    int res = 0;
    for(Carreau i: this.tasCarreau){
      res+= i.getLargeur();
    }
    return res;
  }

  public String toString() {
    int largeurPris = 0;
    char[][] tab = new char[COTEMAXCARREAU][this.LargeurCarreaux()];
    for(int i = 0; i<COTEMAXCARREAU; i++){
      for (int j = 0; j<this.LargeurCarreaux(); j++){
        tab[i][j] = ' ';
      }
    }
    for (Carreau i : this.tasCarreau) {
      for (int j = 0; j < i.getHauteur(); j++) {
        for (int k = 0; k < i.getLargeur(); k++) {
          tab[tab.length - 1 - j][k + largeurPris] = i.getLettre();
        }
      }
      largeurPris += i.getLargeur();
    }
    String s = new String();
    for (int i = 0; i < COTEMAXCARREAU; ++i) {
      char derCarac = ' ';
      boolean prem = true;
      for (int j = 0; j < tab[0].length; j++) {
        if (!(derCarac == tab[tab.length - 1][j]) && !prem) {
          s += ' ';
        }
        s += tab[i][j];
        s += ' ';

        prem = false;
        derCarac = tab[tab.length - 1][j];
      }
      s += '\n';
    }
    return s;
  }

  public boolean estVide(){
    return this.tasCarreau.isEmpty();
  }
}