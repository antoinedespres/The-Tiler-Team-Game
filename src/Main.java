import java.util.Scanner;

/**
 * Classe Main.
 * 
 * @author Antoine Després
 * @author Thibault Henrion
 * @version 1.0
 */
public class Main {

	/**
	 * Booléen permettant d'arrêter la partie en saisissant la commande "stop"
	 */
	private static boolean stop = false;

	/**
	 * Contient le message d'erreur à traîter
	 */
	private static TypeErreur msgErreur = TypeErreur.CORRECT;

	public static void main(String[] args) {
		// System.out.println("=== Bienvenue dans le jeu The Tiler Team ! ==="); //
		// message de bienvenue
		Mur m = new Mur();
		ListeCarreaux p = new ListeCarreaux(true); // p pour ne pas confondre l et 1
		JeuDeCartes j = new JeuDeCartes();
		Score s = new Score();
		Scanner sc = new Scanner(System.in);

		do { // faire tant que la partie n'est pas terminée
			System.out.println(m.toString() + System.lineSeparator()); // afficher le mur
			Carte carteTirée = j.tirerCarte(); // tirer une carte
			System.out.println(carteTirée.getTypeCarte()+System.lineSeparator()); // afficher son instruction
			ListeCarreaux pTrié = p.carreauDispo(carteTirée); // accès aux carreaux jouables correspondant
			if (!pTrié.estVide()) { // affichage de ces derniers
				System.out.println(pTrié.toString());
			}
			do { // faire tant que la saisie n'est pas correcte
				FctJeu.appelCommande(sc, m, carteTirée, p, s, pTrié.estVide());
				System.err.print(msgErreur.toString()); // Affichage du message d'erreur si existant
			} while (msgErreur != TypeErreur.CORRECT);
		} while (!FctJeu.estTerminee(j, p, stop));

		System.out.println(s.toString(s, p, m)); // Affichage du score en fin de partie
	}

	/**
	 * Accesseur de stop
	 * 
	 * @return stop
	 */
	public static boolean getStop() {
		return stop;
	}

	/**
	 * Mutateur de stop
	 * 
	 * @param sStop la variable stop
	 */
	public static void setStop(boolean sStop) {
		stop = sStop;
	}

	/**
	 * Accesseur du message d'erreur
	 * 
	 * @return msgErreur Le message d'erreur
	 */
	public static TypeErreur getMsgErreur() {
		return msgErreur;
	}

	/**
	 * Mutateur du message d'erreur
	 * 
	 * @param err Le message d'erreur à stocker
	 */
	public static void setMsgErreur(TypeErreur err) {
		msgErreur = err;
	}
}