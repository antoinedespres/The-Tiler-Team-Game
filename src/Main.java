
public class Main {

	public static void main(String[] args) {
		System.out.println("=== Bienvenue dans le jeu The Tiler Team ! ===");
		Mur m = new Mur();
		Score s = new Score();
		do {
			/*
			 * Message de bienvenue
			 * Tirer une carte
			 * Afficher cartes correspondantes (sinon enlever 1 point et tirer une autre)
			 * Saisir next pour changer de carte (-1 pt) ou stop pour arrêter de jouer, ou les coordonnées séparées
			 * Afficher à nouveau le mur, qui inclut  cette fois la nouvelle case
			 * tout cela tant qu'il y a des cartes ou que l'on entre pas STOP
			 */
			
		} while(!FctJeu.estTerminee(m));
  
  System.out.println();
	}

}