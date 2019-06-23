package fr.marcharnist.outils;

public interface Chapeau {
	/**
	 * Affiche un chapeau de commentaire
	 * @param commentaire
	 */
	static void comment(String commentaire) {
		if(commentaire == "no") {
			// Cherche le nom de la méthode qui appelle la méthode courante
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
			StackTraceElement e = stacktrace[2];//The methode calling this method
			String methodName = e.getMethodName();
			
			// Affiche le chapeau: commentaire de présentation de la méthode
			System.out.println(" - méthode désactivée: \"" + methodName + "()\";");
		}
		else
		{	
			// Cherche le nom de la méthode qui appelle la méthode courante
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
			StackTraceElement e = stacktrace[2];//The methode calling this method
			String methodName = e.getMethodName();
			
			// Affiche le chapeau: commentaire de présentation de la méthode
			System.out.println("_________________________________________________________________________");
			System.out.println("\n/**  Méthode \"" + methodName + "()\"\n"
					+ "*\n"
					+ "*");
			System.out.print("* " + commentaire);
			
		}
	}
}
