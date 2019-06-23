package fr.marcharnist.centreculturel;

/**
 * Classe mère de tout le projet
 * @author Marc L. Harnist
 * 
 * Ce qu'on peut améliorer: utiliser une base de donnée 
 *
 */
public class Catalogue {
	
	/**
	 * Attributs
	 */
	private int indexCatalogue = 0;
	@SuppressWarnings("unused")
	private final int maxEntry = 50; // Apparemment, ce catalogue ne peut contenir que cinquante entrées
	
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
