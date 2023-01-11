package com.lab004.theme_hospital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="nom")
	private String  nom;
	@Column(name="prenom")
	private String prenom;
	
	
	//Constructeurs
	public Personne( Long id, String nom, String prenom) {
		super();

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;

	}	
	
	public Personne ()
		{}

	//GETTERS AND SETTERS 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
