package methods;
import java.util.*;

/**
 * Classe Mur.
 * 
 * @author Antoine Després
 * @author Thibault Henrion
 * @version 1.0
 */
public class Mur {
	private static final int NBPIECENEUTRE = 2; // Deux positions de pièce neutre possibles
	private static final char LETTREPIECENEUTRE = 'x';
	private static final Carreau PIECENEUTRE1 = new Carreau(1, 3, LETTREPIECENEUTRE, false);// pièce verticale
	private static final int[] POSPIECENEUTRE1 = { 1, 5 };
	private static final Carreau PIECENEUTRE2 = new Carreau(3, 1, LETTREPIECENEUTRE, false);// pièce horizontale
	private static final int[] POSPIECENEUTRE2 = { 1, 3 };

	/**
	 * Les axes sont en base 10 On peut ainsi savoir quand décaler l'affichage des
	 * coordonnés des lignes
	 */
	private static final int BASEAXES = 10;

	/**
	 * Numéro de la pièce neutre
	 */
	private int numPieceNeutre;

	/**
	 * La largeur du mur est constante et définie à 5 unités.
	 */
	private final static int LARGEUR = 5;

	/**
	 * Nombre de cotés sur un carreau.
	 */
	private final static int COTESCARREAU = 2;

	/**
	 * Tableau de caractères à deux dimensions.
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<Character>[] mur = new ArrayList[LARGEUR];

	/**
	 * Constructeur de {@link Mur}
	 */
	public Mur() {
		for (int i = 0; i < LARGEUR; i++) {
			this.mur[i] = new ArrayList<Character>();
		}
		this.placerPieceNeutre();
	}

	/**
	 * Accesseur du numéro de pièce neutre
	 * 
	 * @return Le numéro de la pièce neutre
	 */
	public int getNumPieceNeutre() {
		return numPieceNeutre;
	}

	/**
	 * Place la pièce neutre sur le mur. La position et l'orientation de celle-ci
	 * sont déterminées aléatoirement.
	 */
	private void placerPieceNeutre() {
		Random piece = new Random();
		Random position = new Random();
		if (piece.nextInt(NBPIECENEUTRE) == 0) {
			this.numPieceNeutre = 0;
			this.placerCarreau(PIECENEUTRE1, POSPIECENEUTRE1[position.nextInt(2)], 1);
		} else {
			this.numPieceNeutre = 1;
			this.placerCarreau(PIECENEUTRE2, POSPIECENEUTRE2[position.nextInt(2)], 1);
		}
	}

	/**
	 * Accesseur de la hauteur maximale.
	 * 
	 * @return hauteurMax La hauteur de la ligne remplie la plus haute dans le mur.
	 */
	public int getHauteurMax() {
		int hauteurMax = 0;
		for (ArrayList<Character> i : mur) {
			if (i.size() >= hauteurMax)
				hauteurMax = i.size();
		}
		return hauteurMax;
	}

	/**
	 * Accesseur de la hauteur minimale.
	 * 
	 * @return hauteurMin La hauteur de la ligne remplie la plus basse dans le mur.
	 */
	public int getHauteurMin() {
		int hauteurMin = this.mur[0].size();
		for (ArrayList<Character> i : mur) {
			if (i.size() <= hauteurMin)
				hauteurMin = i.size();
		}
		return hauteurMin;
	}

	/**
	 * Place un carreau sur le {@link Mur}.
	 *
	 * @param c     Le carreau
	 * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
	 * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
	 * @return Un type d'erreur
	 */
	public TypeErreur placerCarreau(Carreau c, int absBG, int ordBG) {
		absBG--;
		ordBG--;
		if (absBG < 0 || ordBG < 0)
			return TypeErreur.DEPASSEMENT;
		TypeErreur etatPlacement;
		if (c.getLettre() == LETTREPIECENEUTRE || this.placementCorrect(c, absBG, ordBG) == TypeErreur.CORRECT) {
			etatPlacement = TypeErreur.CORRECT;
			for (int i = absBG; i < absBG + c.getLargeur(); i++) {
				for (int j = 0; j < c.getHauteur(); j++)
					this.mur[i].add(c.getLettre());
			}
			return etatPlacement;
		}
		return this.placementCorrect(c, absBG, ordBG);
	}

