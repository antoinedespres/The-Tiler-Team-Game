import java.util.Scanner;

public class FctJeu {
	public static void debutPartie(Mur m) {
      //  Carreau a=new Carreau(1,2,BLEU);
}
	/**
	 * Vérifie si la partie est terminée ou non
	 * @param m Le mur
	 * @return true si la partie est terminée, false sinon
	 */
	public static boolean estTerminee(Mur m) {
       /* if(nbCartes == 0 || nbCarr==0) {
        	afficherScore(m);
        	return true;
        }*/
        return false;
	}
	
	/**
	 * Lit la commande saisie par un joueur et l'envoie à un switch
	 */
	public static void saisie() {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	    String mot = sc.nextLine();
	    appelCommande(mot);
	}
	
	/**
	 * Switch appelant la fonction correspondant à la commande
	 * @param mot Le mot saisi
	 */
	public static void appelCommande(String mot) {
		switch(mot) {
		case "next":
			//ecarter(carteEnJeu);
			break;
		case "stop":
			//afficherScore(m);
			break;
		default:
			saisie();
		}
	}
	
	/**
	 * Affiche la phrase détaillant le score atteint
	 * @param m le mur
	 */
	public static void afficherScore(Mur m) {
		byte pts;
		byte nivComplets;
		byte nonPose;
		byte carteEcartee;
		
		//System.out.println(pts + "points ("+nivComplets+" niveaux complets, "+nonPose + "carreaux non posés, " + carteEcartee + " cartes écartées)");
	}

}