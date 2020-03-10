package methods;
import java.util.Scanner;

import Appli.Main;

/**
 * Classe FctJeu pour l'appel de commande et la détection de fin de partie
 * 
 * @author Antoine Després
 * @author Thibault Henrion
 */
public class FctJeu {

	/**
	 * Vérifie si la partie est terminée ou non
	 *
	 * @param j    Le jeu de carte
	 * @param p    La liste des carreaux
	 * @param stop La condition stop entrée par le joueur
	 * @return true si la partie est terminée, false sinon
	 */
	public static boolean estTerminee(JeuDeCartes j, ListeCarreaux p, boolean stop) {
		return j.getJeuCartes().size() == 0 || p.getListeCarreaux().size() == 0 || stop == true;
	}

	/**
	 * Appelle la commande correspondant à la saisie si elle est correcte.
	 * 
	 * @param sc           Le scanner
	 * @param m            Le mur
	 * @param CarteTirée   La carte tirée
	 * @param p            La liste des carreaux
	 * @param s            Le score
	 * @param AucunCarreau booléen à true si aucun carreau ne correspond à la carte
	 *                     tirée
	 */
	public static void appelCommande(Scanner sc, Mur m, Carte CarteTirée, ListeCarreaux p, Score s,
			boolean AucunCarreau) {
		String mot = "";
		if (AucunCarreau) // si aucun carreau jouable avec cette carte, on force le tour suivant
			mot = "next";
		else
			mot = sc.next(); // sinon, on lit l'entrée de l'utilisateur
		switch (mot) {
		case "next":
			s.écarter(); // écarter la carte et décrémenter le score
			Main.setMsgErreur(TypeErreur.CORRECT); // la saisie est correcte
			break;
		case "stop":
			Main.setStop(true); // la fonction estTerminee détectera la demande d'arrêt
			Main.setMsgErreur(TypeErreur.CORRECT);
			break;
		default:
			if (mot.length() > 1) { // il ne s'agit pas d'une seule lettre !
				Main.setMsgErreur(TypeErreur.SAISIE); // C'est donc une erreur de saisie
			} else {
				int absBG, ordBG; // coordonnées à saisir
				absBG = ordBG = 0;
				if (sc.hasNextInt())
					ordBG = sc.nextInt();
				else {
					Main.setMsgErreur(TypeErreur.SAISIE); // si on ne saisit pas un int : erreur de saisie
					break;
				}
				if (sc.hasNextInt())
					absBG = sc.nextInt();
				else {
					Main.setMsgErreur(TypeErreur.SAISIE);
					break;
				}
				if (p.carreauDispo(CarteTirée).contient(mot.charAt(0))) { // si un carreau correspond...
					Carreau c = p.getCarreau(mot.charAt(0));
					Main.setMsgErreur(m.placerCarreau(c, absBG, ordBG)); // on récupère le message d'erreur
					if (Main.getMsgErreur() == TypeErreur.CORRECT) {
						p.retirerCarreau(mot.charAt(0)); // si le placement est CORRECT, on peut retirer le carreau de
															// la liste
					}
				} else {
					Main.setMsgErreur(TypeErreur.SAISIE); // sinon c'est une erreur de saisie
				}
			}
		}
	}
}