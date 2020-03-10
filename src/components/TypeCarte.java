package components;
/**
 * Énumération des types de carreau pouvant être indiqués sur une {@link Carte}
 */
public enum TypeCarte {
	BLEU("bleu"), ROUGE("rouge"), TAILLE1("Taille 1"), TAILLE2("Taille 2"), TAILLE3("Taille 3");

	/**
	 * La chaîne de caractères devant être affichée
	 */
	private final String affichage;

	/**
	 * Constructeur du type de carte
	 * 
	 * @param affichageConforme Ce qui doit être affiché
	 */
	TypeCarte(final String affichageConforme) {
		this.affichage = affichageConforme;
	}

	@Override
	/**
	 * Stocke la chaîne de caractères à afficher
	 * 
	 * @return Le type de carreau à jouer
	 */
	public String toString() {
		return this.affichage;
	}
}