package com.lab004.theme_hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab004.theme_hospital.Service.ConsultationService;
import com.lab004.theme_hospital.models.Consultation; 

	

@RestController
@RequestMapping(path="/api/consultations")	
public class ConsultationController {
  
	@Autowired
	private ConsultationService consultationService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Consultation>> getConsultation() {
		try {
			List<Consultation> consultations = consultationService.getConsultation();
			return new ResponseEntity<>(consultations, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Consultation> updateConsultation(@PathVariable Long id, @RequestBody Consultation consultation){
		try {
			return new ResponseEntity<Consultation>(consultationService.updateConsultation(id, consultation), HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/")
	public ResponseEntity<Consultation> saveConsultation(@RequestBody Consultation consultation) {
		try {
			return new ResponseEntity<>(consultationService.saveConsultation(consultation), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping(path="/{id}")
	public void deleteMedecin(@PathVariable Long id) {
		consultationService.deleteConsultation(id);
	}
}
