import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Bienvenue dans le jeu The Tiler Team ! ===");
        Mur m = new Mur();
        JeuDeCartes j = new JeuDeCartes();
        Score s = new Score(0, 0, 33, 0);
        int noJoueur = 1;
        do {
        	System.out.println("Joueur "+noJoueur+", la carte tirée est : "+ tc);
        	afficherCartesDispo(Carte c);
        	saisie();
        	noJoueur++;
        	if(noJoueur>2) noJoueur=1;
        } while (!estTerminee(m));
        
        System.out.println(s.toString(s));
    }
 
  private final char lettres[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
  private final int dim[][] = {{1,1,2,2,1,3,2,3,3},{1,2,1,2,3,1,3,2,3}};

  /**
   * Vérifie si la partie est terminée ou non
   * 
   * @param m Le mur
   * @return true si la partie est terminée, false sinon
   */
  public static boolean estTerminee(Mur m, Score s) {
    return j.tasCartes.length==00||s.getNonPose.equals(0);
  }

  /**
  * Crée une {@link java.util.ArrayList} contenant tous les carreaux
  */
  public void déclarerCarreaux(){
    ArrayList<Carreau> listeCar= new ArrayList<>();
    for (int i:lettres){
      listeCar.add(new Carreau(dim[0][i], dim[1][i],lettres[i], false));
    }
    for (int i:lettres){
      listeCar.add(new Carreau(dim[0][i], dim[1][i],lettres[i], false));
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