package com.lab004.theme_hospital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personne")
public class Personne {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id_personne;
	@Column(name="nom")
	private String  nom;
	@Column(name="prenom")
	private String prenom;
	
	
	//Constructeurs
	public Personne( String nom, String prenom) {
		super();
//		(attribut de la classe en commentaire : Long id_personne,)
//		this.id_personne = id_personne;
		this.nom = nom;
		this.prenom = prenom;

	}	
	
	public Personne ()
		{}

//	public Long getId_personne() {
//		return id_personne;
//	}
//
//	public void setId_personne(Long id_personne) {
//		this.id_personne = id_personne;
//	}

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


	}	
	
