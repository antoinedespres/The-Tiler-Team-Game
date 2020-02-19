import java.util.Scanner;

import JeuDeCartes.typeCarte;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Bienvenue dans le jeu The Tiler Team ! ===");
        Mur m = new Mur();
        JeuDeCartes j = new JeuDeCartes();
        Score s = new Score(0, 0, 33, 0);
        do {
          System.out.println("");

        } while (!estTerminee(m));
        
        System.out.println(s.toString(s));
    }
  /**
 * Classe regroupant les fonctions liées à l'exécution générale du programme
 */
  public void debutPartie(Mur m) {
    // Carreau a=new Carreau(1,2,BLEU);
  }
  private final char lettres[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
  private final int dim[][] = {{1,1,2,2,1,3,2,3,3},{1,2,1,2,3,1,3,2,3}};

  /**
   * Vérifie si la partie est terminée ou non
   * 
   * @param m Le mur
   * @return true si la partie est terminée, false sinon
   */
  public static boolean estTerminee(Mur m) {
    return j.tasCartes.length;
  }

  /**
  * Crée une {@link java.util.ArrayList} contenant tous les carreaux
  */
  public void déclarerCarreaux(){
    Arraylist<Carreau> listeCar= new ArrayList<>();
    for (int i:lettres){
      listeCar.add(Carreau = new Carreau(lettres[i], dim[0][i], dim[1][i], false));
    }
    for (int i:lettres){
      listeCar.add(Carreau = new Carreau(lettres[i], dim[0][i], dim[1][i], true));
    }
  }
  /**
   * Lit la commande saisie par un joueur et l'envoie à un switch
   */
  public void saisie() {
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
    String mot = sc.nextLine();
    appelCommande(mot);
    sc.close();
  }

  /**
   * Switch appelant la fonction correspondant à la commande
   * 
   * @param mot Le mot saisi
   */
  public void appelCommande(String mot) {
    switch (mot) {
    case "next":
      // ecarter(carteEnJeu);
      break;
    case "stop":
      // afficherScore(m);
      break;
    default:
      saisie();
    }
  }
}