package fr.marcharnist.centreculturel;

/**
 * Classe m�re de tout le projet
 * @author Marc L. Harnist
 * 
 * Ce qu'on peut am�liorer: utiliser une base de donn�e 
 *
 */
public class Catalogue {
	
	/**
	 * Attributs
	 */
	private int indexCatalogue = 0;
	@SuppressWarnings("unused")
	private final int maxEntry = 50; // Apparemment, ce catalogue ne peut contenir que cinquante entr�es
	
	/**
	 * @return the indexCatalogue
	 */
	public int getIndexCatalogue() {
		return indexCatalogue;
	}

	
	public Produit[] extract() {
		return null;
		
	}
	
	public Produit[] extract(Produit sample) {
		return null;
		
	}
	
	public Produit add(Produit produit) {
		return null;
	}
}
