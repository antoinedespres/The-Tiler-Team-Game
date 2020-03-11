package components;
/**
 * Classe Score.
 * 
 * @author Antoine Després
 * @author Thibault Henrion
 * @version 1.0
 */
public class Score {
	private int carteÉcartée;

	/**
	 * Stocke la phrase détaillant le score atteint
	 *
	 * @param s Le score
	 * @param p La liste de carreaux
	 * @param m Le mur
	 * @return Chaîne de caractères détaillant le score
	 */
	public String toString(Score s, ListeCarreaux p, Mur m) {
		return (5 * m.getHauteurMin() - p.size() - carteÉcartée + " points (" + m.getHauteurMin()
				+ " niveaux complets, " + p.size() + " carreaux non posés, " + carteÉcartée + " cartes écartées)");
	}

	/**
	 * Incrémente la valeur de carte écartée. A utiliser lorsque le joueur écarte
	 * une carte
	 */
	public void écarter() {
		carteÉcartée++;
	}
}
