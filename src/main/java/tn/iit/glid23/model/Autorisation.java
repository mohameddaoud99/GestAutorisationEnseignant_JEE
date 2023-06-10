package tn.iit.glid23.model;

import java.sql.Date;

public class Autorisation {
	private int id ;
	private int id_enseignant ;
	private Date date;
	private int nb_heures;
	private int nb_semaine;
	
	public Autorisation() {
		super();
	
	}
	
	
	public Autorisation(int id_enseignant , Date date, int nb_heures,int nb_semaine) {
		super();
		this.id_enseignant  = id_enseignant ;
		this.date = date;
		this.nb_heures = nb_heures;
		this.nb_semaine = nb_semaine;
	}




	public Autorisation(int id, int id_enseignant , Date date, int nb_heures,int nb_semaine) {
		super();
		this.id = id;
		this.id_enseignant  = id_enseignant ;
		this.date = date;
		this.nb_heures = nb_heures;
		this.nb_semaine = nb_semaine;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_enseignant() {
		return id_enseignant;
	}


	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getNb_heures() {
		return nb_heures;
	}


	public void setNb_heures(int nb_heures) {
		this.nb_heures = nb_heures;
	}


	public int getNb_semaine() {
		return nb_semaine;
	}


	public void setNb_semaine(int nb_semaine) {
		this.nb_semaine = nb_semaine;
	}




	
	







	
	

}
