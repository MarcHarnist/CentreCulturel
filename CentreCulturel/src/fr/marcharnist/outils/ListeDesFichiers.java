package fr.marcharnist.outils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Marc Harnist
 * @since 2019-05-15
 * 
 * 	Affiche la liste des fichiers, puis la liste des répertoires
 *  du répertoire bin/ nom du package / nom du projet
 *  Exemple: bin/fr/marcharnist/stream
 *
 */
public interface ListeDesFichiers {
	static void afficheProgrammesList(String projetPath, String afficherCetteMethode) {
		if(afficherCetteMethode == "yes") {
			
			String repertoireBin = CheminBin.trouveCheminBin(projetPath);// va chercher le chemin du répertoire bin dans une énumération
			if(repertoireBin != null) {
				File folder = new File(repertoireBin); // Ex: repertoireBin =  fr/marcharnist/(nom du "projet")
				if(folder.exists()) {
					Chapeau.comment("Liste des fichiers et répertoires de " + repertoireBin + "\n");
					File[] listOfFiles = folder.listFiles();// Liste les fichiers du répertoire du projet
					List<Object> fichiers = new ArrayList<>();// Crée une liste de fichier vide
					List<Object> dossiers = new ArrayList<>();// Crée une liste de repertoire vide
					for(File list:listOfFiles) { // parcours la liste de fichiers et répertoires du répertoire "projet"
						if(list.isFile())
							fichiers.add(list.getName());// ajoute les fichiers dans la liste des fichiers
						else
							dossiers.add(list.getName());// ajoute les dossiers dans la liste des dossiers
					}
		            System.out.println();
		            System.out.println("// **** Nombre de fichiers: " + fichiers.size()); // Affiche le nombre de fichiers
		            for(Object line:fichiers)
		            	System.out.println(line); // affiche chaque nom de fichier
		            System.out.println();
		            System.out.println("// **** Nombre de dossiers: " + dossiers.size()); // Affiche le nombre de répertoires
		            for(Object line:dossiers)
		            	System.out.println(line);// affiche chaque nom de répertoire
					}
				else
					System.out.println("\n Erreur 1: Message du fichier ListeDesFichiers: Répertoire bin introuvable");
					
				}
			else
				System.out.println("\n Erreur 2: Message du fichier ListeDesFichiers:  Répertoire bin introuvable (null)");
		}
		else
			Chapeau.comment("no");
	}
}
