package com.lab004.theme_hospital.Service;

import java.util.List;

import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;

public interface PatientService {

	List<Medecin> getMedecins();
	
	Medecin getMedecinByNom (Medecin medecin);
	
	Patient updatePatient(Long id, Patient patient);
	
	Patient savePatient(Patient patient);
	
	// A FAIRE : UPDATE CONSULTATION 
	
	void deletePatient(Long id);

}
