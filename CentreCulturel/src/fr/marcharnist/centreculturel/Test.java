package fr.marcharnist.centreculturel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marc L. Harnist, Stagiaire � l'ENI 2019
 * @since 1.0
 * <ul>
 *   <li>Centre culturel
 *     <ul>
 *       <li>La classe "Test" contient la m�thode main() du package</li>
 *     </ul>  
 *   </li>
 *  </ul>
 *  <p>Le code de cette classe instancie les classes "Auteur" et sa classe m�re "Personne".<br>
 *  Les objets sont plac�s dans une collection dont le contenu est affich� plus loin gr�ce <br>
 *  � une boucle for.</p> 
 *  <ul>
 *    <li>Projets secondaires
 *      <ul>
 *        <li>Cr�er et utiliser une base de donn�es sous le format d'un fichier text ou csv qui 
 *        serait modifi� par l'utilisateur via une console Cmd.exe ou autre.</li>
 *      </ul>
 *    </li>
 *  </ul>
 */
public class Test {

	public static void main(String[] args) throws Exception {

/**
		 *  Les auteurs
		 */
		//Cr�e une liste d'auteurs � afficher apr�s instanciation de tous les "Auteur"
		List<Object> listeAuteurs = new ArrayList<>();
		
		//Cr�e un objet auteur
		Auteur mars = new Auteur("Mars","Bruno","","www.brunomars.com/fr");

		//Ajoute l'objet � la liste des auteurs
		listeAuteurs.add(mars);
		
		//Cr�e un autre auteur
		Auteur slash = new Auteur("Slash", "Slash", "https//twitter.com/slash", "");

		//Ajoute l'objet � la liste des auteurs
		listeAuteurs.add(slash);
		
		//Cr�e un autre auteur
		Auteur legardinier = new Auteur("Legardinier", "Gilles", "", "");

		
		//Ajoute l'objet � la liste des auteurs
		listeAuteurs.add(legardinier);
		
/**
		 *  Les �diteurs
		 */
		//Cr�e la liste des �diteurs comme pour les auteurs
		List<Object> listeEditeurs = new ArrayList<>();
		
		//Cr�e un �diteur
		Editeur pocket = new Editeur("Pocket", "12, Avenue d'Italie - 75013 Paris", "www.pocket.fr");
		
		//Ajoute l'�diteur � la liste
		listeEditeurs.add(pocket);
		
		/**
		 * Les produits: cds et livres seront enregistr�s dans la m�me collection
		 * pour un affichage polymorphique!
		 */
		//Test polymorphisme
		List<Object> listeDesProduits = new ArrayList<>();
/**      
         * Les livres
		 */
		//Cr�e une collection de livres
		List<Object> listeLivres = new ArrayList<>();
		
		/** Livre(String titre, String dateSortie, float prixAchat, Auteur auteur, Editeur editeur)
		 *  La date est s�curis�e
		 *  Essayez d'envoyer des lettres ou un format date �rron�: une exception personnalis�e
		 *  et customis�e est lev�e. 
		 */
		Livre CompletementCrame = new Livre("Compl�tement cram�", "13/03/2014", 7.6f, legardinier, pocket);
		listeLivres.add(CompletementCrame);
		listeDesProduits.add(CompletementCrame);//Pour le polymorphisme affich� plus bas
		Livre DemainJarrete = new Livre("Demain j'arr�te", "10-11-2011", 6.52f, legardinier, pocket);
		listeLivres.add(DemainJarrete);
		listeDesProduits.add(DemainJarrete);//Pour le polymorphisme affich� plus bas
		
/**		 
		 * Les cds 
		 */
		List<Object> listeCds = new ArrayList<>();
		Cd Unor = new Cd("Unorthodox Jukebox", "05/12/2012", 10.3f, mars);
		listeCds.add(Unor);
		listeDesProduits.add(Unor);//Pour le polymorphisme affich� plus bas
		Cd Slash = new Cd("Slash by Slash", "05/04/2010", 11.52f, slash);
		listeCds.add(Slash);
		listeDesProduits.add(Slash);//Pour le polymorphisme affich� plus bas
/**
		 *  Affiche tout
		 */
		
		//Affiche la liste des auteurs dans une boucle
		afficheLaListeDansUneBoucle(listeAuteurs, "Auteurs");
		
		//Affiche la liste des �diteurs dans une boucle
		afficheLaListeDansUneBoucle(listeEditeurs, "Editeurs");
		
		//Affiche la liste des livres dans une boucle
		afficheLaListeDansUneBoucle(listeLivres, "Livres");
		
		//Affiche la liste des cds dans une boucle
		afficheLaListeDansUneBoucle(listeCds, "Cds");
		
		//Ajoute les produits au catalogue
		List<Object> catalogue = listeDesProduits;
		
		//Tester le polymorphisme en affichant un livre issu du catalogue avec son prix de vente
		// ** polymorphisme
		// ***************
		header("polymorphisme");

		String objetSouhaite = "Livre";
		boolean flag = false;// Flag = false, drapeau baiss�, on n'a pas encore trouv� de Livre
		for(Object objet:listeDesProduits)// Bouble foreach: on lit toute la collection
		{
			while(flag == false)// Execute lignes suivantes tant que flag est faux: tant qu'on n'a pas trouv� de Livre
			{
				String className = objet.getClass().getSimpleName();//R�cup�re le type d'objet de cette collection polymorphe
				if(className.contentEquals(objetSouhaite))// Si l'objet lu � ce moment vaut "Livre" on l'affiche
				{
					System.out.println(objet.toString());// Affiche l'objet livre trouv�
					flag = true;// On l�ve le drapeau pour sortir de la boucle while et ne plus afficher d'objet
				}
			}
		}

	
		// ( Marc: maxi 15 pistes/cd: compter!)
		//Exemple: [numero=1, intitule=Gorilla, duree=Wed Dec 31 00:04:04 CET 2]
		Unor.addPiste(1, "Gorilla", 11111111);

		
		//Lister l'int�gralit� du catalogue
		// ** Le catalogue complet
		// *************************
		header("Le catalogue complet");
		for(Object entry:catalogue) {
			System.out.println(entry);
		}
		
		//Extraire les produits par types du catalogue
		// ** Les livres du catalogue
		// ***************************
		//Tester le polymorphisme en affichant un livre issu du catalogue avec son prix de vente
		// ** polymorphisme
		// ***************
		header("Les livres du catalogue");

		String objetSouhaite2 = "Livre";
		for(Object objet:catalogue)// Bouble foreach: on lit toute la collection
		{
				String className = objet.getClass().getSimpleName();//R�cup�re le type d'objet de cette collection polymorphe
				if(className.contentEquals(objetSouhaite2))// Si l'objet lu � ce moment vaut "Livre" on l'affiche
				{
					System.out.println(objet.toString());// Affiche l'objet livre trouv�
				}
		}
		
		
		// idem avec les cds
		header("Les cds du catalogue");

		String objetSouhaite3 = "Livre";
		for(Object objet:catalogue)// Bouble foreach: on lit toute la collection
		{
				String className = objet.getClass().getSimpleName();//R�cup�re le type d'objet de cette collection polymorphe
				if(className.contentEquals(objetSouhaite3))// Si l'objet lu � ce moment vaut "Livre" on l'affiche
				{
					System.out.println(objet.toString());// Affiche l'objet livre trouv�
				}
		}
		//(Marc: G�n�rer JavaDoc)
		
	
	}// Close 	public static void main(String[] args) throws Exception {
/**
 * Cette m�thode affiche l'en-t�te puis le contenu de la collection d'objets
 * 
 * @param liste
 * @param groupe
 */
	private static <T> void afficheLaListeDansUneBoucle(List<Object> liste, String groupe) {
		
		//header() cr�e un bel en-t�te
		header(groupe);
		
		//Affiche toutes les entr�es de la liste
		for(Object line:liste) {
			System.out.println(line);
		}
		
	}
/**
 * Cette m�thod affiche un bel en-t�te �toil� avec le titre qu'on lui envoie en cha�ne de caract�re
 * @param titre
 */
	private static void header(String titre) {
		
		//Affichage du nom du group entour� d'�toiles. C'est beau !
		
		System.out.println();//Une ligne vide pour l'esth�tique
		
		String header  = "** " + titre + "\n"
				       + "************************";
		
		System.out.println(header);
	}

}// Close public class Test {
