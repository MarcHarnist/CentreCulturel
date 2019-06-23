package fr.marcharnist.outils;

/**
 * Customise les messages des exceptions
 * Arguments: on peut envoyer autant de chaînes de caratères une pour chaque ligne.
 * Elles seront traitées grâce à une méthode variadique
 * 
 * @author Marc Harnist
 */
public class MessageException {
	
	public String margeGauche = "\t";
	public String header = "\n\n" + this.margeGauche + "/** ";
	public String body = "";
	public String footer = "\n" + this.margeGauche  + "*/\n\n";
	
	public MessageException(String ... strings){
		setMessage(strings);
	}

	private void setMessage(String[] strings) {
		String m = this.margeGauche;
		int i = 0;
		for(i = 0; i<strings.length-1; i++) {
			this.body = this.body + strings[i] + "\n" +  m + "*    - ";
		}
		this.body = this.body + strings[i];
		
	}

	public String toString() {
		return this.header + this.body + this.footer;
	}

	public void Add(String ...strings) {
		setMessage(strings);
	}
}
