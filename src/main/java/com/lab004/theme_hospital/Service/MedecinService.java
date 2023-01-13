package com.lab004.theme_hospital.Service;

import java.util.List;

import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;




public interface MedecinService {

	List<Medecin> getMedecins();
	
	Medecin findByNom(String nom);
	
	Medecin saveMedecin(Medecin medecin);
	
	Medecin updateMedecin(Long id, Medecin medecin);
	
	void deleteMedecin(Long id);
	
}
 