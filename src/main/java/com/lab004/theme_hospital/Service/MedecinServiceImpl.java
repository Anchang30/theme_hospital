package com.lab004.theme_hospital.Service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.lab004.theme_hospital.DAO.ConsultationDAO;
import com.lab004.theme_hospital.DAO.MedecinDAO;
import com.lab004.theme_hospital.DAO.PatientDAO;
import com.lab004.theme_hospital.models.Consultation;
import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;

public class MedecinServiceImpl implements MedecinService{
	
	@Autowired
	private MedecinDAO medecinDAO;
	private ConsultationDAO consultationDAO;
	private PatientDAO patientDAO;

	@Override
	public List<Consultation> getConsultation(Long id) {
		List<Consultation> consultation = (List<Consultation>) consultationDAO.findAll();
		if(!consultation.isEmpty()) {
			return consultation;
		}
		return null;
	}

	@Override
	public Patient getPatientByNom(String nom) {
		Optional<Patient> patient = patientDAO.findByNom(nom);
		if(patient.isPresent()) {
			return patient.get();
			}
		return null;
	}

	@Override
	public Medecin updateMedecin(Long id, Medecin medecin) {
		Optional<Medecin> retrievedMedecin = medecinDAO.findById(id);
		
		Medecin _medecin = retrievedMedecin.get();
		_medecin.setNom(medecin.getNom());
		_medecin.setPrenom(medecin.getPrenom());
		_medecin.setAdresse_hospital(medecin.getAdresse_hospital());
		_medecin.setTel_hospital(medecin.getTel_hospital());
		
		medecinDAO.save(_medecin);
		return _medecin;
	}

	@Override
	public void deleteMedecin(Long id) {
		medecinDAO.deleteById(id);
		
	}

}