	/**
	 * Vérifie si le placement de carreau est correct
	 *
	 * @param c     Le {@link Carreau}
	 * @param absBG L'abscisse du point en bas à gauche du carreau
	 * @param ordBG L'ordonnée du point en bas à gauche du carreau
	 * @return Un type d'erreur
	 */
	private TypeErreur placementCorrect(Carreau c, int absBG, int ordBG) {
		if (dépasse(c, absBG, ordBG) == TypeErreur.DEPASSEMENT) {
			return TypeErreur.DEPASSEMENT;
		}
		TypeErreur baseRepose = baseRepose(c, absBG, ordBG);
		if (baseRepose == TypeErreur.REPOS_BASE)
			return TypeErreur.REPOS_BASE;
		if (touche(c, absBG, ordBG, baseRepose) == TypeErreur.NON_CONTACT)
			return TypeErreur.NON_CONTACT;
		if (cloneBord(c, absBG, ordBG) == TypeErreur.CLONAGE)
			return TypeErreur.CLONAGE;
		
		return TypeErreur.CORRECT;
	}

	/**
	 * Vérifie si le carreau dépasse de la zone à carreler
	 *
	 * @param c     Le {@link Carreau}
	 * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
	 * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
	 * @return Un type d'erreur
	 */
	private TypeErreur dépasse(Carreau c, int absBG, int ordBG) {
		if (absBG + c.getLargeur() <= LARGEUR && absBG >= 0 && ordBG >= 0) { // && absBG > 0 && ordBG > 0 ???
			return TypeErreur.CORRECT;
		}
		return TypeErreur.DEPASSEMENT;
	}

	/**
	 * Vérifie si le carreau touche un autre carreau et repose sur une base stable
	 *
	 * @param c     Le {@link Carreau}
	 * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
	 * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
	 * @return Un type d'erreur
	 */
	private TypeErreur touche(Carreau c, int absBG, int ordBG, TypeErreur baseRepose) {
		if (baseRepose == TypeErreur.CORRECT && ordBG > 0)
			return TypeErreur.CORRECT;
		if (ordBG == 0) {
			boolean touche = false;
			for (int i = -1; i < COTESCARREAU + c.getLargeur() - 1 && absBG + i < 5 && absBG + i >= 0
					&& !touche; i += 2 + c.getLargeur() - 1) {
				if (this.mur[absBG + i].size() >= ordBG && !this.mur[absBG + i].isEmpty()) {
					touche = true;
				}
			}
			if (absBG == 0) {
				if (this.mur[absBG + c.getLargeur()].size() >= ordBG && !this.mur[absBG + c.getLargeur()].isEmpty()) {
					touche = true;
				}
			}
			if (!touche) {
				return TypeErreur.NON_CONTACT;
			}
		}
		return TypeErreur.CORRECT;
	}

	/**
	 * Vérifie si le carreau dépasse de la zone à carreler
	 *
	 * @param c     Le {@link Carreau}
	 * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
	 * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
	 * @return Un type d'erreur
	 */
	private TypeErreur baseRepose(Carreau c, int absBG, int ordBG) {
		for (int i = 0; i < c.getLargeur(); i++) {
			if (this.mur[absBG + i].size() != ordBG && ordBG != 0) {
				return TypeErreur.REPOS_BASE;
			} else if (ordBG == 0 && !this.mur[absBG + i].isEmpty()) {
				return TypeErreur.REPOS_BASE;
			}
		}
		return TypeErreur.CORRECT;
	}

