
public class Score {
  private int pts;
  private int nivComplets;
  private int nonPose;
  private int carteÉcartée;

  public Score(int pPts, int pNivComplets, int pNonPose, int pcarteÉcartée) {
	  pts=pPts;
	  nivComplets=pNivComplets;
	  nonPose=pNonPose;
	  carteÉcartée=pCarteÉcartée;
  }
  /**
   * Stocke la phrase détaillant le score atteint
   * @param s le score
   * @return s Chaîne de caractères détaillant le score
   */
  public String toString(Score s) {

    return (pts + "points (" + nivComplets + " niveaux complets, " + nonPose + "carreaux non posés, " + carteÉcartée + " cartes écartées)");
  }

  /**
   * Incrémenter la valeur saisie
   * @param s Le nom de la valeur à incrémenter
   */
  public void incrementer(String s){
    switch(s){
      case "nivComplets":
        nivComplets++;
        break;
      case "nonPose":
        nonPose++;
        break;
      case "carteÉcartée":
        carteÉcartée++;
        break;
    }

  }
  
  public int getNivComplets(Score s) {
	  return nivComplets;
  }
  
  public int getNonPose(Score s) {
	  return nonPose;
  }
  
  public int getcarteÉcartée(Score s) {
	  return carteÉcartée;
  }
}
