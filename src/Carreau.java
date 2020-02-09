
public class Carte {
	private static final byte NBCARTESTOT=33;
	private static final byte NBCARTESCOULEUR=9;
	private static final byte NBCARTESTAILLE=5;
	private enum typeCarte{
    BLEU,
    ROUGE,
    TAILLE1,
    TAILLE2,
    TAILLE3;
  }

  private typeCarte[NBCARTESTOT] tasCartes;

  public void initTasCarte(){
    int i = 0;
    for(; i<NBCARTESCOULEUR; ++i){
      this.tasCartes[i] = typeCarte.BLEU;
    }
    for(;i<18;++i){
      this.tasCartes[i] = typeCarte.ROUGE;
    }
    for(;i<23;++i){
      this.tasCarte[i] = typeCarte.TAILLE1;
    }
    for(;i<28;++i){
      this.tasCarte[i] = typeCarte.TAILLE2;
    }
    for(;i<NBCARTES;++i){
      this.tasCarte[i] = typeCarte.TAILLE3;
    }
    tasCarte.shuffle();
  }
  
}
//créer une fct getTypeCarte pour la fonction afficher carte dispo dans Carreau.java