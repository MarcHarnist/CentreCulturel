package fr.marcharnist.outils;

import java.io.File;
import java.util.Scanner;

import fr.marcharnist.outils.CheminBureau;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char continuer = 'O';
		
		do {
			
			String dir = trouveCheminBureau();
			
			if(dir != "Bureau introuvable") {
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Quel fichier du bureau souhaitez-vous supprimer?");
				String line = sc.nextLine();
				String fileName = line;
				
				/** Add directory
				 * 
				 */
				fileName = dir + line;
		
				if(delete(fileName) == true) {
					System.out.println("Le fichier a bien été supprimé");
				}
				else {
					System.out.println("Je ne trouve pas ce fichier: " + fileName   + " avez-vous pensé à l'extension?");
					System.out.println("Essayez à nouveau. Tapez le nom du fichier avec son extension.");
					//				do {
					System.out.println("Voulez-vous réessayer? O/N");
					continuer = sc.nextLine().charAt(0);
					fileName = sc.nextLine();
	//				}while(continuer == 'o' || continuer == 'O');
				}		
				sc.close();
			} // lose verifieCheminBureau == true
			else
				System.out.println("Je ne trouve pas le chemin du bureau!\n"
						+ " Il faut ajouter le chemin du bureau de ce PC dans ma liste.");
		
		}while(continuer == 'o' || continuer == 'O' );
	}

	private static String trouveCheminBureau() {
		// TODO Auto-generated method stub

		/** Vérifie le PC
		 *  Le programme ne fonctionne pas si le chemin du bureau change lorsqu'on change de PC
		 *  C'est pour cela que le chemin a été coupé et s'arrête au Desktop pour vérifications.
		 * 	
		 * Model:     for(Langage lang : Langage.values()){	
		 */
		String dir = "Bureau introuvable";
		for(CheminBureau path: CheminBureau.values()) {
			File desktopPathVerify = new File(path.toString());
			if(desktopPathVerify.exists())
				dir = path.toString();
		}
		return dir;
	}

	public static boolean delete(String fileName) {
		boolean deleted = false;
		File fileToDelete = new File(fileName);
		if(fileToDelete.exists()) {
			fileToDelete.delete();
			deleted = true;
		}
		return deleted;
	}
	
	
	
	
}


