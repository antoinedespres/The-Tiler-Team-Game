import java.util.Scanner;

/**
 * Classe regroupant les fonctions li�es � l'ex�cution g�n�rale du programme
 */
public class FctJeu {
	public static void debutPartie(Mur m) {
      //  Carreau a=new Carreau(1,2,BLEU);
}
	/**
	 * V�rifie si la partie est termin�e ou non
	 * @param m Le mur
	 * @return true si la partie est termin�e, false sinon
	 */
	public static boolean estTerminee(Mur m) {
       /* if(nbCartes == 0 || nbCarr==0) {
        	afficherScore(m);
        	return true;
        }*/
        return false;
	}
	
	/**
	 * Lit la commande saisie par un joueur et l'envoie � un switch
	 */
	public static void saisie() {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	    String mot = sc.nextLine();
	    appelCommande(mot);
	}
	
	/**
	 * Switch appelant la fonction correspondant � la commande
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
	 * Affiche la phrase d�taillant le score atteint
	 * @param m le mur
	 */
	public static String toString(Score s) {
		
		return pts + "points ("+nivComplets+" niveaux complets, "+nonPose + "carreaux non pos�s, " + carteEcartee + " cartes �cart�es)"
	}

}