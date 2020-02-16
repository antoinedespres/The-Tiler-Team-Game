import java.util.Scanner;

/**
 * Classe regroupant les fonctions li�es à l'exécution g�n�rale du programme
 */
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
       //return nbCartes == 0 || nbCarr==0 || nbCartes==0;
	}
	
	/**
	 * Demande l'ajout au tableau 2D d'un carreau si il correspond aux indications de la carte
	 * @param c la carte
	 */
	/*public void gestionCarte(Carte c) {
		if(typeCarte=COULEUR) {
			for(int i=0; i<tasCartes.length;++i) {
				if(i.couleur=Couleur) {
					affichage.add(i);
				}
			}
		}
	}*/
	
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
	


}