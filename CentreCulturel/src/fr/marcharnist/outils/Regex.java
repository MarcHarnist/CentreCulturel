package fr.marcharnist.outils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		/**
		 *   AndyCode 02019-06-06
		 */
		  //Test des noms avec lookingAt()
        String verifNom = "[a-zA-Z]";
        Pattern p = Pattern.compile(verifNom);
        
        //Test avec un nom correct
        String nom = "André";
       
        Matcher m = p.matcher(nom); 
        System.out.println("Nom: "+nom);
        System.out.println("Correct ? "+m.lookingAt());
        System.out.println();
        
        //Test avec un nom incorrect
        nom = "12";
       
        m = p.matcher(nom); 
        System.out.println("Nom: "+nom);
        System.out.println("Correct ? "+m.lookingAt());
        System.out.println();
    
    //Test de l'isbn avec matches()
        String verifisbn = "[0-9]{3}-[0-9]{1}-[0-9]{3}-[0-9]{5}-[0-9]{1}";
        Pattern p1 = Pattern.compile(verifisbn);
        
        //Test avec un isbn correct
        String isbn = "978-2-409-01283-9";
       
        Matcher m1 = p1.matcher(isbn); 
        System.out.println("isbn: "+isbn);
       System.out.println("Correct ? "+m1.matches());
        System.out.println();
        
        //Test avec un isbn incorrect
        isbn = "978-2-409-01283-91";
       
        m1 = p1.matcher(isbn); 
        System.out.println("isbn: "+isbn);
        System.out.println("Correct ? "+m1.matches());
        System.out.println();
        
        //Test de l'année
        System.out.println("Test de l'année");
        String verifAnnee = "[0-9]{4}";
        Pattern p11 = Pattern.compile(verifAnnee);
        
        //Test avec un annee correcte
        String annee = "2013";
        Matcher m11 = p11.matcher(annee);
       	System.out.println(annee + " = " + m11.matches());// 2013 = true
        
        //Test avec un annee incorrecte
        String annee1 = "ffff";
        Matcher m111 = p11.matcher(annee1);
       	System.out.println(annee1 + " = " + m111.matches());//ffff = false
        

    

	}

}
