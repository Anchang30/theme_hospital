package com.lab004.theme_hospital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Medecin")
public class Medecin extends Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_medecin;
	@Column(name="telHospital")
	private String tel_hospital;
	@Column(name="adresseHospital")
	private String adresse_hospital;
	@OneToMany(mappedBy="consultation", fetch = FetchType.LAZY)
	private Consultation consultation;
	
	public Medecin(String nom, String prenom, Long id_medecin, String tel_hospital, String adresse_hospital, Consultation consultation) {
		super(nom, prenom);
		this.id_medecin = id_medecin;
		this.tel_hospital = tel_hospital;
		this.adresse_hospital = adresse_hospital;
		this.consultation = consultation;
	}

	public Long getId_medecin() {
		return id_medecin;
	}

	public void setId_medecin(Long id_medecin) {
		this.id_medecin = id_medecin;
	}

	public String getTel_hospital() {
		return tel_hospital;
	}

	public void setTel_hospital(String tel_hospital) {
		this.tel_hospital = tel_hospital;
	}

	public String getAdresse_hospital() {
		return adresse_hospital;
	}

	public void setAdresse_hospital(String adresse_hospital) {
		this.adresse_hospital = adresse_hospital;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	
}
