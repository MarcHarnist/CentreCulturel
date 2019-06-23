package fr.marcharnist.centreculturel;

import fr.marcharnist.centreculturel.Personne;;;

/**
 * Classe Editeur mère de la classe Livre
 * 
 * @author Marc L. Harnist
 * @since 1.0
 *
 */
public class Editeur extends Personne{
	
/*
	 * Les variables
	 */
	private String nomGroupe;
	private String adresse;

/**
	 * Le constructeur
	 * @param SiteWeb
	 */
	
	Editeur(String nomGroupe, String adresse, String SiteWeb) {
		super(SiteWeb);
		setNomGroupe(nomGroupe);
		setAdresse(adresse);
	}
	private void setAdresse(String adresse2) {
		this.adresse = adresse2;
}
	private void setNomGroupe(String nomGroupe2) {
		this.nomGroupe = nomGroupe2;
}
	/**
	 * Methode toString
	 * @return Nom du groupe et l'adresse
	 */
	public String toString(){
		return String.format("Nom du groupe: %s, adresse: %s, %s", this.nomGroupe, this.adresse, this.getSiteWeb());
	}
	

}
