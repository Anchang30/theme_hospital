package com.lab004.theme_hospital.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.lab004.theme_hospital.DAO.ConsultationDAO;
import com.lab004.theme_hospital.DAO.MedecinDAO;
import com.lab004.theme_hospital.DAO.PatientDAO;
import com.lab004.theme_hospital.models.Consultation;
import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;


@Service
public class MedecinServiceImpl implements MedecinService{
	
	@Autowired
	private MedecinDAO medecinDAO;
	@Autowired
	private ConsultationDAO consultationDAO;
	@Autowired
	private PatientDAO patientDAO;

//	@Override
//	public List<Consultation> getConsultation(Long id) {
//		List<Consultation> consultation = (List<Consultation>) consultationDAO.findAll();
//		if(!consultation.isEmpty()) {
//			return consultation;
//		}
//		return null;
//	}
	
	
	
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

	@Override
	public Medecin saveMedecin(Medecin medecin) {
	
	
		Medecin _medecin = new Medecin();
		
		_medecin.setNom(medecin.getNom());
		_medecin.setPrenom(medecin.getPrenom());
		_medecin.setAdresse_hospital(medecin.getAdresse_hospital());
		_medecin.setTel_hospital(medecin.getTel_hospital());
		
		medecinDAO.save(_medecin);
		return _medecin;
	}

	@Override
	public List<Medecin> getMedecins() {
		List<Medecin> MEDECINS = (List<Medecin>)medecinDAO.findAll();
		if(!MEDECINS.isEmpty()) {
			return MEDECINS;
		}
		else {
			return null;
		}
	}

}
