
public class Score {
  private int pts;
  private int nivComplets;
  private int nonPose;
  private int carteEcartee;

  public Score(int pPts, int pNivComplets, int pNonPose, int pCarteEcartee) {
	  pts=pPts;
	  nivComplets=pNivComplets;
	  nonPose=pNonPose;
	  carteEcartee=pCarteEcartee;
  }
  /**
   * Stocke la phrase d�taillant le score atteint
   * @param s le score
   * @return s Cha�ne de caract�res d�taillant le score
   */
  public String toString(Score s) {

    return (pts + "points (" + nivComplets + " niveaux complets, " + nonPose + "carreaux non pos�s, " + carteEcartee + " cartes �cart�es)");
  }

  /**
   * Incr�menter la valeur saisie
   * @param s Le nom de la valeur � incr�menter
   */
  public void incrementer(String s){
    switch(s){
      case "nivComplets":
        nivComplets++;
        break;
      case "nonPose":
        nonPose++;
        break;
      case "carteEcartee":
        carteEcartee++;
        break;
    }

  }
  
  public int getNivComplets(Score s) {
	  return nivComplets;
  }
  
  public int getNonPose(Score s) {
	  return nonPose;
  }
  
  public int getcarteEcartee(Score s) {
	  return carteEcartee;
  }
}
