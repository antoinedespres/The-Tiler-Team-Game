
public class Mur {
	/**
	 * Tableau de caract�res � deux dimensions.
	 */
	char[][] mur;
	
	/**
	 * La largeur du mur est constante et d�finie � 5 unit�s.
	 */
	final byte largeur = 5;
	
	/**
	 * La hauteur varie avec l'empilage de carreaux.
	 */
	int hauteur = 5;
	
	/**
	 * Affiche le mur complet avec coordonn�es.
	 * @param m Le mur
	 */
	public static void afficherMur(Mur m) {
		for(int i=m.hauteur; i>=0;--i) {
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
