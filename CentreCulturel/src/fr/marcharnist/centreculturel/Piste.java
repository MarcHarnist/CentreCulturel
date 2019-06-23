package fr.marcharnist.centreculturel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Piste {
	
	private String intitule;
	private Date duree;
	private int numero;
	

	public Piste(int numero, String intitule, int duree) throws ParseException {
		setIntitule(intitule);
		setDuree(duree);
		setNumero(numero);
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int i) {
		this.numero = i;
	}

	/**
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	/**
	 * @param intitule the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	/**
	 * @return the duree
	 */
	public Date getDuree() {
		return duree;
	}

	/**
	 * @param duree2 the duree to set
	 * @throws ParseException 
	 */
	public void setDuree(int duree2) throws ParseException {
		Integer value = duree2;
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = originalFormat.parse(value.toString());
		this.duree = date;
	}
	

}
