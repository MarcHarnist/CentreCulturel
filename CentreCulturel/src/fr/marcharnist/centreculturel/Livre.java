package fr.marcharnist.centreculturel;

public class Livre extends Produit {
	
private Editeur editeur;
private Auteur auteur;

/**
 * @param titre
 * @param dateSortie
 * @param prixAchat
 * @param auteur
 * @param editeur
 * @throws Exception 
 */
	Livre(String titre, String dateSortie, float prixAchat, Auteur auteur, Editeur editeur) throws Exception {
		super(titre, dateSortie, prixAchat);
		this.auteur = auteur;
		this.editeur = editeur;
	}

	@Override
	public String toString() {
		String string = super.toString(auteur.toString()) 
				+ "\n\tLivre Editeur: " + editeur.toString();
		return string;
	}
	
	

}
