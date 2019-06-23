package fr.marcharnist.centreculturel;

import fr.marcharnist.centreculturel.Personne;

/**
 * Classe Auteur mère de Produit
 * N'a pas accès à Produit
 * Produit a accès à Auteur (1):
 * 	- un Porduit n'a qu'1 Auteur
 * 
 * @author Marc L. Harnist
 * @since 1.0
 *
 */
public class Auteur extends Personne{
	
	/**
	 * Variables et attribruts
	 */
	private String nom;
	private String prenom;
	private String twitter;
	/**
	 * Constructeur
	 * @param nom de l'auteur
	 * @param prenom de l'auteur
	 * @param twitter: compte twitter (facultatif)
	 * @param siteWeb : site web de l'auteur facultatif)
	 */
	public Auteur(String nom, String prenom, String twitter, String siteWeb) {
		super(siteWeb);
		setNom(nom);
		setPrenom(prenom);
		setTwitter(twitter);
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the twitter
	 */
	public String getTwitter() { return twitter; }
	/**
	 * @param twitter the twitter to set
	 */
	public void setTwitter(String twitter) {
			this.twitter = twitter;
	}
	/**
	 * Méthode toString()
	 */
	public String toString() {
		return String.format("Auteur: Nom = %s, Prénom = %s, %s %s", getNom(), getPrenom(), getTwitter(), super.toString());
	}
}
