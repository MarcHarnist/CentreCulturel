package fr.marcharnist.outils;

import java.io.File;

public class FileCRUD {

	private String dir;
	private String file;

	/**
	 * Constructeur
	 */
	public FileCRUD(){}
	
	/**
	 * Delete file
	 * @author Marc Harnist
	 */
	public void deleteFile(){
		
			/** Add directory
			 * 
			 */
			String fileName = this.dir + this.file;
			boolean success = false;
			File fileToDelete = new File(fileName);
			if(fileToDelete.exists()) {
				try {
					
				fileToDelete.delete();
				success = true;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("Le fichier " + fileName   + " n'existe pas.");
			}		
			if(success == true)
				System.out.println("Le fichier " + fileName + " a été supprimé avec succès.");
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	public void setDir(String string) {
		this.dir = string;
	}
}
