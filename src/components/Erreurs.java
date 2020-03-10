package components;
/**
* Énumération des erreurs possibles
*/
public enum Erreurs {
  CORRECT(""),
  DEPASSEMENT("Le carreau dépasse de la zone à carreler"),
  NON_CONTACT("Le carreau ne touche pas un autre carreau"),
  REPOS_BASE("Toute la base du carreau ne repose pas sur le bas de la zone ou d'autres carreaux"),
  CLONAGE("Le carreau clone le côté d'un carreau déjà posé");

  private final String affichage;

  Erreurs(final String affichageConforme) {
    this.affichage = affichageConforme;
  }

  @Override
  public String toString() {
    return this.affichage;
  }
}