
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
   * Affiche la phrase d�taillant le score atteint
   * 
   * @param s le score
   */
  public String toString(Score s) {

    return (pts + "points (" + nivComplets + " niveaux complets, " + nonPose + "carreaux non pos�s, " + carteEcartee + " cartes �cart�es)");
  }

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
}
