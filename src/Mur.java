
public class Mur {
	char[][] mur;
	byte largeur;
	byte hauteur;
	
	public Mur(byte pLargeur, byte pHauteur) {
		this.largeur=pLargeur;
		this.hauteur=pHauteur;
		this.mur=new char[pHauteur][pLargeur];
	}
}
