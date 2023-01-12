package com.lab004.theme_hospital.Service;

import java.util.List;

import com.lab004.theme_hospital.models.Medecin;




public interface MedecinService {

//	List<Consultation> getConsultation(Long id);
	
	List<Medecin> getMedecins();
	
	Medecin saveMedecin(Medecin medecin);
	
	Medecin updateMedecin(Long id, Medecin medecin);
	
	void deleteMedecin(Long id);
	
}
 