package com.lab004.theme_hospital.Service;

import java.util.List;
import java.util.Optional;

import com.lab004.theme_hospital.models.Consultation;
import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;

public interface PatientService {

	List<Medecin> getMedecins();
	
	// Obtenir un médecin avec son nom, ne marchait pas au début, à re-implémenter
	
	Medecin getMedecinByNom (String nome);
	
	Patient updatePatient(Long id, Patient patient);
	
	Patient savePatient(Patient patient);
	
	Consultation updateConsultation (Long id, Consultation consultation);
	
	void deletePatient(Long id);

	
}
