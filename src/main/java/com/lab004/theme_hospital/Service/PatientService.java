package com.lab004.theme_hospital.Service;

import java.util.List;


import com.lab004.theme_hospital.models.Consultation;
import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;

public interface PatientService {
	
	List<Patient> getPatient();

	Patient findByNom(String nom);
		
	Patient updatePatient(Long id, Patient patient);
	
	Patient savePatient(Patient patient);
	
	void deletePatient(Long id);

}
