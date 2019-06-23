package fr.marcharnist.centreculturel;

/**
 * Classe m�re de Auteur et Editeur
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
	 * toString() //Retourne tout l'objet en cha�ne de caract�re

	 *   Ce qu'on pourrait am�liorer
	 *   La m�thode devrait pouvoir lire plusieurs sites web
	 *   S�parateur: /
	 *   Exemple: www.brunomars.com/fr
	 *   
	 * @return Retourne le site web de l'auteur en cha�ne de caract�re
	 */
	public String toString() {
		return this.siteWeb;
	}

}
