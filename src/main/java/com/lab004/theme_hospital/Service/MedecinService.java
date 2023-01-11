package com.lab004.theme_hospital.Service;

import java.util.List;

import com.lab004.theme_hospital.models.Patient;

public interface MedecinService {

	List<Patient> getPatients();
	
	Patient getPatientByNom(String nom);
}
