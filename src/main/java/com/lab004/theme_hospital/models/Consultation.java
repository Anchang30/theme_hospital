package com.lab004.theme_hospital.models;
 
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="consultation")
public class Consultation  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_consultation;
	@Column(name="dateRdv")
	private LocalDate date_rdv;
	@Column(name="heureRdv")
	private LocalTime heure_rdv;
	@Column(name="motif")
	private String motif;
	@ManyToOne
	@JoinColumn(name = "ID_PATIENT", nullable = false)
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="ID_MEDECIN", nullable = false)
	private Medecin medecin;
	
	public Consultation(Long id_consultation, LocalDate date_rdv, LocalTime heure_rdv, String motif, Patient patient, Medecin medecin) {
		this.id_consultation = id_consultation;
		this.date_rdv = date_rdv;
		this.heure_rdv = heure_rdv;
		this.motif = motif;
		this.patient = patient;
		this.medecin = medecin;
	}



	public Consultation() {
	}

	public Long getId_consultation() {
		return id_consultation;
	}

	public void setId_consultation(Long id_consultation) {
		this.id_consultation = id_consultation;
	}

	public LocalDate getDate_rdv() {
		return date_rdv;
	}

	public void setDate_rdv(LocalDate date_rdv) {
		this.date_rdv = date_rdv;
	}

	public LocalTime getHeure_rdv() {
		return heure_rdv;
	}

	public void setHeure_rdv(LocalTime heure_rdv) {
		this.heure_rdv = heure_rdv;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
}