	/**
	 * @param c     Le Carreau
	 * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
	 * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
	 * @return Un type d'erreur
	 */
	private TypeErreur cloneBordBas(Carreau c, int absBG, int ordBG) {
		if (ordBG > 0) {
			if (ListeCarreaux.getLargeurCar(this.mur[absBG].get(ordBG - 1), this) == c.getLargeur()) {
				char lettrePré = mur[absBG].get(ordBG - 1);
				char lettreSuiv = ' ';
				boolean estEgal = true;
				for (int i = 1; i < c.getLargeur() && estEgal; i++) {
					lettreSuiv = mur[absBG + i].get(ordBG - 1);
					estEgal = lettrePré == lettreSuiv;
				}
				if (estEgal)
					return TypeErreur.CLONAGE;
				else
					return TypeErreur.CORRECT;
			}
		}
		return TypeErreur.CORRECT;
	}

	/**
	 *
	 * @param c     Le carreau
	 * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
	 * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
	 * @param coté  Côté à vérifier (gauche ou droite)
	 * @return Un type d'erreur
	 */
	private TypeErreur cloneBordCote(Carreau c, int absBG, int ordBG, int coté) {
		int colonneCoté = absBG;
		if (coté == -1) {
			colonneCoté += coté;
			if (colonneCoté < 0) {
				return TypeErreur.CORRECT;
			}
		} else if (coté == 1) {
			colonneCoté += c.getLargeur();
			if (colonneCoté > LARGEUR - 1) {
				return TypeErreur.CORRECT;
			}
		}
		if (ordBG + c.getHauteur() > this.mur[colonneCoté].size() || this.mur[colonneCoté].isEmpty()) {
			return TypeErreur.CORRECT;
		}
		if (ListeCarreaux.getHauteurCar(this.mur[colonneCoté].get(ordBG), this) == c.getHauteur()) {
			char lettrePré = mur[colonneCoté].get(ordBG);
			char lettreSuiv = ' ';
			boolean estEgal = true;
			for (int i = 1; i < c.getHauteur() && estEgal; i++) {
				lettreSuiv = mur[colonneCoté].get(ordBG + i);
				estEgal = lettrePré == lettreSuiv;
			}
			if (estEgal)
				return TypeErreur.CLONAGE;
			else
				return TypeErreur.CORRECT;
		}
		return TypeErreur.CORRECT;
	}

	/**
	 * Vérifie qu'un carreau ne clone pas le bord d'un carreau autour de lui
	 * 
	 * @param c     Le carreau
	 * @param absBG Le point d'abscisse en bas à gauche du {@link Carreau}
	 * @param ordBG Le point d'ordonnée en bas à gauche du {@link Carreau}
	 * @return Un type d'erreur
	 */
	public TypeErreur cloneBord(Carreau c, int absBG, int ordBG) {
		if (cloneBordBas(c, absBG, ordBG) == TypeErreur.CLONAGE
				|| cloneBordCote(c, absBG, ordBG, -1) == TypeErreur.CLONAGE
				|| cloneBordCote(c, absBG, ordBG, 1) == TypeErreur.CLONAGE) {
			return TypeErreur.CLONAGE;
		}
		return TypeErreur.CORRECT;
	}

	/**
	 * Affiche le mur complet avec coordonnées.
	 * 
	 * @return sb La chaîne de caractères contenant le mur
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (int i = this.getHauteurMax(); i >= 0; --i) {
			if (this.getHauteurMax() >= BASEAXES - 1 && i + 1 < BASEAXES) // pour éviter un décalage à partir de la ligne 10
				sb.append(" ");
			sb.append(i + 1);
			sb.append(" ");
			for (int j = 0; j < LARGEUR; j++) {
				if (i < this.mur[j].size()) {
					sb.append(this.mur[j].get(i));
				} else {
					sb.append(" ");
				}
				sb.append(" ");
			}
			sb.append(System.lineSeparator());
		}
		if (this.getHauteurMax() >= BASEAXES - 1)
			sb.append("   1 2 3 4 5");
		else
			sb.append("  1 2 3 4 5");
		return sb.toString();
	}
}