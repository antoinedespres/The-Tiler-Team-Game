import java.util.*;

/**
 * Classe ListeCarreaux.
 * 
 * @author Antoine Després
 * @author Thibault Henrion
 * @version 1.0
 */
public class ListeCarreaux {

	private ArrayList<Carreau> listeCarr;

	private final int COTESMAXCARREAU = 3;
	private final int NBCOULEURS = 2;

	private static final char lettres[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' };
	private static final int dim[][] = { { 1, 1, 2, 2, 1, 3, 2, 3, 3 }, { 1, 2, 1, 2, 3, 1, 3, 2, 3 } };
	private static final int dimPieceNeutre[][] = { { 1, 3 }, { 3, 1 } };

	/*
	 * Constructeur de ListeCarreaux
	 *
	 * @param remplir Booléen permettant de choisir de remplir ou non la liste
	 */
	public ListeCarreaux(boolean remplir) {
		listeCarr = new ArrayList<>();
		if (remplir) {
			this.remplirPaquet();
		}
	}

	/**
	 * Accesseur de taille de liste
	 * 
	 * @return La taille de la liste
	 */
	public int size() {
		return this.listeCarr.size();
	}

	/**
	 * Retire un carreau
	 * 
	 * @param lettre La lettre du carreau
	 * @return Un type d'erreur
	 */
	public TypeErreur retirerCarreau(char lettre) {
		for (int i = 0; i < this.listeCarr.size(); i++) {
			if (this.listeCarr.get(i).getLettre() == lettre) {
				this.listeCarr.remove(i);
				return TypeErreur.CORRECT;
			}
		}
		return TypeErreur.NON_TROUVE;
	}

	/**
	 * Remplissage d'une liste de carreaux
	 */
	private void remplirPaquet() {
		boolean rouge = false;
		for (int j = 0; j < 2; ++j) {
			int k = 0;
			for (char i : lettres) {
				listeCarr.add(new Carreau(dim[0][k], dim[1][k], i, rouge));
				k++;
			}
			rouge = true; // mêmes carreaux, en rouge cette fois
		}
	}

	/**
	 * Affichage des carreaux pouvant être joués avec la carte tirée
	 *
	 * @param carteTiree la carte tirée
	 * @return carreauxDispo Une liste de carreaux
	 */
	public ListeCarreaux carreauDispo(Carte carteTiree) {
		ListeCarreaux carreauDispo = new ListeCarreaux(false);
		switch (carteTiree.getTypeCarte()) {
		case BLEU:
			for (Carreau i : this.listeCarr) {
				if (Character.isLowerCase(i.getLettre()))
					carreauDispo.listeCarr.add(i);
			}
			break;
		case ROUGE:
			for (Carreau i : this.listeCarr) {
				if (Character.isUpperCase(i.getLettre()))
					carreauDispo.listeCarr.add(i);
			}
			break;
		case TAILLE1:
			for (Carreau i : this.listeCarr) {
				if (i.getHauteur() == 1 || i.getLargeur() == 1)
					carreauDispo.listeCarr.add(i);
			}
			break;
		case TAILLE2:
			for (Carreau i : this.listeCarr) {
				if (i.getHauteur() == 2 || i.getLargeur() == 2)
					carreauDispo.listeCarr.add(i);
			}
			break;
		case TAILLE3:
			for (Carreau i : this.listeCarr) {
				if (i.getHauteur() == 3 || i.getLargeur() == 3)
					carreauDispo.listeCarr.add(i);
			}
			break;
		}
		return carreauDispo;
	}

	/**
	 * Accesseur de carreau
	 * 
	 * @param lettre La lettre correspondant au carreau demandé.
	 * @return Le carreau demandé.
	 */
	public Carreau getCarreau(char lettre) {
		for (int i = 0; i < this.listeCarr.size(); i++) {
			if (this.listeCarr.get(i).getLettre() == lettre) {
				return this.listeCarr.get(i);
			}
		}
		return (new Carreau(0, 0, 'z', true)); // carreau de bug
	}

	/**
	 * Accesseur de la liste de carreaux
	 * 
	 * @return La liste de carreaux
	 */
	public ArrayList<Carreau> getListeCarreaux() {
		return listeCarr;
	}

	/**
	 * Accesseur de la largeur d'un carreau
	 * 
	 * @return res la largeur du carreau demandé
	 */
	private int LargeurCarreaux() {
		int res = 0;
		for (Carreau i : this.listeCarr) {
			res += i.getLargeur();
		}
		return res;
	}

	/**
	 * Vérifie si la liste de carreaux est vide ou non.
	 * 
	 * @return True si la liste de carreaux est vide, false sinon.
	 */
	public boolean estVide() {
		return this.listeCarr.isEmpty();
	}

	/**
	 * Vérifie si la liste de carreaux contient le carreau demandé
	 * 
	 * @param a La lettre correspondant au carreau demandé.
	 * @return True si le carreau est dans la liste, false sinon.
	 */
	public boolean contient(char a) {
		for (Carreau i : this.listeCarr) {
			if (i.getLettre() == a) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Accesseur de la largeur d'un carreau du mur
	 * 
	 * @param lettre La lettre du carreau dont on souhaite connaître la largeur.
	 * @param m      Le mur
	 * @return La largeur du carreau demandé
	 */
	public static int getLargeurCar(char lettre, Mur m) {
		int j = 0;
		lettre = Character.toLowerCase(lettre);
		for (char i : lettres) {
			if (i == lettre) {
				return dim[0][j];
			}
			++j;
		}
		if (lettre == 'x') {
			return dimPieceNeutre[0][m.getNumPieceNeutre()];
		}

		System.exit(2);
		return 0;
	}

	/**
	 * Accesseur de la hauteur d'un carreau du mur
	 * 
	 * @param lettre La lettre du carreau dont on souhaite connaître la hauteur.
	 * @param m      Le mur
	 * @return La hauteur du carreau ou 0 si ce dernier n'existe pas
	 */
	public static int getHauteurCar(char lettre, Mur m) {
		int j = 0;
		lettre = Character.toLowerCase(lettre);
		for (char i : lettres) {
			if (i == lettre) {
				return dim[1][j];
			}
			++j;
		}
		if (lettre == 'x') {
			return dimPieceNeutre[1][m.getNumPieceNeutre()];
		}

		System.exit(2);
		return 0;
	}

	/**
	 * Stockage d'une chaîne de caractères contenant une liste de carreaux
	 * 
	 * @return sb la chaîne de caractères
	 */
	public String toString() {
		int largeurPris = 0;
		char[][] tab = new char[COTESMAXCARREAU][this.LargeurCarreaux()];
		for (int i = 0; i < COTESMAXCARREAU; i++) {
			for (int j = 0; j < this.LargeurCarreaux(); j++) {
				tab[i][j] = ' ';
			}
		}
		for (Carreau i : this.listeCarr) {
			for (int j = 0; j < i.getHauteur(); j++) {
				for (int k = 0; k < i.getLargeur(); k++) {
					tab[tab.length - 1 - j][k + largeurPris] = i.getLettre();
				}
			}
			largeurPris += i.getLargeur();
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < COTESMAXCARREAU; ++i) {
			char derCarac = ' ';
			boolean prem = true;
			for (int j = 0; j < tab[0].length; j++) {
				if (!(derCarac == tab[tab.length - 1][j]) && !prem) {
					sb.append(" ");
				}
				sb.append(tab[i][j]);
				sb.append(" ");

				prem = false;
				derCarac = tab[tab.length - 1][j];
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}
}