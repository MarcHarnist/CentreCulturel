package fr.marcharnist.outils;

public enum ListeCheminsBin {
	
	BinCMD(""), // bin root in windows console cmd.exe
	BinEclipse("bin/");  // bin root in Eclipse console

	
	private String path;
	
	ListeCheminsBin(String path){
			
		this.path = path;
	}
		
	public String toString() {
		return path;
	}
}
