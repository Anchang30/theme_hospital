package com.lab004.theme_hospital.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab004.theme_hospital.DAO.MedecinDAO;
import com.lab004.theme_hospital.DAO.PatientDAO;
import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDAO patientDAO;
	private MedecinDAO medecinDAO;
	
	@Override
	public List<Medecin> getMedecins() {
		List<Medecin> MEDECINS = (List<Medecin>)medecinDAO.findAll();
		if(!MEDECINS.isEmpty()) {
			return MEDECINS;
		}
		return null;
	}

	@Override
	public Medecin getMedecinByNom(Medecin medecin) {
		Optional<Medecin> retrievedMedecin = patientDAO.findByNom(medecin);
		if (retrievedMedecin.isPresent()) {
			return retrievedMedecin.get();
			}
		return null;
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
		Optional<Patient> retrievedPatient = patientDAO.findById(id);
		
		Patient _patient = retrievedPatient.get();
		
		_patient.setNom(patient.getNom());
		_patient.setPrenom(patient.getPrenom());
		_patient.setDate_naissance(patient.getDate_naissance());
		_patient.setNum_secu(patient.getNum_secu());
		_patient.setAdresse(patient.getAdresse());
		_patient.setTel_patient(patient.getTel_patient());
		
		patientDAO.save(_patient);
		return _patient;
	}

	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePatient(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
