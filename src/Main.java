import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static boolean stop = false;

  public static void main(String[] args) {
    System.out.println("=== Bienvenue dans le jeu The Tiler Team ! ===");
    Mur m = new Mur();
    PaquetCarreau p = new PaquetCarreau(true);
    JeuDeCartes j = new JeuDeCartes();
    Score s = new Score(0, 0, JeuDeCartes.NBCARTES, 0);
    Scanner sc = new Scanner(System.in);
    int noJoueur = 1;

    do {
      System.out.println('\n' + m.toString());
      Carte carteTirée = j.tirerCarte();
      System.out.println(System.lineSeparator() + "Joueur " + noJoueur + ", la carte tirée est : " + carteTirée.getTypeCarte());
      PaquetCarreau pTrié = p.carreauDispo(carteTirée);
      if(!pTrié.estVide()){
        System.out.println(pTrié.toString());
      }

      appelCommande(sc, m, carteTirée, p, s, pTrié.estVide());
      noJoueur++;
      if (noJoueur > 2)
        noJoueur = 1;
    } while (!estTerminee(j, p, stop));

  System.out.println(s.toString(s, p, m));
  }

  /**
   * Vérifie si la partie est terminée ou non
   *
   * @param j    Le jeu de carte
   * @param p    Le Paquet de carreaux
   * @param stop La condition stop entrée ar le joueur
   * @return true si la partie est terminée, false sinon
   */
  public static boolean estTerminee(JeuDeCartes j, PaquetCarreau p, boolean stop) {
    return j.getTasCartes().size() == 0 || p.getPaquetCarreau().size() == 0 || stop == true;
  }

  /**
   * Lit la commande saisie par un joueur et l'envoie à un switch
   * 
   * @param carteTirée La carte tirée
   * @param s          Le score de la partie
   */
  public static void appelCommande(Scanner sc, Mur m, Carte CarteTirée, PaquetCarreau p, Score s, boolean AucunCarreau) {
    String mot = "";
    if(AucunCarreau)
      mot = "next";
    else
      mot = sc.next();
    switch (mot) {
      case "next":
        s.écarter();
        break;
      case "stop":
        stop=true;
        break;
      default:
        if (mot.length() > 1) {
          System.err.println("Saisie incorrecte. Ne correspond ni à une instruction ni à une lettre.");
          appelCommande(sc, m, CarteTirée, p, s, false);
        } else {
          boolean estPosée;
          int absBG = sc.nextInt();
          int ordBG = sc.nextInt();
          Carreau c = p.getCarreau(mot.charAt(0));
          estPosée = m.placerCarreau(c, absBG, ordBG);
          if(!estPosée){
            appelCommande(sc, m, CarteTirée, p, s, false);
          }
          p.retirerCarreau(mot.charAt(0));
        }
        // placement d'un carreau
        // on doit s'assurer que la première saisie correspond aux possibilités
        // on envoie cette lettre à une autre méthode qui recueillera par deux Scanner
        // les coordonnées absBG et ordBG
        // cette autre méthode appellera enfin le placement du carreau sur le mur
    }
  }
}