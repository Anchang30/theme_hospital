package com.lab004.theme_hospital.Service;

import java.util.List;

import com.lab004.theme_hospital.models.Consultation;

public interface ConsultationService {
	List<Consultation> getConsultation();
	
	Consultation findById(Long id);
	
	Consultation updateConsultation(Long id, Consultation consultation);
	
	Consultation saveConsultation(Consultation consultation);
	
	void deleteConsultation(Long id);
	

}
