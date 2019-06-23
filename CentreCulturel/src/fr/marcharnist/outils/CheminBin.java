package fr.marcharnist.outils;

import java.io.File;

public interface CheminBin {
	
	static String trouveCheminBin(String projetPath) {
		// TODO Auto-generated method stub

		
		/** Vérifie le chemin du répertoire "bin"
		 *  Le programme ne fonctionne différemment 
		 *  selon qu'on utilise windows.cmd.exe ou
		 *  la console d'Eclipse.
		 */
		for(ListeCheminsBin path: ListeCheminsBin.values()) {
			String chemin = path.toString() + projetPath;
			File desktopPathVerify = new File(chemin);
			String dir = null;
			if(desktopPathVerify.exists()) {
				dir = chemin;
				return dir;
			}
		}
		return "";
	}
}
