package com.lab004.theme_hospital.Service;

import java.util.List;


import com.lab004.theme_hospital.models.Consultation;
import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;

public interface MedecinService {

	List<Consultation> getConsultation(Long id);
	
	Patient getPatientByNom(String nom);
	
	Medecin updateMedecin(Long id, Medecin medecin);
	
	void deleteMedecin(Long id);
	
}
