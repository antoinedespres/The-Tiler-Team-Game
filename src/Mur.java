
public class Mur {
	/**
	 * Tableau de caractères à deux dimensions.
	 */
	char[][] mur;
	
	/**
	 * La largeur du mur est constante et définie à 5 unités.
	 */
	final byte largeur = 5;
	
	/**
	 * La hauteur varie avec l'empilage de carreaux.
	 */
	int hauteur = 5;
	
	/**
	 * Affiche le mur complet avec coordonnées.
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
