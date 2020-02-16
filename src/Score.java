
public class Score {
	private int pts;
	private int nivComplets;
	private int nonPose;
	private int carteEcartee;

  	/**
	 * Affiche la phrase détaillant le score atteint
	 * @param m le mur
	 */
	public static String toString(Score s) {
		
		return s.pts + "points ("+s.nivComplets+" niveaux complets, "+s.nonPose + "carreaux non posés, " + s.carteEcartee + " cartes écartées)";
	}
}
