
public class Score {
  private int pts;
  private int nivComplets;
  private int nonPose;
  private int carte�cart�e;

  public Score(int pPts, int pNivComplets, int pNonPose, int pcarte�cart�e) {
	  pts=pPts;
	  nivComplets=pNivComplets;
	  nonPose=pNonPose;
	  carte�cart�e=pCarte�cart�e;
  }
  /**
   * Stocke la phrase d�taillant le score atteint
   * @param s le score
   * @return s Cha�ne de caract�res d�taillant le score
   */
  public String toString(Score s) {

    return (pts + "points (" + nivComplets + " niveaux complets, " + nonPose + "carreaux non pos�s, " + carte�cart�e + " cartes �cart�es)");
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
      case "carte�cart�e":
        carte�cart�e++;
        break;
    }

  }
  
  public int getNivComplets(Score s) {
	  return nivComplets;
  }
  
  public int getNonPose(Score s) {
	  return nonPose;
  }
  
  public int getcarte�cart�e(Score s) {
	  return carte�cart�e;
  }
}
