package components;
/**
 * Énumération des erreurs possibles
 */
public enum TypeErreur {
	CORRECT(""),
	DEPASSEMENT("Le carreau dépasse de la zone à carreler"),
	NON_CONTACT("Le carreau ne touche pas un autre carreau"), NON_TROUVE("Élément non trouvé"),
	REPOS_BASE("Toute la base du carreau ne repose pas sur le bas de la zone ou d'autres carreaux"),
	CLONAGE("Le carreau clone le côté d'un carreau déjà posé"), SAISIE("La saisie est incorrecte");

	/**
	 * La chaîne de caractères devant être affichée
	 */
	private final String affichage;

	/**
	 * Constructeur de type d'erreur
	 * 
	 * @param affichageConforme Ce qui doit être affiché
	 */
	TypeErreur(final String affichageConforme) {
		this.affichage = affichageConforme;
	}

	@Override
	/**
	 * Stocke la chaîne de caractères à afficher
	 * 
	 * @return Le type d'erreur
	 */
	public String toString() {
		return this.affichage + System.lineSeparator();
	}
}