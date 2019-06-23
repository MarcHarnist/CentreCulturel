package fr.marcharnist.centreculturel;

import java.text.ParseException;

/**
 * La clase Cd hérite de la classe Produit
 * @author Marc L. Harnist
 *
 */
public class Cd extends Produit{

	/**
	 * Les attributs du Cd
	 */
	private Auteur auteur;
	private String[] pistes = new String[15];
	private int indexPiste = 0;
	private final int maxPiste = 15;
	
	/**
	 * Constructeur de la classe Cd
	 * @param titre
	 * @param dateSortie
	 * @param prixAchat
	 * @param auteur
	 * @throws Exception
	 */
	public Cd(String titre, String dateSortie, float prixAchat, Auteur auteur) throws Exception {
		super(titre, dateSortie, prixAchat);
		this.setAuteur(auteur);
	}

	/**
	 * @return l'auteur du Cd
	 */
	public Auteur getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	/**
	 * toString()
	 *  @return coordonnées du cd et liste des pistes
	 */
	
	public String toString() {
		String pistesToString = "";
		for(String piste:pistes) {
			pistesToString = pistesToString + ", " +  piste;
		}
		return super.toString() + 
				"\n\t\tCd Pistes = " + pistesToString;
	}
	/**
	 * Ajoute une piste dans le Cd en instanciant la classe Piste
	 * @param numero
	 * @param intitule
	 * @param duree
	 * @throws ParseException
	 */
	public void addPiste(int numero, String intitule, int duree) throws ParseException {
		//On crée un objet Piste en instanciant la classe Piste
		Piste piste = new Piste(numero, intitule, duree);
		
		//Vérifie si la place est libre dans le tableau à l'index de numero
		if(pistes[numero] == "" && numero<this.maxPiste)
		{
			// la place est vide dans le tableau: on enregistre la piste
				this.pistes[numero] = "Numéro: " + numero + ", intitulé: " + ", " + piste.getIntitule() + ", durée: " +  piste.getDuree();
		} else if (this.indexPiste<this.maxPiste) //sinon on l'enregistre à la place suivante (indexPiste) si le nombre de pistes est inférieur à 16
		{
			this.pistes[this.indexPiste] = "Numéro: " + numero + ", intitulé: " + ", " + piste.getIntitule() + ", durée: " +  piste.getDuree();
		}
		
		// Incrémente l'index des pistes libres dans le cd pour l'enregistrement suivant
		addIndexPiste();
	}
	/**
	 * Incrémente l'index des pistes du CD
	 */
	private void addIndexPiste() {
		if(this.indexPiste < this.maxPiste)// Le nombre de piste est limité
			this.indexPiste++;
	}

}
