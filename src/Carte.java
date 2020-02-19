public class Carte{
  
  private static enum typeCarte {
    BLEU, ROUGE, TAILLE1, TAILLE2, TAILLE3;
  }

  private typeCarte tc;
  
  public Carte(typeCarte tc){
    this.tc = tc;
  }

  public typeCarte getTypeCarte(){
    return this.tc;
  }
  public void setBleu(){
    this.tc = BLEU;
  }
  public void setRouge(){
    this.tc = ROUGE;
  }
  public void setTaille1(){
    this.tc = TAILLE1;
  }
  public void setTaille2(){
    this.tc = TAILLE2;
  }
  public void setTaille3(){
    this.tc = TAILLE3;
  }
}