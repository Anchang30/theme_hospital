package com.lab004.theme_hospital.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient extends Personne implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id_patient;
	@Column(name="telPatient")
	private String tel_patient;
	@Column(name="dateNaissance")
	private LocalDate date_naissance;
	@Column(name = "adresse")
	private String adresse;
	@Column(name="num_secu")
	private Long num_secu;
	@OneToMany(mappedBy= "patient", fetch = FetchType.LAZY)
	private Collection<Consultation> consultation;
	
	
	public Patient(Long id, String nom, String prenom, String tel_patient, LocalDate date_naissance,
			String adresse, Long num_secu) {
		super(id,nom, prenom);
//		this.id_patient = id_patient;
		this.tel_patient = tel_patient;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.num_secu = num_secu;
	}
 
	public Patient () {
		
	}
//
//	public Long getId_patient() {
//		return id_patient;
//	}
//
//	public void setId_patient(Long id_patient) {
//		this.id_patient = id_patient;
//	}

	public String getTel_patient() {
		return tel_patient;
	}

	public void setTel_patient(String tel_patient) {
		this.tel_patient = tel_patient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Long getNum_secu() {
		return num_secu;
	}

	public void setNum_secu(Long num_secu) {
		this.num_secu = num_secu;
	}
	
	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}

	
}
