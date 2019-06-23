package fr.marcharnist.outils;

/**
 * My first enum file!
 * 
 * @author Marc L. Harnist
 * @since 2019-05-11
 * @see Openclassrooms Apprenez à programmer en Java / Découvrez les énumérations. 
 *
 */
public enum CheminBureau {

	BureauSalon("C:/Users/Isabelle/Desktop/"),
	BureauChambre("C:/Users/ADB/Desktop/");
	
	private String path;
	
	CheminBureau(String path){
		
		this.path = path;
	}
	
	public String toString() {
		return path;
	}
	
}
