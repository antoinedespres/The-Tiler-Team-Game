
public class Mur {
	char[][] mur;
	final byte largeur = 5;
	byte hauteur;
	
	/**
	 * Affiche le mur complet
	 * @param m Le mur
	 */
	public static void afficherMur(Mur m) {
		for(byte i=m.hauteur; i>=0;--j) {
			for(byte j=0;j<m.largeur;++j){
			//	System.out.println((m.largeur-j)+m[i][j]);
			}
		}
		System.out.print(" ");
		for(int k=1;k<m.largeur;k++) {
			System.out.print(k);
		}
		System.out.println("");
	}
}
