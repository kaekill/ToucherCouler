package touchercouler;

import gui.Grille;

public class GestionBateau {
	public static void placeBateau (int bateau, int ligne, int colonne, Grille grille){
		for (int i = 0;i<bateau; i++){
			grille.getTabJButton()[ligne][colonne++].setBateau(bateau);
		}
	}
}
