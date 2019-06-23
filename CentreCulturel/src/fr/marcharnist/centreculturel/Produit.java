package fr.marcharnist.centreculturel;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.marcharnist.outils.MessageException;

public abstract class Produit extends Catalogue {
	
	private String titre;
	private LocalDate dateSortie;
	private float prixAchat;
	
	/**
	 * Constructeur
	 * @param titre
	 * @param dateSortie
	 * @param prixAchat
	 * @throws Exception
	 */
	public Produit(String titre, String dateSortie, float prixAchat) throws Exception {
		this.setTitre(titre);
		this.setDateSortie(dateSortie);
		this.setPrixAchat(prixAchat);
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the dateSortie
	 */
	public LocalDate getDateSortie() {
		return dateSortie;
	}

	/**
	 * @param dateSortie the dateSortie to set
	 */
	public void setDateSortie(String dateSortie) throws Exception{
		/**
		 * Transforme 13/10/2011 en 2011-10-13
		 */
		String dateBonFormat = "";
		String[] dateTableau = {"0","0","0"};
		
		/**
		 * MessageException reçoit en paramètre autant de chaînes de caractères
		 * souhaitées qu'il renvoie en ligne dans une message décoré en commentaire
		 * pour rendre l'exception plus claire et plus agréable à lire. 
		 *
		 */
		MessageException message = new MessageException(""
				+ "ERREUR DE DATE", 
				  "Un Objet \"Produit\" a été créé avec un format de date incorrect.",
				  "Date envoyée: " + dateSortie,
				  "Voici les formats acceptés: jj/mm/aaaa ou aaaa-mm-jj",
				  "Titre du produit concerné: " + this.titre
				  );
		//Vérifie le format de la date: doit contenir au moins deux / ou deux -
		String dateSortieTest = dateSortie;
		dateSortieTest = dateSortie.replace("-", "/");
		int nombreDeSlash = 0;
	  	for (int i = 0; i < dateSortieTest.length(); i++) 
	    if (dateSortieTest.charAt(i) == '/')             
	       nombreDeSlash++;         
		
		//Lève une exception si le format de la date n'est pas bon
		if(nombreDeSlash != 2) throw new Exception(message.toString());
		else //Le format est bon on continue
		{
			//Transforme la date en tableau pour une utilisation plus facile	
			dateTableau = dateSortieTest.split("/");

			//Verifie si la date a bien trois éléments. Sinon une nouvelle date est demandée
			if(dateTableau.length != 3) throw new Exception(message.toString());
			{
				//Inverse l'ordre des nombres si l'année est en dernier
				if(dateTableau[2].length() == 4)
				{
					dateBonFormat = dateTableau[2] + "-" + dateTableau[1] + "-" + dateTableau[0];
				}
				else //Sinon, conserve l'ordre de la date en remplaçant les / par - si besoin
				{
					dateBonFormat = dateSortie.replace("/", "-");
				}
				
				//Verifie si le format de date est bon
					
					//Transforme la date en tableau
					String[] dateTest = dateBonFormat.split("-");

					/**
					 * To do: contrôler qu'on n'a pas envoyé des lettres pour la date!
					 * Avec une regex: 0-1
					 */
					
					//Vérifie que ce sont des chiffres qui sont envoyés
					String annee = dateTest[0];//année envoyée
			        String model = "[0-9]{4}";//Une année = 4 chiffres
			        Pattern patron = Pattern.compile(model);//Crée un patron
			        Matcher formatAnnee = patron.matcher(annee);//Return boolean
			       	
			        //Vérifie le mois: il faut deux chiffres et non des lettres
			       	String mois = dateTest[1];
			       	String modelMois = "[0-9]{2}";
			       	Pattern patronMois = Pattern.compile(modelMois);
			       	Matcher formatMois = patronMois.matcher(mois);
			       	
			       	//Vérifie le jour: il faut deux chiffres comme pour le mois
			       	//On utilise le même patron que pour le mois
			       	String jour = dateTest[2];
			       	Matcher formatJour = patronMois.matcher(jour);
			       	
			       	//Ajoute un message pour le message de Exception
					message.Add("",
								"Année " + annee + " = " + formatAnnee.matches(),
								"Mois " + mois + " = " + formatMois.matches(),
								"Jour " + jour + " = " + formatJour.matches()
							);
					//La date doit faire 4 chiffres pour l'année - 2 chiffres pour les mois - 2 pour les jours
					if(!formatAnnee.matches() || !formatMois.matches() || !formatJour.matches() == true) throw new Exception(message.toString());
					{
						try {
							this.dateSortie = LocalDate.parse(dateBonFormat);
						}catch(Exception e) {
							e.printStackTrace();
						
						}
					}
				}
		}
	}

	/**
	 * @return the prixAchat
	 */
	protected float getPrixAchat() {
		return prixAchat;
	}

	/**
	 * @param prixAchat the prixAchat to set
	 */
	public void setPrixAchat(float prixAchat) {
		this.prixAchat = prixAchat;
	}
	
	public String toString() {
		return "Produit Titre: " + this.getTitre() + ", date de sortie: "+ this.getDateSortie() +
				", prix d'achat: " + this.getPrixAchat() + ", prix de vente: " +	this.getPrixVente();
	};
	
	public String toString(String auteur2) {
		String string = "Produit Titre: " + this.getTitre() + ", date de sortie: "+ this.getDateSortie() +
				", prix d'achat: " + this.getPrixAchat() + ", prix de vente: " +	this.getPrixVente() + ", auteur: " + auteur2;
		return string;
	}

	/**
	 * Calcule le prix de vente du produit en fonction du prix d'achat et d'un pourcentage
	 * @param pourcentageReduction
	 * @return
	 */
	public Object getPrixVente(float pourcentageReduction) {
		float prixVente = (float)(this.prixAchat - this.prixAchat*pourcentageReduction/100);
		prixVente = Math.round(prixVente);
		return prixVente;
		
	}
	/**
	 * @return prix de vente calculé selon le type de produit et le prix d'achat
	 */
	public Object getPrixVente() {
		
		// Récupère le nom de la classe fille qui instancie cette classe
		String typeProduit = this.getClass().getName(); //String like "com.mycompany.myclassname"

		// Définit le coefficient de marge selon le type de produit: cd ou livre
		float coefMarge = 1.25f;
		switch(typeProduit){
			case "Livre":
			coefMarge = 1.25f;
			break;
			case "Cd":
			coefMarge = 1.2f;
			break;
		}
		
		//Calcule le prix de vente: prix d'achat x coefficient de marge
		float prixVente = (float)(this.prixAchat*coefMarge);
		
		// arrondit
		prixVente = Math.round(prixVente);

		return prixVente;
	}
}
