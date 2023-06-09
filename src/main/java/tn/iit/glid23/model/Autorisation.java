package tn.iit.glid23.model;

import java.sql.Date;

public class Autorisation {
	
	private int id;
	private String date=null;
	private int nb_heures=0;
	private int nb_semaine=0;
	private int id_enseignant=0;

	private int nb_heures_demande =0;



	private String nom;
	private String prenom;
	
	
	


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	

	public Autorisation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Autorisation(String date, int nb_heures, int nb_semaine, int id_enseignant, int nb_heures_demande) {
		super();
		this.date =  date;
		this.nb_heures = nb_heures;
		this.nb_semaine = nb_semaine;
		this.id_enseignant = id_enseignant;
		this.nb_heures_demande =nb_heures_demande;
	}





	public Autorisation(int id,String date, int nb_heures, int nb_semaine, int id_enseignant,int nb_heures_demande) {
		super();
		this.id=id;
		this.date = date;
		this.nb_heures = nb_heures;
		this.nb_semaine = nb_semaine;
		this.id_enseignant = id_enseignant;
		this.nb_heures_demande =nb_heures_demande;
	}




	public int getNb_heures_demande() {
		return nb_heures_demande;
	}




	public void setNb_heures_demande(int nb_heures_demande) {
		this.nb_heures_demande = nb_heures_demande;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
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




	public int getId_enseignant() {
		return id_enseignant;
	}




	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	}
	
	
	

}
