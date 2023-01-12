package com.lab004.theme_hospital.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab004.theme_hospital.DAO.ConsultationDAO;
import com.lab004.theme_hospital.models.Consultation;


@Service
public class ConsultationServiceImpl implements ConsultationService {
	
	@Autowired
	private ConsultationDAO consultationDAO;
	@Override
	public List<Consultation> getConsultation() {
		List<Consultation> consultation = (List<Consultation>) consultationDAO.findAll();
		if(!consultation.isEmpty()) {
			return consultation;
		}
		return null;
	}
	

	@Override
	public Consultation updateConsultation(Long id, Consultation consultation) {
		Optional<Consultation> retrievedConsultation = consultationDAO.findById(id);
		
		Consultation _consultation = retrievedConsultation.get();
		_consultation.setDate_rdv(consultation.getDate_rdv());
		_consultation.setHeure_rdv(consultation.getHeure_rdv());
		_consultation.setMotif(consultation.getMotif());
		
		consultationDAO.save(_consultation);
		return _consultation;
	}


	@Override
	public Consultation saveConsultation(Consultation consultation) {
		Consultation _consultation = new Consultation();
		_consultation.setDate_rdv(consultation.getDate_rdv());
		_consultation.setHeure_rdv(consultation.getHeure_rdv());
		_consultation.setMotif(consultation.getMotif());
		
		consultationDAO.save(_consultation);
		return _consultation;
	}


	@Override
	public void deleteConsultation(Long id) {
		consultationDAO.deleteById(id);
		
	}

		
}
