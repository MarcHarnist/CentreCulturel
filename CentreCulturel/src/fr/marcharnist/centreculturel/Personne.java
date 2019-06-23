package fr.marcharnist.centreculturel;

/**
 * Classe mère de Auteur et Editeur
 * @author ADB
 *
 */
public abstract class Personne {
	
/**
	 * Variables
	 */
	protected String siteWeb;

/**
	 * Constructeur
	 * @param SiteWeb
	 */
	Personne(String SiteWeb){
		setSiteweb(SiteWeb);
	}
	
/**
	 * Les setters
	 * @param siteWeb2
	 */
	protected void setSiteweb(String siteWeb2) {
			this.siteWeb = siteWeb2;
		}
	
	protected String getSiteWeb() {
		return this.siteWeb;
	}

/**
	 * toString() //Retourne tout l'objet en chaîne de caractère

	 *   Ce qu'on pourrait améliorer
	 *   La méthode devrait pouvoir lire plusieurs sites web
	 *   Séparateur: /
	 *   Exemple: www.brunomars.com/fr
	 *   
	 * @return Retourne le site web de l'auteur en chaîne de caractère
	 */
	public String toString() {
		return this.siteWeb;
	}

}
